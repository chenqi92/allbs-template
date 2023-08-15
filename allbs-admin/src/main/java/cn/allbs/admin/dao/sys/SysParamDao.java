package cn.allbs.admin.dao.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.allbs.admin.entity.sys.SysParamEntity;
import cn.allbs.admin.dto.sys.SysParamDTO;
import cn.allbs.admin.vo.sys.SysParamVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 公共参数配置表(sys_param)表数据库访问层
 *
 * @author chenqi
 * @since 2023-08-15 15:34:16
 */
@Mapper
public interface SysParamDao extends BaseMapper<SysParamEntity> {

    /**
     * 分页查询所有数据
     *
     * @param page        分页参数
     * @param sysParamDTO 查询参数
     * @return IPage<SysParamVO>
     */
    IPage<SysParamVO> queryList(Page<SysParamDTO> page, @Param("sysParamDTO") SysParamDTO sysParamDTO);

    /**
     * 查询所有数据
     *
     * @param sysParamDTO 查询参数
     * @return List<SysParamVO>
     */
    List<SysParamVO> queryList(@Param("sysParamDTO") SysParamDTO sysParamDTO);
}
