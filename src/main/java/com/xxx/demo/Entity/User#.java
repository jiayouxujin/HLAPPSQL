package com.xxx.demo.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity (name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "user_id")
    int userID;

    @Column
    String password;

    @Column(name = "user_name",columnDefinition = "char(200) character set utf8")
    String username;

    @Column
    Date registerday;

    @Column
    String phoneID;

    @Column
    String defposID;

    @Override
    public String toString() {
        return  "User{" +
                "userID=" + userID +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", phoneID='" + phoneID + '\'' +
                ", defposID='" + defposID + '\'' +
                ", registerday="+registerday+
                '}';
    }

    public User(String phoneID, String password,String username,String defposID,Date registerday) {
        this.password=password;
        this.phoneID=phoneID;
        this.registerday=registerday;
        this.defposID=defposID;
        this.username=username;
    }

    public User() { }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public void setUsername(String newname) {
        this.username =newname;
    }

    public Date getregiserday() {return registerday; }

    public void setRegisterday(Date registerday) {
        this.registerday = registerday;
    }

    public String getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(String phoneID) {
        this.phoneID = phoneID;
    }

    public String getDefposID() {
        return DefposID;
    }

    public void setDefposID(String DefposID) {
        this.DefposID = DefposID;
    }

}
