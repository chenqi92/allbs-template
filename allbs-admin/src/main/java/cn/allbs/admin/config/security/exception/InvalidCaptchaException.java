package cn.allbs.admin.config.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 类 InvalidCaptchaException 验证码异常
 *
 * @author ChenQi
 * @date 2023/8/17
 */
public class InvalidCaptchaException extends AuthenticationException {

    public InvalidCaptchaException(String msg) {
        super(msg);
    }
}
