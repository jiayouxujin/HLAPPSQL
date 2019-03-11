package com.xxx.demo.Entity;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "record")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    int recordID;

    @Column(name = "record_num")
    String recordnum;

    @Column(name = "record_time")
    Date recordtime;

    @Column(name = "record_status")
    String recordstatus;

    @Column(name = "solution_id")
    int solutionID;

    @Column(name = "user_id")
    int userID;

    @Column(name = "user_name",columnDefinition = "char(200) character set utf8")
    String username;

    @Column(columnDefinition = "char(200) character set utf8")
    String title;

    @Column(columnDefinition = "char(200) character set utf8")
    String context;

    @Column(name = "device_id")
    int deviceID;

    @Column(name = "device_num")
    String devicenum;

    @Column(name = "device_address")
    String deviceaddress;

    @Column(name = "region_id")
    String regionID;

    @Column(name = "defpos_id")
    String defposID;

    @Column(name = "device_lat")
    Double devicelat;

    @Column(name = "device_lng")
    Double devicelng;

    @Column(name = "device_type")
    String devicetype;

    @Column(name = "device_status")
    String devicestatus;

    @Column
    Date deltime;

    public Record(){}
    public Record(String recordnum, Date recordtime, String recordstatus, int solutionID, int userID, String username, String title, String context, int deviceID, String devicenum, String deviceaddress, String regionID, String defposID, Double devicelat, Double devicelng, String devicetype, String devicestatus, Date deltime) {
        this.recordnum = recordnum;
        this.recordtime = recordtime;
        this.recordstatus = recordstatus;
        this.solutionID = solutionID;
        this.userID = userID;
        this.username = username;
        this.title = title;
        this.context = context;
        this.deviceID = deviceID;
        this.devicenum = devicenum;
        this.deviceaddress = deviceaddress;
        this.regionID = regionID;
        this.defposID = defposID;
        this.devicelat = devicelat;
        this.devicelng = devicelng;
        this.devicetype = devicetype;
        this.devicestatus = devicestatus;
        this.deltime = deltime;
    }

    @Override
    public String toString() {
        return "Record{" +
                "recordID=" + recordID +
                ", recordnum='" + recordnum + '\'' +
                ", recordtime='" + recordtime + '\'' +
                ", recordstatus=" + recordstatus +
                ", solutionID=" + solutionID +
                ", userID=" + userID +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", deviceID=" + deviceID +
                ", devicenum='" + devicenum + '\'' +
                ", deviceaddress='" + deviceaddress + '\'' +
                ", regionID='" + regionID + '\'' +
                ", defposID='" + defposID + '\'' +
                ", devicelat=" + devicelat +
                ", devicelng=" + devicelng +
                ", devicetype='" + devicetype + '\'' +
                ", devicestatus='" + devicestatus + '\'' +
                ", deltime=" + deltime +
                '}';
    }

    public int getRecordID() {
        return recordID;
    }

    public String getRecordnum() {
        return recordnum;
    }

    public void setRecordnum(String recordnum) {
        this.recordnum = recordnum;
    }

    public Date getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(Date recordtime) {
        this.recordtime = recordtime;
    }

    public String getRecordstatus() {
        return recordstatus;
    }

    public void setRecordstatus(String recordstatus) {
        this.recordstatus = recordstatus;
    }

    public int getSolutionID() {
        return solutionID;
    }

    public void setSolutionID(int solutionID) {
        this.solutionID = solutionID;
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

    public int getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }

    public String getDevicenum() {
        return devicenum;
    }

    public void setDevicenum(String devicenum) {
        this.devicenum = devicenum;
    }

    public String getDeviceaddress() {
        return deviceaddress;
    }

    public void setDeviceaddress(String deviceaddress) {
        this.deviceaddress = deviceaddress;
    }

    public String getRegionID() {
        return regionID;
    }

    public void setRegionID(String regionID) {
        this.regionID = regionID;
    }

    public String getDefposID() {
        return defposID;
    }

    public void setDefposID(String defposID) {
        this.defposID = defposID;
    }

    public Double getDevicelat() {
        return devicelat;
    }

    public void setDevicelat(Double devicelat) {
        this.devicelat = devicelat;
    }

    public Double getDevicelng() {
        return devicelng;
    }

    public void setDevicelng(Double devicelng) {
        this.devicelng = devicelng;
    }

    public String getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype;
    }

    public String getDevicestatus() {
        return devicestatus;
    }

    public void setDevicestatus(String devicestatus) {
        this.devicestatus = devicestatus;
    }

    public Date getDeltime() {
        return deltime;
    }

    public void setDeltime(Date deltime) {
        this.deltime = deltime;
    }
}