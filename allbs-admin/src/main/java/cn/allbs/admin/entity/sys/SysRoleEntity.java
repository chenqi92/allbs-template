package cn.allbs.admin.entity.sys;


import java.io.Serial;
import java.time.LocalDateTime;

import cn.allbs.admin.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统角色表(sys_role)表实体类
 *
 * @author chenqi
 * @since 2023-08-15 16:11:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "系统角色表", name = "sys_role")
@TableName("sys_role")
public class SysRoleEntity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 505616441012375204L;

    @TableId(value = "role_id", type = IdType.AUTO)
    @Schema(description = "角色id", name = "roleId", implementation = Long.class)
    private Long roleId;

    @Schema(description = "角色名称", name = "roleName", implementation = String.class)
    private String roleName;

    @Schema(description = "角色编码", name = "roleCode", implementation = String.class)
    private String roleCode;

    @Schema(description = "角色描述", name = "roleDesc", implementation = String.class)
    private String roleDesc;
}
