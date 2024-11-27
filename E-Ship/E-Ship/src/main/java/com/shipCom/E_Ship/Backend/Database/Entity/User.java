package com.shipCom.E_Ship.Backend.Database.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="User_Data")
public class User {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    private String Name;
    @Column
    private Integer ContactNumber;
    @Column
    private String Address;
    @Column
    private String StartCity;
    @Column
    private String DestinationCity;
    @Column
    private long Amount;

    public User() {

    }

    public User(String name, Integer contact_No, String address, String startCity, String destinationCity, long amount) {
        Name = name;
        ContactNumber = contact_No;
        Address = address;
        StartCity = startCity;
        DestinationCity = destinationCity;
        Amount = amount;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", Contact_No=" + ContactNumber +
                ", Address='" + Address + '\'' +
                ", StartCity='" + StartCity + '\'' +
                ", DestinationCity='" + DestinationCity + '\'' +
                ", Amount=" + Amount +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(Integer contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getStartCity() {
        return StartCity;
    }

    public void setStartCity(String startCity) {
        StartCity = startCity;
    }

    public String getDestinationCity() {
        return DestinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        DestinationCity = destinationCity;
    }

    public long getAmount() {
        return Amount;
    }

    public void setAmount(long amount) {
        Amount = amount;
    }
}
