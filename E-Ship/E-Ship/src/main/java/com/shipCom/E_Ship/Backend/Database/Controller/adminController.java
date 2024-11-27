package com.shipCom.E_Ship.Backend.Database.Controller;

import com.shipCom.E_Ship.Backend.Database.Entity.User;
import com.shipCom.E_Ship.Backend.Database.Repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api")
public class adminController {

    @Autowired
    private DataRepository User;
    @GetMapping("/admin/dashboard")
    public String adminDashboard(@RequestParam(name = "username", required = false) String Username, Model model) {
        // Add the username (or other data) to the model
        model.addAttribute("username", Username);
        return ("redirect:/api/admin/dashboard/history"); // Return the admin dashboard view
    }
    @GetMapping("/history")
    public String getUsers(Model model) {
        // This will automatically call the findAll() method from JpaRepository
        List<User> users = User.findAll();

        // Add the list of users to the model
        model.addAttribute("users", users);

        return "HistoryDashboard";  // Thymeleaf template name
    }
}
