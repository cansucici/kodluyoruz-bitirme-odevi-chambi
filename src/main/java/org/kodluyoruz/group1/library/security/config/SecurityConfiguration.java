package org.kodluyoruz.group1.library.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final UserDetailsService userDetailsService;

    private final MyAccessDeniedHandler myAccessDeniedHandler;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/", "/new-member", "/authorslist", "/booklist",
                        "/showSearchResult", "/new-password").permitAll()
                .antMatchers("/member/update/**", "/take-book/**").hasRole("USER")
                .antMatchers("/member/update/**", "/saveBook", "/update/**", "/delete/**", "/member",
                        "/member/delete/**", "/member-status/", "/saveAuthor", "/updateAuthor",
                        "/updateAuthor/**", "/deleteAuthor/**", "/memberlist").hasRole("ADMIN")
                .and().formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(myAccessDeniedHandler);
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}