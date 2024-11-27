package com.shipCom.E_Ship.Backend.Database.Controller;

import com.shipCom.E_Ship.Backend.Database.Entity.LoginAndSignup;
import com.shipCom.E_Ship.Backend.Database.Entity.User;
import com.shipCom.E_Ship.Backend.Database.Service.DataService;
import com.shipCom.E_Ship.Backend.Database.Service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller // Change this to @Controller if you want to render views
@RequestMapping("/api") // Optional: Organize your endpoints under a common path
public class UserDataController {

    @Autowired
    public UserDataService USD;
    @Autowired
    private DataService UserS;



    @GetMapping("/useralldata")
    private ResponseEntity<List<LoginAndSignup>> UserAllData() {
        List<LoginAndSignup> users = USD.GetAllData();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

//1
    @GetMapping("/")
    public String showSignupForm(Model model) {
        model.addAttribute("signup", new LoginAndSignup());
        return "SignUp";
    }

//2
@PostMapping("/signup")
 public String submitSignupForm(LoginAndSignup signup) {
      USD.saveUserData(signup);
   return ("redirect:/api/placeorder");
}

//3
@GetMapping("/placeorder")
    public String Placedorderform(Model model){
        model.addAttribute("saved",new User());
        return ("Place_Order");

}

@PostMapping("/Saved")
    public String OrderPlaced(User saved){
        UserS.SavePlacedOrder(saved);
        return "redirect:/api/";
}

//@GetMapping("/login")
//public String LoginForm(Model model) {
//
//}

}