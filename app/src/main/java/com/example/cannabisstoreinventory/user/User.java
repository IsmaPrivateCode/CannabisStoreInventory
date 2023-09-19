package com.example.cannabisstoreinventory.user;

import java.util.UUID;

public class User {

    private String id;
    private String name;
    private String password;
    private boolean admin;
    private String avatarUri;

    public User (String name, String password, boolean admin,String avatarUri){
        this.id= UUID.randomUUID().toString();
        this.name=name;
        this.password=password;
        this.admin=admin;
        this.avatarUri=avatarUri;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getAvatarUri() {
        return avatarUri;
    }

    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }
}
