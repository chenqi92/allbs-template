package cn.allbs.admin.entity.sys;


import cn.allbs.admin.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 公共参数配置表(sys_param)表实体类
 *
 * @author chenqi
 * @since 2023-08-15 16:11:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "公共参数配置表", name = "sys_param")
@TableName("sys_param")
public class SysParamEntity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 778287383352720634L;

    @TableId(value = "param_id", type = IdType.AUTO)
    @Schema(description = "主键", name = "paramId", implementation = Long.class)
    private Long paramId;

    @Schema(description = "参数名称", name = "paramName", implementation = String.class)
    private String paramName;

    @Schema(description = "参数key", name = "paramKey", implementation = String.class)
    private String paramKey;

    @Schema(description = "参数值", name = "paramValue", implementation = String.class)
    private String paramValue;

    @Schema(description = "状态", name = "status", implementation = Integer.class)
    private Integer status;

    @Schema(description = "参数值验证", name = "validateCode", implementation = String.class)
    private String validateCode;

    @Schema(description = "参数类型", name = "paramType", implementation = Integer.class)
    private Integer paramType;

    @Schema(description = "生效系统", name = "system", implementation = Integer.class)
    private Integer system;
}
