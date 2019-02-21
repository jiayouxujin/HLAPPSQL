package com.xxx.demo.Service;

import com.xxx.demo.Entity.Device;
import com.xxx.demo.Entity.Record;
import com.xxx.demo.Repository.DeviceRepository;
import com.xxx.demo.Repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("deviceService")
public class DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    public List<Device> getdevicelist (){
        List<Device> deviceList= deviceRepository.getdevicelist();
        return deviceList;
    }

    public boolean createdevice(String devicenum,String devicetype,String devicestatus,double devicelat,double devicelng,String deviceaddress,String regionID,String defposID,String IP){
        try {
            deviceRepository.createdevice(devicenum,devicetype,devicestatus,devicelat,devicelng,deviceaddress,regionID,defposID,IP);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void deletedevice(int deviceID){
        deviceRepository.deleteById(deviceID);
    }

    public boolean modifydevice(int deviceID,String devicenum,String devicetype,String devicestatus,double devicelat,double devicelng,String deviceaddress,String regionID,String defposID,String IP){
        try {
            deviceRepository.modifydevice(deviceID,devicenum,devicetype,devicestatus,devicelat,devicelng,deviceaddress,regionID,defposID,IP);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean updatestatus(String devicenum,String devicetype,String newstatus){
        try{
            deviceRepository.updatestatus(devicenum,devicetype,newstatus);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
