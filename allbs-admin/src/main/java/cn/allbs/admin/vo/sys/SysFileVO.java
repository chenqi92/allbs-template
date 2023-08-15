package cn.allbs.admin.vo.sys;


import java.time.LocalDateTime;

import cn.allbs.admin.entity.sys.SysFileEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文件管理表(sys_file)VO
 *
 * @author chenqi
 * @since 2023-08-15 15:34:16
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "文件管理表 数据展示类", name = "SysFileVO")
public class SysFileVO extends SysFileEntity {
}
