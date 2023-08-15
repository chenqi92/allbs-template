package cn.allbs.admin.service.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.allbs.admin.entity.sys.SysMenuEntity;
import cn.allbs.admin.dto.sys.SysMenuDTO;
import cn.allbs.admin.vo.sys.SysMenuVO;

import java.util.List;

/**
 * 菜单权限表(sys_menu)表服务接口
 *
 * @author chenqi
 * @since 2023-08-15 15:34:15
 */
public interface SysMenuService extends IService<SysMenuEntity> {

    /**
     * 分页查询所有数据
     *
     * @param page       分页参数
     * @param sysMenuDTO 查询参数
     * @return IPage<SysMenuVO> sysMenuDTO
     */
    IPage<SysMenuVO> queryPage(Page<SysMenuDTO> page, SysMenuDTO sysMenuDTO);

    /**
     * 查询所有数据
     *
     * @param sysMenuDTO 查询参数
     * @return List<SysMenuVO>
     */
    List<SysMenuVO> queryList(SysMenuDTO sysMenuDTO);
}
