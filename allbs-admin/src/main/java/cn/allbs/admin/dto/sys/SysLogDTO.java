package cn.allbs.admin.dto.sys;


import java.time.LocalDateTime;

import cn.allbs.admin.entity.sys.SysLogEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 日志表(sys_log)DTO
 *
 * @author chenqi
 * @since 2023-08-15 15:34:14
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "日志表 参数接收类", name = "SysLogDTO")
public class SysLogDTO extends SysLogEntity {

}
