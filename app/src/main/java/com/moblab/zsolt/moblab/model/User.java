package com.moblab.zsolt.moblab.model;

import com.google.gson.annotations.SerializedName;
import com.orm.dsl.Table;

/**
 * Created by mobsoft on 2017. 05. 12..
 */

@Table
public class User {

    private Long id = null;

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    public User() {
    }

    public User(Long id, String password, String username) {
        this.id = id;
        this.password = password;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
