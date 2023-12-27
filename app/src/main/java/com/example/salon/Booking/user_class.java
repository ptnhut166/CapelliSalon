package com.example.salon.Booking;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;

public class user_class implements Serializable {
    private String uid;
    private String name;
    private String address;
    private String time;
    private String nameStaff;
    private String phoneNumber;
    public static FirebaseAuth mAuth;
    public static FirebaseDatabase Database = FirebaseDatabase.getInstance();

    public user_class(String uid, String name, String address, String time, String nameStaff, String phoneNumber) {
        this.uid = uid;
        this.name = name;
        this.address = address;
        this.time = time;
        this.nameStaff = nameStaff;
        this.phoneNumber = phoneNumber;
    }
    public String getUserID() {
        return uid;
    }

    public void setUserID(String name) {
        this.uid= uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
}
