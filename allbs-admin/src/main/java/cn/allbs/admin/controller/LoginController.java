package cn.allbs.admin.controller;

import cn.allbs.admin.config.redis.RedisOperator;
import cn.allbs.admin.config.security.model.CaptchaResult;
import cn.allbs.common.utils.R;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static cn.allbs.admin.config.constants.CacheConstant.*;

/**
 * 类 LoginController
 *
 * @author ChenQi
 * @date 2023/8/17
 */
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final RedisOperator<String> redisOperator;

    @GetMapping("/getSmsCaptcha")
    public R<String> getSmsCaptcha(String phone) {
        // 示例项目，固定1234
        String smsCaptcha = "1234";
        redisOperator.set((SMS_CAPTCHA_PREFIX_KEY + phone), smsCaptcha, DEFAULT_TIMEOUT_SECONDS);
        return R.ok(200, "获取短信验证码成功！", smsCaptcha);
    }

    @ResponseBody
    @GetMapping("/getCaptcha")
    public R getCaptcha(HttpSession session) {
        // 定义图形验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(150, 40, 4, 2);
        long id = IdWorker.getId();
        redisOperator.set((IMAGE_CAPTCHA_PREFIX_KEY + id), captcha.getCode(), DEFAULT_TIMEOUT_SECONDS);
        return R.ok(200, "验证码返回成功", new CaptchaResult(String.valueOf(id), captcha.getCode(), captcha.getImageBase64Data()));
    }
}
