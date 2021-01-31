package org.kodluyoruz.group1.library.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final UserDetailsService userDetailsService;

    private final AccessDeniedHandler accessDeniedHandler;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .anyRequest().permitAll()
                .and().formLogin()
                 .loginPage("/login").permitAll();
//                .antMatchers("/","/newrecord","/authorslist","/booklist","/showSearchResult")
//                .permitAll()
//           //     .antMatchers().hasAnyRole("ADMIN")
//                .antMatchers("/member/update/","/new-password","/take-book/").hasAnyRole("USER")
//              //     .antMatchers().hasAnyRole("ADMIN")
//                .antMatchers("/saveBook","/update/","/delete/","/member","/member/delete/","/member-status/","/saveAuthor/","/updateAuthor/","/deleteAuthor/","/memberlist").hasAnyRole("ADMIN")
//                .anyRequest().authenticated()
//                .and().formLogin()
//                .loginPage("/login").permitAll()
//                .and()
//                .logout().permitAll()
//                .and()
//                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}