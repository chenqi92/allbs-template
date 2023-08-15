package cn.allbs.admin.config.log.aop;

import cn.allbs.admin.config.log.annotation.SysLog;
import cn.allbs.admin.config.log.dto.SysLogDto;
import cn.allbs.common.enums.LogTypeEnum;
import cn.allbs.common.utils.ServletUtil;
import cn.hutool.core.util.URLUtil;
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

import javax.servlet.http.HttpServletRequest;
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

        SysLogDto logVo = getSysLog();
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

    private SysLogDto getSysLog() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects
                .requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        SysLogDto sysLog = new SysLogDto();
        sysLog.setType(Integer.valueOf(LogTypeEnum.NORMAL.getType()));
        sysLog.setRemoteAddr(ServletUtil.getClientIP(request));
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
}
