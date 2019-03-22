package com.xxx.demo.Entity;

import javax.persistence.*;

@Entity(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    int DeviceID;

    @Column(name = "device_num")
    String devicenum;

    @Column(name = "device_lat")
    Double devicelat;

    @Column(name = "device_lng")
    Double devicelng;

    @Column(name = "device_address",columnDefinition = "char(200) character set utf8")
    String deviceaddress;

    @Column(name = "device_status",columnDefinition = "char(200) character set utf8")
    String devicestatus;

    @Column(name = "device_type",columnDefinition = "char(200) character set utf8")
    String devicetype;

    @Column(name = "region_id")
    String regionID;

    @Column(name = "defpos_id")
    String defposID;

    @Column(name = "ip")
    String IP;

    public int getDeviceID() {
        return DeviceID;
    }

    public Double getDevicelat() {
        return devicelat;
    }

    public Double getDevicelng() {
        return devicelng;
    }

    public String getDeviceaddress() {
        return deviceaddress;
    }

    public String getDevicenum() {
        return devicenum;
    }

    public String getDefposID() {
        return defposID;
    }

    public String getDevicestatus() {
        return devicestatus;
    }

    public String getDevicetype() {
        return devicetype;
    }

    public String getRegionID() {
        return regionID;
    }

    public void setDefposID(String defposID) {
        this.defposID = defposID;
    }

    public String getIP() {
        return IP;
    }

    public void setDeviceaddress(String deviceaddress) {
        this.deviceaddress = deviceaddress;
    }

    public void setDeviceID(int deviceID) {
        DeviceID = deviceID;
    }

    public void setDevicelat(Double devicelat) {
        this.devicelat = devicelat;
    }

    public void setDevicelng(Double devicelng) {
        this.devicelng = devicelng;
    }

    public void setDevicenum(String devicenum) {
        this.devicenum = devicenum;
    }

    public void setDevicestatus(String devicestatus) {
        this.devicestatus = devicestatus;
    }

    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype;
    }

    public void setRegionID(String regionID) {
        this.regionID = regionID;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

}
