package com.shipCom.E_Ship.Backend.Database.Controller;

import com.shipCom.E_Ship.Backend.Database.Entity.User;
import com.shipCom.E_Ship.Backend.Database.Repository.DataRepository;
import com.shipCom.E_Ship.Backend.Database.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DataController {

    @Autowired
    private DataService UserS;
    @Autowired
    private DataRepository UserRepo;

    @GetMapping("/alldata")
    private List<User> getAllData(){
        List <User>data=UserS.getAll();
        return data;
    }
    @GetMapping("/getdata/{id}")
    private Optional<User> getById(@PathVariable Long id){
       return UserS.findById(id);
    }
    @PostMapping("/postEntry")
    private ResponseEntity<User>createEntry(@RequestBody User user){
        try{ UserS.createEntry(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
   @PutMapping("/updateEntry/{id}")
    private ResponseEntity<User>updateEntry(@PathVariable Long id,@RequestBody User user){
           User old=UserS.findById(id).orElse(null);
       if(old!=null){
           old.setName(user.getName()!=null? user.getName() :old.getName());
           old.setAddress(user.getAddress()!=null ? user.getAddress():old.getAddress());
       }
              UserS.createEntry(old);
           return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteEntry/{id}")
    private ResponseEntity<User>deleteEntry(@PathVariable Long id){
        UserS.deleteData(id);
       return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
