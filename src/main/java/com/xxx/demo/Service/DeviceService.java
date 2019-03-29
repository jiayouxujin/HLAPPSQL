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

    public List<Device> getdevicelistbystatus (String status){
        List<Device> deviceList= deviceRepository.getdevicelistbystatus(status);
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
    public Device createdevice0(String devicenum,String devicetype,String devicestatus,double devicelat,double devicelng,String deviceaddress,String regionID,String defposID,String IP){
        try {
            Device a=new Device();
            a.setDevicenum(devicenum);
            a.setDevicetype(devicetype);
            a.setDevicestatus(devicestatus);
            a.setDevicelat(devicelat);
            a.setDevicelng(devicelng);
            a.setDeviceaddress(deviceaddress);
            a.setRegionID(regionID);
            a.setDefposID(defposID);
            return deviceRepository.save(a);
        }catch (Exception e){
            return null;
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

    public boolean updatestatus(String devicenum,String newstatus){
        try{
            deviceRepository.updatestatus(devicenum,newstatus);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Device> check(String devicenum){
        List<Device> list=deviceRepository.check(devicenum);
        return list;
    }
    public List<Device> searchbynum(String devicenum){
        List<Device> a=deviceRepository.check(devicenum);
        return a;
    }

    public void deleteall(){
        deviceRepository.deleteAll();
    }

}
