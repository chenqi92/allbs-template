package cn.allbs.admin.config.security.model;

import cn.allbs.admin.entity.sys.SysUserEntity;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 类 UserInfo 用户信息
 *
 * @author ChenQi
 * @date 2023/8/18
 */
@Data
public class UserInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户信息
     */
    private SysUserEntity sysUser;


    /**
     * 权限列表
     */
    private String[] permissions;

    /**
     * 校色标识
     */
    private String[] roleName;
}
