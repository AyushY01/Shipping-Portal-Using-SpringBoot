package com.shipCom.E_Ship.Backend.Database.Service;

import com.shipCom.E_Ship.Backend.Database.Entity.User;
import com.shipCom.E_Ship.Backend.Database.Repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataService {

    @Autowired
    private DataRepository UserRepo;

    public List<User> getAll(){
        return UserRepo.findAll();
    }
    public Optional<User> findById(Long id){
        return UserRepo.findById(id);
    }

    public void createEntry(User user){
        UserRepo.save(user);
    }
     public void deleteData(Long id){
        UserRepo.deleteById(id);
     }
    public void SavePlacedOrder(User user){
        UserRepo.save(user);
    }


}
