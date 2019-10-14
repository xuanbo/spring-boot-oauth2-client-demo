package tk.fishfish.oauth2.client.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义认证成功处理
 *
 * @author 奔波儿灞
 * @since 1.0
 */
@Component
public class CustomSavedRequestAwareAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CustomSavedRequestAwareAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws ServletException, IOException {
        // 这里仅仅打印了当前登录的oauth2用户信息
        // 可以做一些用户同步操作，比如没有在本平台绑定手机号啥的，进行跳转，要求绑定什么的。
        String name = authentication.getName();
        LOG.info("oauth2 authentication success, user: {}", name);
        super.onAuthenticationSuccess(request, response, authentication);
    }

}
