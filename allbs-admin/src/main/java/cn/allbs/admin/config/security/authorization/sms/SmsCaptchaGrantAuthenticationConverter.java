package cn.allbs.admin.config.security.authorization.sms;

import cn.allbs.admin.config.security.util.SecurityUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.OAuth2ErrorCodes;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.util.*;

import static cn.allbs.admin.config.constants.SecurityConstant.*;

/**
 * 短信验证码登录Token转换器
 *
 * @author vains
 */
public class SmsCaptchaGrantAuthenticationConverter implements AuthenticationConverter {

    static final String ACCESS_TOKEN_REQUEST_ERROR_URI = "https://datatracker.ietf.org/doc/html/rfc6749#section-5.2";

    @Override
    public Authentication convert(HttpServletRequest request) {
        // grant_type (REQUIRED)
        String grantType = request.getParameter(OAuth2ParameterNames.GRANT_TYPE);
        if (!GRANT_TYPE_SMS_CODE.equals(grantType)) {
            return null;
        }

        // 这里目前是客户端认证信息
        Authentication clientPrincipal = SecurityContextHolder.getContext().getAuthentication();

        // 获取请求中的参数
        MultiValueMap<String, String> parameters = SecurityUtils.getParameters(request);

        // scope (OPTIONAL)
        String scope = parameters.getFirst(OAuth2ParameterNames.SCOPE);
        if (StringUtils.hasText(scope) &&
                parameters.get(OAuth2ParameterNames.SCOPE).size() != 1) {
            SecurityUtils.throwError(
                    OAuth2ErrorCodes.INVALID_REQUEST,
                    "OAuth 2.0 Parameter: " + OAuth2ParameterNames.SCOPE,
                    ACCESS_TOKEN_REQUEST_ERROR_URI);
        }
        Set<String> requestedScopes = null;
        if (StringUtils.hasText(scope)) {
            requestedScopes = new HashSet<>(
                    Arrays.asList(StringUtils.delimitedListToStringArray(scope, " ")));
        }

        // Mobile phone number (REQUIRED)
        String username = parameters.getFirst(OAUTH_PARAMETER_NAME_PHONE);
        if (!StringUtils.hasText(username) || parameters.get(OAUTH_PARAMETER_NAME_PHONE).size() != 1) {
            SecurityUtils.throwError(
                    OAuth2ErrorCodes.INVALID_REQUEST,
                    "OAuth 2.0 Parameter: " + OAUTH_PARAMETER_NAME_PHONE,
                    ACCESS_TOKEN_REQUEST_ERROR_URI);
        }

        // SMS verification code (REQUIRED)
        String password = parameters.getFirst(OAUTH_PARAMETER_NAME_SMS_CAPTCHA);
        if (!StringUtils.hasText(password) || parameters.get(OAUTH_PARAMETER_NAME_SMS_CAPTCHA).size() != 1) {
            SecurityUtils.throwError(
                    OAuth2ErrorCodes.INVALID_REQUEST,
                    "OAuth 2.0 Parameter: " + OAUTH_PARAMETER_NAME_SMS_CAPTCHA,
                    ACCESS_TOKEN_REQUEST_ERROR_URI);
        }

        // 提取附加参数
        Map<String, Object> additionalParameters = new HashMap<>();
        parameters.forEach((key, value) -> {
            if (!key.equals(OAuth2ParameterNames.GRANT_TYPE) &&
                    !key.equals(OAuth2ParameterNames.CLIENT_ID)) {
                additionalParameters.put(key, value.get(0));
            }
        });

        // 构建AbstractAuthenticationToken子类实例并返回
        return new SmsCaptchaGrantAuthenticationToken(new AuthorizationGrantType(GRANT_TYPE_SMS_CODE), clientPrincipal, requestedScopes, additionalParameters);
    }

}

