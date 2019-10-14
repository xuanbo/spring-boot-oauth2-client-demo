package tk.fishfish.oauth2.client.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * OAuth2配置
 *
 * @author 奔波儿灞
 * @since 1.0
 */
@Configuration
@EnableOAuth2Client
public class OAuth2Configuration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomSavedRequestAwareAuthenticationSuccessHandler successHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 自定义成功认证
        http.oauth2Login()
                .successHandler(successHandler);
        // 默认设置
        super.configure(http);
    }

}
