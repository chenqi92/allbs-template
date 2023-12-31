package cn.allbs.admin.entity.sys;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户角色表(sys_user_role)表实体类
 *
 * @author chenqi
 * @since 2023-08-15 16:11:21
 */
@Data
@Schema(description = "用户角色表", name = "sys_user_role")
@TableName("sys_user_role")
public class SysUserRoleEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -81993647298771721L;

    @TableId(value = "user_id", type = IdType.AUTO)
    @Schema(description = "用户ID", name = "userId", implementation = Long.class)
    private Long userId;

    @Schema(description = "角色ID", name = "roleId", implementation = Long.class)
    private Long roleId;
}
