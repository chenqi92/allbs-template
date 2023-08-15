package cn.allbs.admin.service.sys.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.allbs.admin.dao.sys.SysParamDao;
import cn.allbs.admin.entity.sys.SysParamEntity;
import cn.allbs.admin.dto.sys.SysParamDTO;
import cn.allbs.admin.vo.sys.SysParamVO;
import cn.allbs.admin.service.sys.SysParamService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * 公共参数配置表(sys_param)表服务实现类
 *
 * @author chenqi
 * @since 2023-08-15 15:34:16
 */
@Service("sysParamService")
@RequiredArgsConstructor
public class SysParamServiceImpl extends ServiceImpl<SysParamDao, SysParamEntity> implements SysParamService {

    private final SysParamDao sysParamDao;

    /**
     * 分页查询所有数据
     *
     * @param page        分页参数
     * @param sysParamDTO 查询参数
     * @return 指定页码和条数的数据
     */
    @Override
    public IPage<SysParamVO> queryPage(Page<SysParamDTO> page, SysParamDTO sysParamDTO) {
        return this.sysParamDao.queryList(page, sysParamDTO);
    }

    /**
     * 查询所有数据
     *
     * @param sysParamDTO 查询参数
     * @return 所有数据
     */
    @Override
    public List<SysParamVO> queryList(SysParamDTO sysParamDTO) {
        return this.sysParamDao.queryList(sysParamDTO);
    }
}
