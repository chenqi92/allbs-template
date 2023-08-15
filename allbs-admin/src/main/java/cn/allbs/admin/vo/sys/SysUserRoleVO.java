package cn.allbs.admin.vo.sys;


import cn.allbs.admin.entity.sys.SysUserRoleEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户角色表(sys_user_role)VO
 *
 * @author chenqi
 * @since 2023-08-15 15:34:13
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "用户角色表 数据展示类", name = "SysUserRoleVO")
public class SysUserRoleVO extends SysUserRoleEntity {
}
