package cn.allbs.admin.entity.sys;


import cn.allbs.admin.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色菜单表(sys_role_menu)表实体类
 *
 * @author chenqi
 * @since 2023-08-15 16:11:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "角色菜单表", name = "sys_role_menu")
@TableName("sys_role_menu")
public class SysRoleMenuEntity extends BaseEntity {

    private static final long serialVersionUID = -89549119540949672L;

    @TableId(value = "role_id", type = IdType.AUTO)
    @Schema(description = "角色ID", name = "roleId", implementation = Long.class)
    private Long roleId;

    @Schema(description = "菜单ID", name = "menuId", implementation = Long.class)
    private Long menuId;
}
