package cn.allbs.admin.vo.sys;


import java.time.LocalDateTime;

import cn.allbs.admin.entity.sys.SysDeptEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门管理(sys_dept)VO
 *
 * @author chenqi
 * @since 2023-08-15 15:34:17
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "部门管理 数据展示类", name = "SysDeptVO")
public class SysDeptVO extends SysDeptEntity {
}
