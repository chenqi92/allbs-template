package cn.allbs.admin.config.log.annotation;

import java.lang.annotation.*;

/**
 * 注解 SysLog 日志注解
 *
 * @author ChenQi
 * @date 2023/5/11
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    /**
     * 自定义操作步骤
     *
     * @return 操作内容
     */
    String value();
}
