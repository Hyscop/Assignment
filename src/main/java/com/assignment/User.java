package com.assignment;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String phoneNumber;
    private String password;

    List shoppingList;

    User(String username, String phoneNumber, String password) {
        this.id = IdGenerator.generate();
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.shoppingList = new ArrayList<ShoppingList>();

    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

}
