package org.zeronight.spm;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Spring Security的配置文件
 * @author tyche
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("MyUserDetailsService")
	UserDetailsService userDetailsService;

	/**
	 * 自动获取数据源，该数据源的配置来自于src/main/resources/application.properties
	 */
	@Autowired
	DataSource dataSource;

	/**
	 * 对所有人允许如下链接的访问，剩下的都需要登陆
	 * 对所有人允许登陆窗口的访问
	 * 对所有人允许登出的访问
	 * @see {@link http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/}
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/css/**","/js/**","/images/**","/fonts/**","/","/index","/hello")
				.permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/student/**").hasRole("STUDENT")
				.antMatchers("/teacher/**").hasRole("TEACHER")
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.permitAll()
				.and()
				.logout()
				.logoutUrl("/user/logout")
				.logoutSuccessUrl("/index")
				.invalidateHttpSession(true)
				.permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	/**
	 * 加密密码所需要的，暂时用不上
	 * @return 一个密码加密器
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	@Bean
    public MultipartResolver filterMultipartResolver() {
        return new CommonsMultipartResolver();
    }
}