package cn.allbs.admin.vo.sys;


import java.time.LocalDateTime;

import cn.allbs.admin.entity.sys.SysParamEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 公共参数配置表(sys_param)VO
 *
 * @author chenqi
 * @since 2023-08-15 15:34:16
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "公共参数配置表 数据展示类", name = "SysParamVO")
public class SysParamVO extends SysParamEntity {
}
