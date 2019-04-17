package com.xxx.demo.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity (name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    int adminID;

    @Column
    String password;

    @Column(name = "user_name",columnDefinition = "char(200) character set utf8")
    String username;

    @Column(name = "checked")
    int checked;
    @Override
    public String toString() {
        return  "User{" +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public Admin(String username,String password) {
        this.password=password;
        this.username=username;
    }

    public Admin() { }

    public int getAdminID() {
        return adminID;
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

}
