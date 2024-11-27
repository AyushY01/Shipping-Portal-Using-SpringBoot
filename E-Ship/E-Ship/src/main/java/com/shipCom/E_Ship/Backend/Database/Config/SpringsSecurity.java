package com.shipCom.E_Ship.Backend.Database.Config;
import com.shipCom.E_Ship.Backend.Database.Service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringsSecurity {

    @Autowired
    private UserDetailsImpl userDetailsImpl; // This will be your custom UserDetailsService
    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    public SpringsSecurity(CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) {
        this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz   // Use 'authorizeRequests' method
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Only allow access to admins for admin paths
                        .requestMatchers("/api/").authenticated()  // Allow access to other paths (like home) without authentication
                      //  .requestMatchers("/api/**").permitAll()

                )
                .formLogin(login -> login   // Custom login configuration
                        .loginPage("/api/")  // Custom login page URL
                        .successHandler(customAuthenticationSuccessHandler)  // Custom redirect on successful login
                        .permitAll()   // Allow all users to access the login page
                )
                .logout(LogoutConfigurer::permitAll  // Allow all users to log out
                );
        return http.build();// Allow everyone to log out
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Use BCrypt for password encoding
    }

}
