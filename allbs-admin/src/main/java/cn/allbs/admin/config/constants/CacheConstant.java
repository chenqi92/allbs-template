package cn.allbs.admin.config.constants;

/**
 * 类 CacheConstant
 *
 * @author ChenQi
 * @date 2023/8/18
 */
public interface CacheConstant {

    /**
     * jwk set缓存前缀
     */
    String AUTHORIZATION_JWS_PREFIX_KEY = "authorization_jws";

    /**
     * 认证信息存储前缀
     */
    String SECURITY_CONTEXT_PREFIX_KEY = "security_context:";

    /**
     * 短信验证码前缀
     */
    String SMS_CAPTCHA_PREFIX_KEY = "mobile_phone:";

    /**
     * 图形验证码前缀
     */
    String IMAGE_CAPTCHA_PREFIX_KEY = "image_captcha:";

    /**
     * 默认过期时间，默认五分钟
     */
    long DEFAULT_TIMEOUT_SECONDS = 60L * 5;
}
