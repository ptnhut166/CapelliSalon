package com.example.salon.Domain;

import java.util.List;

public class Order {
    private static String ID;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String money;
    private String detail;

    public Order(){

    }

    public Order(String ID, String name, String phone, String email, String address, String money, String detail)
    {
        this.ID =ID;
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.address=address;
        this.money=money;
        this.detail= detail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public static String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}