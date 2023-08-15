package cn.allbs.admin.config.log.listener;

import cn.allbs.admin.config.log.aop.SysLogEvent;
import cn.allbs.admin.config.log.dto.SysLogInfo;
import cn.allbs.admin.entity.sys.SysLogEntity;
import cn.allbs.admin.service.sys.SysLogService;
import cn.hutool.core.convert.Convert;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 类 TLogListener
 *
 * @author ChenQi
 * @date 2023/5/11
 */
@AllArgsConstructor
@Component
public class SysLogListener {

    private final SysLogService logService;

    @Async
    @Order
    @EventListener(SysLogEvent.class)
    public void saveSysLog(SysLogEvent event) {
        SysLogInfo info = event.getSysLog();
        SysLogEntity log = new SysLogEntity();
        log.setType(info.getType());
        log.setTitle(info.getTitle());
        log.setServiceId(info.getServiceId());
        log.setRemoteAddr(info.getRemoteAddr());
        log.setUserAgent(info.getUserAgent());
        log.setRequestUri(info.getRequestUri());
        log.setMethod(info.getMethod());
        log.setParams(info.getParams());
        log.setTime(info.getTime());
        log.setException(info.getException());
        log.setCreateTime(LocalDateTime.now());
        log.setCreateBy(info.getUserName());
        logService.save(log);
    }
}
