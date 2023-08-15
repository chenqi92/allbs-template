package cn.allbs.admin.entity.sys;


import cn.allbs.admin.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 日志表(sys_log)表实体类
 *
 * @author chenqi
 * @since 2023-08-15 16:11:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "日志表", name = "sys_log")
@TableName("sys_log")
public class SysLogEntity extends BaseEntity {

    private static final long serialVersionUID = -10250058606354773L;

    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键", name = "id", implementation = Long.class)
    private Long id;

    @Schema(description = "类型", name = "type", implementation = Integer.class)
    private Integer type;

    @Schema(description = "日志内容", name = "title", implementation = String.class)
    private String title;

    @Schema(description = "服务id", name = "serviceId", implementation = String.class)
    private String serviceId;

    @Schema(description = "执行ip", name = "remoteAddr", implementation = String.class)
    private String remoteAddr;

    @Schema(description = "用户代理", name = "userAgent", implementation = String.class)
    private String userAgent;

    @Schema(description = "请求的url", name = "requestUri", implementation = String.class)
    private String requestUri;

    @Schema(description = "执行方法类型", name = "method", implementation = String.class)
    private String method;

    @Schema(description = "携带参数", name = "params", implementation = String.class)
    private String params;

    @Schema(description = "执行时间", name = "time", implementation = Long.class)
    private Long time;

    @Schema(description = "异常内容", name = "exception", implementation = String.class)
    private String exception;
}
