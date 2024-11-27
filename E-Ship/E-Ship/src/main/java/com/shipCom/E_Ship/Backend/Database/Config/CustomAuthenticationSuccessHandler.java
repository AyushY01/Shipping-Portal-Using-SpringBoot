package com.shipCom.E_Ship.Backend.Database.Config;

import com.shipCom.E_Ship.Backend.Database.Entity.LoginAndSignup;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        LoginAndSignup user = (LoginAndSignup) authentication.getPrincipal();  // Get the authenticated user
        String username = user.getUsername();  // You can pass the username or any other details here

        if (user.getAuthorities().stream().anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"))) {
            // Redirect admin users to the admin page with additional data
            response.sendRedirect("/admin/dashboard?username=" + username);  // Send the username as query parameter
        } else {
            // Redirect normal users to a default page with additional data
            System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////////////////");// Send the username as query parameter
        }
    }
}
