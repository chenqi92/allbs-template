package cn.allbs.admin.entity.sys;


import java.io.Serial;
import java.time.LocalDateTime;

import cn.allbs.admin.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单权限表(sys_menu)表实体类
 *
 * @author chenqi
 * @since 2023-08-15 16:11:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "菜单权限表", name = "sys_menu")
@TableName("sys_menu")
public class SysMenuEntity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -19111052561332750L;

    @TableId(value = "menu_id", type = IdType.AUTO)
    @Schema(description = "菜单ID", name = "menuId", implementation = Integer.class)
    private Integer menuId;

    @Schema(description = "菜单名称", name = "name", implementation = String.class)
    private String name;

    @Schema(description = "权限字符", name = "permission", implementation = String.class)
    private String permission;

    @Schema(description = "菜单路径", name = "path", implementation = String.class)
    private String path;

    @Schema(description = "父菜单ID", name = "parentId", implementation = Integer.class)
    private Integer parentId;

    @Schema(description = "图标", name = "icon", implementation = String.class)
    private String icon;

    @Schema(description = "排序", name = "sort", implementation = Integer.class)
    private Integer sort;

    @Schema(description = "是否保持活跃", name = "keepAlive", implementation = String.class)
    private String keepAlive;

    @Schema(description = "类型", name = "type", implementation = String.class)
    private String type;
}
