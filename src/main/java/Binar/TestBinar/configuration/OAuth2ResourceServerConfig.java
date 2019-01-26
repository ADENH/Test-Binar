package Binar.TestBinar.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {
	@Override
    public void configure(ResourceServerSecurityConfigurer config) {
        config.tokenServices(tokenServicesResourceServer());
    }
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("auth/signup").permitAll()
		.anyRequest().authenticated();
	}
 
    @Bean
    public TokenStore tokenStoreResourceServer() {
        return new JwtTokenStore(accessTokenConverterResourceServer());
    }
 
    @Bean
    public JwtAccessTokenConverter accessTokenConverterResourceServer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("123");
        return converter;
    }
 
    @Bean
 //   @Primary
    public DefaultTokenServices tokenServicesResourceServer() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStoreResourceServer());
        return defaultTokenServices;
    }
}
