package cn.allbs.admin.service.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.allbs.admin.entity.sys.SysParamEntity;
import cn.allbs.admin.dto.sys.SysParamDTO;
import cn.allbs.admin.vo.sys.SysParamVO;

import java.util.List;

/**
 * 公共参数配置表(sys_param)表服务接口
 *
 * @author chenqi
 * @since 2023-08-15 15:34:16
 */
public interface SysParamService extends IService<SysParamEntity> {

    /**
     * 分页查询所有数据
     *
     * @param page        分页参数
     * @param sysParamDTO 查询参数
     * @return IPage<SysParamVO> sysParamDTO
     */
    IPage<SysParamVO> queryPage(Page<SysParamDTO> page, SysParamDTO sysParamDTO);

    /**
     * 查询所有数据
     *
     * @param sysParamDTO 查询参数
     * @return List<SysParamVO>
     */
    List<SysParamVO> queryList(SysParamDTO sysParamDTO);
}
