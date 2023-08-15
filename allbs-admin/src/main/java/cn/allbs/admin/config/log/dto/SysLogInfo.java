package cn.allbs.admin.config.log.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 类 SysLogDto
 *
 * @author ChenQi
 * @date 2023/5/11
 */
@Data
public class SysLogInfo {

    @Schema(description = "类型", name = "type", implementation = Integer.class)
    private Integer type;

    @Schema(description = "方法注释", name = "title", implementation = String.class)
    private String title;

    @Schema(description = "远程ip", name = "remoteAddr", implementation = String.class)
    private String remoteAddr;

    @Schema(description = "用户代理", name = "userAgent", implementation = String.class)
    private String userAgent;

    @Schema(description = "请求的接口地址", name = "requestUri", implementation = String.class)
    private String requestUri;

    @Schema(description = "执行方法", name = "method", implementation = String.class)
    private String method;

    @Schema(description = "参数", name = "params", implementation = String.class)
    private String params;

    @Schema(description = "执行时间", name = "time", implementation = Long.class)
    private Long time;

    @Schema(description = "异常说明", name = "exception", implementation = String.class)
    private String exception;

    @Schema(description = "用户名", name = "userName", implementation = String.class)
    private String userName;

    @Schema(description = "服务端", name = "serviceId", implementation = String.class)
    private String serviceId;
}
