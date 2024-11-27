package com.shipCom.E_Ship.Backend.Database.Repository;

import com.shipCom.E_Ship.Backend.Database.Entity.LoginAndSignup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<LoginAndSignup, Long> {

  @Query("SELECT u FROM LoginAndSignup u WHERE u.Username = :username")
  LoginAndSignup findByUsername(@Param("username") String username);

}
