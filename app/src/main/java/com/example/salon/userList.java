package com.example.salon;


import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class userList extends AppCompatActivity {
    public static ArrayList<user_class> userClassList = new ArrayList<>();

    public void addUser(user_class user_class) {
        userClassList.add(user_class);
    }

    public void updateUser(int index, user_class updatedUserClass) {
        if (index >= 0 && index < userClassList.size()) {
            userClassList.set(index, updatedUserClass);
        }else {
            Toast.makeText(this, "Index is not valid!", Toast.LENGTH_SHORT).show();
        }

    }

    public void removeUser(int index) {
        if (index >= 0 && index < userClassList.size()) {
            userClassList.remove(index);
        }
        else {
            Toast.makeText(this, "Index is not valid!", Toast.LENGTH_SHORT).show();
        }
    }

    public user_class getUser(int index) {
        if (index >= 0 && index < userClassList.size()) {
            return userClassList.get(index);
        }
        else {
            Toast.makeText(this, "Index is not valid!", Toast.LENGTH_SHORT).show();
        }
        return null;
    }

    public ArrayList<user_class> getAllUsers() {
        return userClassList;
    }
}