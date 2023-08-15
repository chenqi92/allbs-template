package cn.allbs.admin.entity.sys;


import cn.allbs.admin.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门关系表(sys_dept_relation)表实体类
 *
 * @author chenqi
 * @since 2023-08-15 16:11:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "部门关系表", name = "sys_dept_relation")
@TableName("sys_dept_relation")
public class SysDeptRelationEntity extends BaseEntity {

    private static final long serialVersionUID = 550065197032004770L;

    @TableId(value = "ancestor", type = IdType.AUTO)
    @Schema(description = "祖先节点", name = "ancestor", implementation = Long.class)
    private Long ancestor;

    @Schema(description = "后代节点", name = "descendant", implementation = Long.class)
    private Long descendant;
}
