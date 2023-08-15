package cn.allbs.admin.entity.sys;


import java.time.LocalDateTime;

import cn.allbs.admin.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文件管理表(sys_file)表实体类
 *
 * @author chenqi
 * @since 2023-08-15 16:11:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "文件管理表", name = "sys_file")
@TableName("sys_file")
public class SysFileEntity extends BaseEntity {

    private static final long serialVersionUID = 787153202778115292L;

    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键", name = "id", implementation = Long.class)
    private Long id;

    @Schema(description = "文件名称", name = "fileName", implementation = String.class)
    private String fileName;

    @Schema(description = "所在目录", name = "bucketName", implementation = String.class)
    private String bucketName;

    @Schema(description = "原始名称", name = "original", implementation = String.class)
    private String original;

    @Schema(description = "文件类型", name = "type", implementation = String.class)
    private String type;

    @Schema(description = "文件大小", name = "fileSize", implementation = Long.class)
    private Long fileSize;

    @Schema(description = "关联编码", name = "relationCode", implementation = String.class)
    private String relationCode;
}
