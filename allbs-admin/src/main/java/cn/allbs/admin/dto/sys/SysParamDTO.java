package cn.allbs.admin.dto.sys;


import java.time.LocalDateTime;

import cn.allbs.admin.entity.sys.SysParamEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 公共参数配置表(sys_param)DTO
 *
 * @author chenqi
 * @since 2023-08-15 15:34:16
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "公共参数配置表 参数接收类", name = "SysParamDTO")
public class SysParamDTO extends SysParamEntity {
}
