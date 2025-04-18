package com.ltp.contacts.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private BCryptPasswordEncoder passwordEncoder;
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()//جلوی برخی اتک هارو به بروزر میگیره اگه فعال باشه
            .authorizeRequests()
                //apply authorization on request
            .antMatchers(HttpMethod.DELETE, "/delete/*/contact").hasRole("ADMIN")//فقط ادمین بتونه//توی آدرس * هرچیزی میتونه باشه
            .antMatchers(HttpMethod.POST).hasAnyRole("ADMIN", "USER")
            .antMatchers(HttpMethod.GET).permitAll()//types of authentication
            .anyRequest().authenticated()
            .and()
            .httpBasic()//check only a userName and password
            .and()
                //حتما بایدبا آتنتیکیت شدن اطلاعات رو ارسال کنیم وگرنه اطلاعات وارد نمیشه
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
            .username("admin")
            .password(passwordEncoder.encode("admin-pass"))
            .roles("ADMIN")
            .build();

        UserDetails user = User.builder()
            .username("user")
            .password(passwordEncoder.encode("user-pass"))
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(admin, user);//saved user and admin in that time into the memory for processes
    }

}
