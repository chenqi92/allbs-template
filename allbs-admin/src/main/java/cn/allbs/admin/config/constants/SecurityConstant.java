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
     * 授权确认页面地址
     */
    String DEVICE_ACTIVATED_URI = "http://127.0.0.1:5173/activated";

    /**
     * 授权确认页面地址
     */
    String DEVICE_ACTIVATE_URI = "http://127.0.0.1:5173/activate";

    /**
     * 授权确认页面地址
     */
    String CONSENT_PAGE_URI = "http://127.0.0.1:5173/consent";

    /**
     * 微信登录相关参数——openid：用户唯一id
     */
    String WECHAT_PARAMETER_OPENID = "openid";

    /**
     * 微信登录相关参数——forcePopup：强制此次授权需要用户弹窗确认
     */
    String WECHAT_PARAMETER_FORCE_POPUP = "forcePopup";

    /**
     * 微信登录相关参数——secret：微信的应用秘钥
     */
    String WECHAT_PARAMETER_SECRET = "secret";

    /**
     * 微信登录相关参数——appid：微信的应用id
     */
    String WECHAT_PARAMETER_APPID = "appid";

    /**
     * 三方登录类型——微信
     */
    String THIRD_LOGIN_WECHAT = "wechat";

    /**
     * 三方登录类型——Gitee
     */
    String THIRD_LOGIN_GITEE = "gitee";

    /**
     * 三方登录类型——Github
     */
    String THIRD_LOGIN_GITHUB = "github";

    /**
     * 随机字符串请求头名字
     */
    String NONCE_HEADER_NAME = "nonceId";

    /**
     * 登录方式入参名
     */
    String LOGIN_TYPE_NAME = "loginType";

    /**
     * 验证码id入参名
     */
    String CAPTCHA_ID_NAME = "captchaId";

    /**
     * 验证码值入参名
     */
    String CAPTCHA_CODE_NAME = "code";

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
