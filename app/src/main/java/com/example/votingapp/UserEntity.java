package com.example.votingapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "UserData")
    public class UserEntity {
        @PrimaryKey(autoGenerate = true)
        private int id;

        @ColumnInfo(name = "voteCount")
        private int voteCount;
        @ColumnInfo(name = "username")
        private String username;

        @ColumnInfo(name = "password")
        private String password;

        @ColumnInfo(name = "email")
        private String email;

        @ColumnInfo(name = "phone")
        private String phone;


    public UserEntity(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.voteCount = 0;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int id) {
        this.voteCount = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
