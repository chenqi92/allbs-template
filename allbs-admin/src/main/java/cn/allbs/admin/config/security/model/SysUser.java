package cn.allbs.admin.config.security.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.User;

import java.io.Serial;
import java.util.Collection;

/**
 * 类 SysUser
 *
 * @author ChenQi
 * @date 2023/8/18
 */
@Getter
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysUser extends User {

    /**
     * 用户ID
     */
    private final Long id;
    /**
     * 手机号
     */
    private final String phone;

    /**
     * 头像
     */
    private final String avatar;

    @Serial
    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    public SysUser(Long id, String phone, String avatar, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
        this.phone = phone;
        this.avatar = avatar;
    }
}
