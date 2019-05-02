package com.xxx.demo.Common;
import com.xxx.demo.Entity.Bike;
import com.xxx.demo.Entity.Record;
import com.xxx.demo.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class DeviceThread extends Thread{
    @Resource
    DeviceService deviceService;

    Bike device=new Bike();
    @Override
    public void run() {
        device=deviceService.createdevice0("0","0","0",0,0,"0","0","0","0");
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        deviceService.deletedevice(device.getDeviceID());
    }
}
