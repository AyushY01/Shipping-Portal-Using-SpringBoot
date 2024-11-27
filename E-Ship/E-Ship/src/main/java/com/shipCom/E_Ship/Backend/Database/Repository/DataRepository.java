package com.shipCom.E_Ship.Backend.Database.Repository;

import com.shipCom.E_Ship.Backend.Database.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<User, Long> {

}
