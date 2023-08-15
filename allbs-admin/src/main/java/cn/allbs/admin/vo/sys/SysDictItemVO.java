package cn.allbs.admin.vo.sys;


import java.time.LocalDateTime;

import cn.allbs.admin.entity.sys.SysDictItemEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典项(sys_dict_item)VO
 *
 * @author chenqi
 * @since 2023-08-15 15:34:13
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "字典项 数据展示类", name = "SysDictItemVO")
public class SysDictItemVO extends SysDictItemEntity {
}
