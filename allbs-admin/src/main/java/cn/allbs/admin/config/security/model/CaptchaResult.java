package cn.allbs.admin.config.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 类 CaptchaResult 验证码返回值
 *
 * @author ChenQi
 * @date 2023/8/18
 */
@Data
@AllArgsConstructor
public class CaptchaResult {

    /**
     * 验证码id
     */
    private String captchaId;

    /**
     * 验证码的值
     */
    private String code;

    /**
     * 图片验证码的base64值
     */
    private String imageData;

}
