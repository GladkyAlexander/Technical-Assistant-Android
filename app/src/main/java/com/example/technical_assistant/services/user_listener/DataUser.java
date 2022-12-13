package com.example.technical_assistant.services.user_listener;

import com.example.technical_assistant.domain.User;

public class DataUser {
    private final User user;

    public DataUser(User user) {
        this.user = user;
    }

    public User getUser(){
        return user;
    }

}
