package cn.allbs.admin.config.security.annotation;

import java.lang.annotation.*;

/**
 * 注解 IgnoreUri 用于放行接口
 *
 * @author ChenQi
 * @date 2023/8/15
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreUri {

    boolean value() default true;
}
