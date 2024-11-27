package com.shipCom.E_Ship.Backend.Database.Service;
import com.shipCom.E_Ship.Backend.Database.Entity.LoginAndSignup;
import com.shipCom.E_Ship.Backend.Database.Repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataService {
    @Autowired
    private UserDataRepository UserDataRepo;
    private static final PasswordEncoder pass=new BCryptPasswordEncoder();


    public List<LoginAndSignup> GetAllData(){
        return UserDataRepo.findAll();
    }
    public void saveUserData(LoginAndSignup LAS){
        LAS.setPassword(pass.encode(LAS.getPassword()));
       UserDataRepo.save(LAS);
    }
    public LoginAndSignup findByUsername(String Username){
        return UserDataRepo.findByUsername(Username);
    }


}
