package com.example.salon;
import java.io.Serializable;
public class BookingInfo implements Serializable {
    private String name;
    private String address;
    private String time;
    private String nameStaff;
    private String phoneNumber;
//    private String userID;

    public BookingInfo(String name, String address, String time, String nameStaff, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.time = time;
        this.nameStaff = nameStaff;
        this.phoneNumber = phoneNumber;
//        this.userID =  userID;
    }
//    public String getUserID() {
//        return userID;
//    }
//
//    public void setUserID(String name) {
//        this.userID= userID;
//    }

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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
