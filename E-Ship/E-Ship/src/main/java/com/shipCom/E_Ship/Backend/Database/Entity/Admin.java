package com.shipCom.E_Ship.Backend.Database.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="Admin_data")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Admin_id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String confirm_password;



}
