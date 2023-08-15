package cn.allbs.admin.vo.sys;


import java.time.LocalDateTime;

import cn.allbs.admin.entity.sys.SysLogEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * 日志表(sys_log)VO
 *
 * @author chenqi
 * @since 2023-08-15 15:34:14
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "日志表 数据展示类", name = "SysLogVO")
public class SysLogVO extends SysLogEntity {
}
