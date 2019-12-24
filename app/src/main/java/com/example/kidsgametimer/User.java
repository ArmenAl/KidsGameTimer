package com.example.kidsgametimer;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_timer_table")
public class User {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String userName;
    private long userTime;

    public User(String userName, long userTime) {
        this.userName = userName;
        this.userTime = userTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getUserTime() {
        return userTime;
    }

    public void setUserTime(long userTime) {
        this.userTime = userTime;
    }
}
