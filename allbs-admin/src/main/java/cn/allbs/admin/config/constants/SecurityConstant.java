package cn.allbs.admin.config.constants;

/**
 * 接口 SecurityConstant
 *
 * @author ChenQi
 * @date 2023/8/15
 */
public interface SecurityConstant {

    /**
     * Bearer
     */
    String BEARER_TYPE = "Bearer ";

    /**
     * 正常用户
     */
    Integer STATUS_NORMAL = 0;

    /**
     * 锁定
     */
    Integer STATUS_LOCK = 9;

    /**
     * 登录方式——短信验证码
     */
    String SMS_LOGIN_TYPE = "smsCaptcha";

    /**
     * 登录方式——账号密码登录
     */
    String PASSWORD_LOGIN_TYPE = "passwordLogin";

    /**
     * 权限在token中的key
     */
    String AUTHORITIES_KEY = "authorities";

    /**
     * 自定义 grant type —— 短信验证码
     */
    String GRANT_TYPE_SMS_CODE = "urn:ietf:params:oauth:grant-type:sms_code";

    /**
     * 自定义 grant type —— 短信验证码 —— 手机号的key
     */
    String OAUTH_PARAMETER_NAME_PHONE = "phone";

    /**
     * 自定义 grant type —— 短信验证码 —— 短信验证码的key
     */
    String OAUTH_PARAMETER_NAME_SMS_CAPTCHA = "sms_captcha";
}
