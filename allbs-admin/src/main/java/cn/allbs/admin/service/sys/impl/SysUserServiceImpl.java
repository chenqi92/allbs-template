package cn.allbs.admin.service.sys.impl;

import cn.allbs.admin.config.dto.UserInfo;
import cn.allbs.admin.dao.sys.SysUserDao;
import cn.allbs.admin.dto.sys.SysUserDTO;
import cn.allbs.admin.entity.sys.SysRoleEntity;
import cn.allbs.admin.entity.sys.SysUserEntity;
import cn.allbs.admin.entity.sys.SysUserRoleEntity;
import cn.allbs.admin.service.sys.SysMenuService;
import cn.allbs.admin.service.sys.SysRoleService;
import cn.allbs.admin.service.sys.SysUserRoleService;
import cn.allbs.admin.service.sys.SysUserService;
import cn.allbs.admin.vo.sys.SysMenuVO;
import cn.allbs.admin.vo.sys.SysUserVO;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 用户表(sys_user)表服务实现类
 *
 * @author chenqi
 * @since 2023-08-15 15:34:12
 */
@Service("sysUserService")
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    private final SysUserDao sysUserDao;

    private final SysUserRoleService sysUserRoleService;

    private final SysMenuService sysMenuService;

    private final SysRoleService sysRoleService;

    /**
     * 分页查询所有数据
     *
     * @param page       分页参数
     * @param sysUserDTO 查询参数
     * @return 指定页码和条数的数据
     */
    @Override
    public IPage<SysUserVO> queryPage(Page<SysUserDTO> page, SysUserDTO sysUserDTO) {
        return this.sysUserDao.queryList(page, sysUserDTO);
    }

    /**
     * 查询所有数据
     *
     * @param sysUserDTO 查询参数
     * @return 所有数据
     */
    @Override
    public List<SysUserVO> queryList(SysUserDTO sysUserDTO) {
        return this.sysUserDao.queryList(sysUserDTO);
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户
     * @return userInfo
     */
    @Override
    public UserInfo findUserInfoByUserName(String username) {
//        Cache cache = cacheManager.getCache(USER_DETAILS);
//        if (cache != null && cache.get(username) != null) {
//            return cache.get(username, UserInfo.class);
//        }
        SysUserEntity sysUserEntity = sysUserDao.selectOne(Wrappers.<SysUserEntity>query().lambda().eq(SysUserEntity::getUsername, username));
        if (BeanUtil.isEmpty(sysUserEntity)) {
            return null;
        }
        UserInfo userInfo = this.getUserInfo(sysUserEntity);
//        assert cache != null;
//        cache.put(username, userInfo);
        return userInfo;
    }

    /**
     * 构建userInfo 用户信息 + 角色信息 + 权限集合
     *
     * @param user 用户信息
     * @return 需要构建的用户信息
     */
    private UserInfo getUserInfo(SysUserEntity user) {
        UserInfo userInfo = new UserInfo();
        // 用户基本信息
        userInfo.setSysUser(user);
        // 查询用户对于的角色列表
        Set<Long> roleIds = Optional.ofNullable(sysUserRoleService.list(Wrappers.<SysUserRoleEntity>query()
                        .lambda().eq(SysUserRoleEntity::getUserId, user.getUserId())))
                .orElse(new ArrayList<>()).stream()
                .map(a -> Convert.toLong(a.getRoleId()))
                .collect(Collectors.toSet());
        // 权限标识集合
        Set<String> permissions = new HashSet<>();
        roleIds.forEach(roleId -> {
            List<String> permissionList = sysMenuService.findMenuByRoleId(roleId).stream().map(SysMenuVO::getPermission).filter(StringUtils::isNotEmpty).collect(Collectors.toList());
            permissions.addAll(permissionList);
        });
        userInfo.setPermissions(ArrayUtil.toArray(permissions, String.class));
        // 查询并设置角色列表
        List<SysRoleEntity> roleEntities = sysRoleService.list(Wrappers.<SysRoleEntity>query().lambda().in(SysRoleEntity::getRoleId, roleIds));
        if (CollUtil.isNotEmpty(roleEntities)) {
            userInfo.setRoleName(ArrayUtil.toArray(roleEntities.stream().map(SysRoleEntity::getRoleName).collect(Collectors.toList()), String.class));
        }
        return userInfo;
    }
}
