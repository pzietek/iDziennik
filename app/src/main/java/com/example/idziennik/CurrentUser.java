package com.example.idziennik;

import com.example.idziennik.db.User;

public class CurrentUser {
    public static User value;

    public CurrentUser(User u) {
        this.value = u;
    }
}
