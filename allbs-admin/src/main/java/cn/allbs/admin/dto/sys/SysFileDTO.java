package cn.allbs.admin.dto.sys;


import java.time.LocalDateTime;

import cn.allbs.admin.entity.sys.SysFileEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文件管理表(sys_file)DTO
 *
 * @author chenqi
 * @since 2023-08-15 15:34:16
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "文件管理表 参数接收类", name = "SysFileDTO")
public class SysFileDTO extends SysFileEntity {
}
