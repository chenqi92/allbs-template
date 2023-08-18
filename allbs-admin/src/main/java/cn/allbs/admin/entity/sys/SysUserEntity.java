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
 * 用户表(sys_user)表实体类
 *
 * @author chenqi
 * @since 2023-08-15 16:11:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "用户表", name = "sys_user")
@TableName("sys_user")
public class SysUserEntity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -71736497537934016L;

    @TableId(value = "user_id", type = IdType.AUTO)
    @Schema(description = "主键ID", name = "userId", implementation = Long.class)
    private Long userId;

    @Schema(description = "用户名", name = "username", implementation = String.class)
    private String username;

    @Schema(description = "密码", name = "password", implementation = String.class)
    private String password;

    @Schema(description = "盐值", name = "salt", implementation = String.class)
    private String salt;

    @Schema(description = "手机号", name = "phone", implementation = String.class)
    private String phone;

    @Schema(description = "头像", name = "avatar", implementation = String.class)
    private String avatar;

    @Schema(description = "部门ID", name = "deptId", implementation = Long.class)
    private Long deptId;

    @Schema(description = "锁定状态", name = "lockFlag", implementation = Integer.class)
    private Integer lockFlag;
}
