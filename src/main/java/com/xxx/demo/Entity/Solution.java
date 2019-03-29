package com.xxx.demo.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "solution")
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solution_id")
    int solutionID;

    @Column(name = "record_id")
    int recordID;

    @Column(name = "record_num")
    String recordnum;

    @Column
    Date deltime;

    @Column(name = "user_id")
    int userID;

    @Column(name = "user_name",columnDefinition = "char(200) character set utf8")
    String username;

    @Column(columnDefinition = "char(200) character set utf8")
    String title;

    @Column(columnDefinition = "char(200) character set utf8")
    String context;

    @Column(name="device_num",columnDefinition = "char(200) character set utf8")
    String devicenum;

    public Solution(){}
    public Solution(int recordID, String recordnum, Date deltime, int userID, String username, String title, String context,String devicenum) {
        this.recordID = recordID;
        this.recordnum = recordnum;
        this.deltime = deltime;
        this.userID = userID;
        this.username = username;
        this.title = title;
        this.context = context;
        this.devicenum=devicenum;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "solutionID=" + solutionID +
                ", recordID=" + recordID +
                ", recordnum='" + recordnum + '\'' +
                ", deltime=" + deltime +
                ", userID=" + userID +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                '}';
    }



    public int getSolutionID() {
        return solutionID;
    }

    public void setSolutionID(int solutionID) {
        this.solutionID = solutionID;
    }

    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public String getRecordnum() {
        return recordnum;
    }

    public void setRecordnum(String recordnum) {
        this.recordnum = recordnum;
    }

    public Date getDeltime() {
        return deltime;
    }

    public void setDeltime(Date deltime) {
        this.deltime = deltime;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setDevicenum(String devicenum) {
        this.devicenum = devicenum;
    }

    public String getDevicenum() {
        return devicenum;
    }
}
