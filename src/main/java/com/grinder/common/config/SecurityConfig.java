package com.grinder.common.config;

import com.grinder.common.security.common.service.MemberDetailsService;
import com.grinder.common.security.oauth.service.OAuth2MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.cache.SpringCacheBasedUserCache;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final OAuth2MemberService customOAuth2MemberService;
    private final CacheManager cacheManager;
    private final MemberDetailsService memberDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer configure() {
        return web -> web.ignoring()
                // .requestMatchers(toH2Console())
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .antMatchers("/fonts/**", "/images/**", "/css/**", "/js/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authenticationProvider(authenticationProvider())
                .authorizeRequests(authorizeRequests -> authorizeRequests
                        .antMatchers("/login/oauth2/code/**").permitAll()
                        .antMatchers("/login/**").permitAll()
                        .antMatchers("/oauth2/**").permitAll()
                        .antMatchers("/register").permitAll()
                        .antMatchers("/").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .loginProcessingUrl("/loginProcess")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .permitAll()
                )
                .oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint((userInfoEndpointConfig) ->
                                userInfoEndpointConfig.userService(customOAuth2MemberService))
                        .loginPage("/login")
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .deleteCookies("JSESSIONID")
                        .clearAuthentication(true)
                        .invalidateHttpSession(true)
                        .permitAll()
                )
                .sessionManagement(session-> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                        .maximumSessions(1)
                        .maxSessionsPreventsLogin(true)
                        .expiredUrl("/login?expired=true")
                )
                .httpBasic(AbstractHttpConfigurer::disable)
                .csrf()
                .disable();

        return http.build();
    }

    /**
     * 유저 인증 시 캐싱 처리
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(memberDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        // SpringCacheBasedUserCache 설정
        authProvider.setUserCache(new SpringCacheBasedUserCache(cacheManager.getCache("userCache")));
        return authProvider;
    }


}
