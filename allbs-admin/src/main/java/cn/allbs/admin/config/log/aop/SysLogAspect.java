package cn.allbs.admin.config.log.aop;

import cn.allbs.admin.config.log.annotation.SysLog;
import cn.allbs.admin.config.log.dto.SysLogInfo;
import cn.allbs.common.enums.LogTypeEnum;
import cn.hutool.core.util.URLUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 类 SysLogAspect 日志处理
 *
 * @author ChenQi
 * @date 2023/5/11
 */
@Slf4j
@Aspect
@RequiredArgsConstructor
@Component
public class SysLogAspect {

    private final ApplicationEventPublisher publisher;

    @SneakyThrows
    @Around("@annotation(sysLog)")
    public Object around(ProceedingJoinPoint point, SysLog sysLog) {
        String strClassName = point.getTarget().getClass().getName();
        String strMethodName = point.getSignature().getName();
        log.debug("请求日志:[类名]:{},[方法]:{}", strClassName, strMethodName);

        SysLogInfo logVo = getSysLog();
        logVo.setTitle(sysLog.value());
        // 发送异步日志事件
        Long startTime = System.currentTimeMillis();
        Object obj;
        try {
            obj = point.proceed();
        } catch (Exception e) {
            logVo.setType(Integer.valueOf(LogTypeEnum.ERROR.getType()));
            logVo.setException(e.getMessage());
            throw e;
        } finally {
            Long endTime = System.currentTimeMillis();
            logVo.setTime(endTime - startTime);
            publisher.publishEvent(new SysLogEvent(logVo));
        }
        return obj;
    }

    private SysLogInfo getSysLog() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects
                .requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        SysLogInfo sysLog = new SysLogInfo();
        sysLog.setType(Integer.valueOf(LogTypeEnum.NORMAL.getType()));
        sysLog.setRemoteAddr(getClientIp(request));
        sysLog.setRequestUri(URLUtil.getPath(request.getRequestURI()));
        sysLog.setMethod(request.getMethod());
        sysLog.setUserAgent(request.getHeader("user-agent"));
        Map<String, Object> params = request.getParameterMap().entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        v -> v.getValue()[0],
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        sysLog.setParams(URLUtil.buildQuery(params, Charset.defaultCharset()));
        return sysLog;
    }

    public static String getClientIp(HttpServletRequest request) {
        // 获取X-Forwarded-For头，该头会由许多代理服务器设置
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        // 如果通过代理访问，X-Forwarded-For可能包含多个IP，取第一个
        if (ip != null && ip.contains(",")) {
            ip = ip.split(",")[0];
        }
        return ip;
    }
}
