package cn.allbs.admin.dto.sys;


import cn.allbs.admin.entity.sys.SysDeptEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门管理(sys_dept)DTO
 *
 * @author chenqi
 * @since 2023-08-15 15:34:17
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "部门管理 参数接收类", name = "SysDeptDTO")
public class SysDeptDTO extends SysDeptEntity {
}
