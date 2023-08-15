package cn.allbs.admin.config.log.listener;

import cn.allbs.admin.config.log.aop.SysLogEvent;
import cn.allbs.admin.entity.sys.SysLogEntity;
import cn.allbs.admin.service.sys.SysLogService;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

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
        SysLogEntity logEntity = new SysLogEntity(event.getSysLog());
        logService.save(logEntity);
    }
}
