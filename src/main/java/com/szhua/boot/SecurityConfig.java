package com.szhua.boot;
/*
*@author szhua 2018/1/2/002
*SecurityConfig
github@szhua
*/


import com.szhua.boot.bean.Reader;
import com.szhua.boot.domain.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

//当应用程序需要部署到不同的运行环境时，一些配置细节通常会有所不同
//使用Profile进行配置；
@Profile("production")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    ReaderRepository readerRepository ;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()

                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
          .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")

          .and()
               .csrf().disable();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(username->{
            System.err.println(username);
            Reader user = readerRepository.findReaderByUsername(username);;
            System.err.println(user);
            return user ;
        })
                .passwordEncoder(new PasswordEncoder() {
                    @Override
                    public String encode(CharSequence charSequence) {
                        return charSequence.toString();
                    }
                    @Override
                    public boolean matches(CharSequence charSequence, String s) {
                        //s 为设定的password charSequence是填入的password ;
                        System.err.println(charSequence.equals(s));
                        return charSequence.toString().equals(s);
                    }
                });




    }
}
