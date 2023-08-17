package cn.allbs.admin.controller;

import cn.allbs.common.utils.R;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类 LoginController
 *
 * @author ChenQi
 * @date 2023/8/17
 */
@RestController
@RequiredArgsConstructor
public class LoginController {

    @GetMapping("/getSmsCaptcha")
    public R<String> getSmsCaptcha(String phone) {
        // 示例项目，固定1234
        String smsCaptcha = "1234";
        return R.ok(200, "获取短信验证码成功！", smsCaptcha);
    }

    @ResponseBody
    @GetMapping("/getCaptcha")
    public R getCaptcha(HttpSession session) {
        // 定义图形验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(150, 40, 4, 2);
        // 存入session中
        session.setAttribute("captcha", captcha.getCode());
        return R.ok(captcha.getImageBase64Data());
    }
}
