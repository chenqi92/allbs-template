package cn.allbs.admin.config.log.aop;

import cn.allbs.admin.config.log.dto.SysLogInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 类 SysLogEvent 日志事件
 *
 * @author ChenQi
 * @date 2023/5/11
 */
@Getter
@AllArgsConstructor
public class SysLogEvent {

    private final SysLogInfo sysLog;
}
