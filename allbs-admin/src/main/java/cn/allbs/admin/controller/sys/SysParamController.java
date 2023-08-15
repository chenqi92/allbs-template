package cn.allbs.admin.controller.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.allbs.common.utils.R;
import cn.allbs.admin.config.log.annotation.SysLog;
import cn.allbs.admin.entity.sys.SysParamEntity;
import cn.allbs.admin.dto.sys.SysParamDTO;
import cn.allbs.admin.vo.sys.SysParamVO;
import cn.allbs.admin.service.sys.SysParamService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * 公共参数配置表(sys_param)表控制层
 *
 * @author chenqi
 * @since 2023-08-15 15:34:16
 */
@Hidden
@RestController
@AllArgsConstructor
@RequestMapping("/sys/param")
@Api(value = "sysParam", tags = "公共参数配置表 管理")
public class SysParamController {

    /**
     * 服务对象
     */
    private final SysParamService sysParamService;

    /**
     * 分页查询所有公共参数配置表信息
     *
     * @return List<SysParamDTO> 分页当前账户下所有公共参数配置表信息
     */
    @Operation(description = "分页公共参数配置表信息表数据", summary = "分页查询公共参数配置表信息表数据", tags = {"分页查询所有数据"})
    @GetMapping("queryPage")
    @Parameters({@Parameter(description = "当前页", name = "current", in = ParameterIn.QUERY, required = true, schema = @Schema(implementation = Integer.class)), @Parameter(description = "当前页条数", name = "size", in = ParameterIn.QUERY, required = true, schema = @Schema(implementation = Integer.class))})
    public R<IPage<SysParamVO>> queryPage(@ParameterObject Page<SysParamDTO> page, @ParameterObject SysParamDTO sysParamDTO) {
        return R.ok(this.sysParamService.queryPage(page, sysParamDTO));
    }

    /**
     * 查询所有公共参数配置表信息
     *
     * @return List<SysParamEntity> 当前账户下所有公共参数配置表信息
     */
    @Operation(description = "查询公共参数配置表信息表数据", summary = "查询公共参数配置表信息表数据", tags = {"查询所有数据"})
    @GetMapping("queryList")
    public R<List<SysParamVO>> queryList(@ParameterObject SysParamDTO sysParamDTO) {
        return R.ok(this.sysParamService.queryList(sysParamDTO));
    }

    /**
     * 通过id查询 公共参数配置表
     *
     * @param paramId 主键
     * @return R
     */
    @Operation(description = "通过paramId查询", summary = "通过paramId查询", tags = {"主键查询"})
    @GetMapping("/{paramId}")
    @PreAuthorize("@pms.hasPermission('sysParam_list')")
    public R<SysParamEntity> getById(@PathVariable("paramId") Long paramId) {
        return R.ok(this.sysParamService.getById(paramId));
    }

    /**
     * 新增 公共参数配置表
     *
     * @param sysParamEntity 公共参数配置表
     * @return R
     */
    @Operation(description = "新增公共参数配置表", summary = "新增公共参数配置表", tags = {"数据新增"})
    @SysLog("新增公共参数配置表")
    @PostMapping
    @PreAuthorize("@pms.hasPermission('sysParam_save')")
    public R<Boolean> save(@RequestBody SysParamEntity sysParamEntity) {
        return R.ok(this.sysParamService.save(sysParamEntity));
    }

    /**
     * 修改公共参数配置表
     *
     * @param sysParamEntity 公共参数配置表
     * @return R
     */
    @Operation(description = "修改公共参数配置表", summary = "修改公共参数配置表", tags = {"数据更新"})
    @SysLog("修改公共参数配置表")
    @PutMapping
    @PreAuthorize("@pms.hasPermission('sysParam_update')")
    public R<Boolean> updateById(@RequestBody SysParamEntity sysParamEntity) {
        return R.ok(this.sysParamService.updateById(sysParamEntity));
    }

    /**
     * 通过paramId 删除公共参数配置表
     *
     * @param paramId 主键
     * @return R
     */
    @PreAuthorize("@pms.hasPermission('sysParam_delete')")
    @Operation(description = "通过paramId 删除公共参数配置表", summary = "通过paramId 删除公共参数配置表", tags = {"数据删除"})
    @SysLog("通过id删除公共参数配置表")
    @DeleteMapping("/{paramId}")
    public R<Boolean> removeById(@PathVariable("paramId") Long paramId) {
        return R.ok(this.sysParamService.removeById(paramId));
    }

}
