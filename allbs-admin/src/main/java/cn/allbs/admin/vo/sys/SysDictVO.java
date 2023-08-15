package cn.allbs.admin.vo.sys;


import java.time.LocalDateTime;

import cn.allbs.admin.entity.sys.SysDictEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典表(sys_dict)VO
 *
 * @author chenqi
 * @since 2023-08-15 15:34:14
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "字典表 数据展示类", name = "SysDictVO")
public class SysDictVO extends SysDictEntity {
}
