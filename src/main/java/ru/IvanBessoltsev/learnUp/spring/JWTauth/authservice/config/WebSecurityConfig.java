package ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.filters.JwtAuthenticationFilter;
import ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.filters.JwtAuthorizationFilter;
import ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.jwt.JwtService;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtService jwtService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager(), jwtService);
        jwtAuthenticationFilter.setFilterProcessesUrl("/api/auth");

        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                .authorizeRequests()
                .antMatchers("/books/**", "/api/auth", "/api/tokenRefresh").permitAll()
                .antMatchers("/books").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
                .and()

                .formLogin()
                .loginProcessingUrl("/api/auth")
                .and()

                .addFilter(jwtAuthenticationFilter)
                .addFilterBefore(new JwtAuthorizationFilter(jwtService), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        final UserDetails ud = new UserDetails() {

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return new ArrayList<SimpleGrantedAuthority>() {{
                    add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                    add(new SimpleGrantedAuthority("ROLE_USER"));
                }
                };
            }

            @Override
            public String getPassword() {
                return encoder.encode("user123");
            }

            @Override
            public String getUsername() {
                return "user";
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
        return login -> {
            if (ud.getUsername().equals(login)) return ud;
            throw new UsernameNotFoundException("Нет такого пользователя!");
        };
    }

}