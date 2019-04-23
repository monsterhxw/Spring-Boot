package com.hxw.oauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Configuration 注解这是一个配置类
 * @EnableWebSecurity 注解开启 Spring Security 的功能
 * @EnableGlobalMethodSecurity 开启 Spring Security 方法级安全
 *
 * prePostEnabled :决定 Spring Security 的前注解是否可用 [@PreAuthorize,@PostAuthorize,..]
 *
 * secureEnabled : 决定是否 Spring Security 的保障注解 [@Secured] 是否可用。
 *
 * jsr250Enabled ：决定 JSR-250 annotations 注解[@RolesAllowed..] 是否可用。
 *
 * 只有添加了 @EnableGlobalMethodSecurity(prePostEnabled=true) 之后，@PreAuthorize("hasAnyRole('admin')") 才能生效
 *
 * WebSecurityConfigurerAdapter 继承 WebSecurityConfigurerAdapter，并重写它的方法来设置一些 web 安全的细节
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailServiceImpl userDetailsService;

    /**
     * @return Bcrypt： bcrypt 是一种跨平台的文件加密工具。
     *
     * bcrypt 使用的是布鲁斯·施内尔在1993年发布的 Blowfish 加密算法。
     *
     * 由它加密的文件可在所有支持的操作系统和处理器上进行转移。
     *
     * 它的口令必须是8至56个字符，并将在内部被转化为448位的密钥。
     * @Bean 注入指定 PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置为从内存中进行加载认证信息. 这里配置了两个用户 admin 和 user
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("admin")).roles("admin");
//        auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("user")).roles("user");
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login") // 表单登录
            .and()
            .authorizeRequests() // 定义哪些URL需要被保护、哪些不需要被保护
            .antMatchers("/login").permitAll() // 设置所有人都可以访问登录页面
            .anyRequest()
            .authenticated(); // 任何请求,登录后可以访问
    }
}
