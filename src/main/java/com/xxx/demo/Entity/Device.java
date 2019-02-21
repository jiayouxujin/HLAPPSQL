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
}
