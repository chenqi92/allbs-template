package cn.allbs.admin.entity.sys;


import java.time.LocalDateTime;

import cn.allbs.admin.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典表(sys_dict)表实体类
 *
 * @author chenqi
 * @since 2023-08-15 16:11:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "字典表", name = "sys_dict")
@TableName("sys_dict")
public class SysDictEntity extends BaseEntity {

    private static final long serialVersionUID = -77333809547814825L;

    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键", name = "id", implementation = Long.class)
    private Long id;

    @Schema(description = "字典编码", name = "type", implementation = String.class)
    private String type;

    @Schema(description = "描述", name = "description", implementation = String.class)
    private String description;

    @Schema(description = "备注", name = "remarks", implementation = String.class)
    private String remarks;

    @Schema(description = "生效系统", name = "system", implementation = Integer.class)
    private Integer system;
}
