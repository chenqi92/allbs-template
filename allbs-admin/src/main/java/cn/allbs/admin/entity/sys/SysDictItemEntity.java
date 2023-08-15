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
 * 字典项(sys_dict_item)表实体类
 *
 * @author chenqi
 * @since 2023-08-15 16:11:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "字典项", name = "sys_dict_item")
@TableName("sys_dict_item")
public class SysDictItemEntity extends BaseEntity {

    private static final long serialVersionUID = 885846109560125106L;

    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键", name = "id", implementation = Long.class)
    private Long id;

    @Schema(description = "字典表主键", name = "dictId", implementation = Long.class)
    private Long dictId;

    @Schema(description = "字典值", name = "value", implementation = String.class)
    private String value;

    @Schema(description = "展示值", name = "label", implementation = String.class)
    private String label;

    @Schema(description = "字典编码", name = "type", implementation = String.class)
    private String type;

    @Schema(description = "描述", name = "description", implementation = String.class)
    private String description;

    @Schema(description = "排序（升序）", name = "sort", implementation = Integer.class)
    private Integer sort;

    @Schema(description = "备注", name = "remarks", implementation = String.class)
    private String remarks;
}
