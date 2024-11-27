package com.shipCom.E_Ship.Backend.Database.Service;

import com.shipCom.E_Ship.Backend.Database.Entity.LoginAndSignup;
import com.shipCom.E_Ship.Backend.Database.Repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    private UserDataRepository UserData;

    @Override
    public UserDetails loadUserByUsername(String Username) throws UsernameNotFoundException {
        LoginAndSignup user = UserData.findByUsername(Username);
        if (user != null) {
            UserDetails userDetails = org.springframework.security.core.userdetails.User.builder().
                    username(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getRoles().toArray(new String[0]))
                    .build();
            return userDetails;
        }
        throw new UsernameNotFoundException("Username not found" + Username);

    }
}