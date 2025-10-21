package com.example.fragpractice;

import java.util.ArrayList;
import java.util.List;

public class UserStaticInfo {
    public static List<User> userList = new ArrayList<>();

    public static void addUsersIfNeeded() {
        if (userList.isEmpty()) {
            userList.add(new User(25, "Good", "Van", 0));
            userList.add(new User(18, "Good", "Nan", 1));
            userList.add(new User(24, "Bad", "Fun", 2));
            userList.add(new User(29, "Mid", "Van2", 1));
            userList.add(new User(23, "Good", "Van3", 2));
        }
    }
}
