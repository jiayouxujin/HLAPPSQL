package com.xxx.demo.Service;

import com.xxx.demo.Entity.Bike;
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

    public List<Bike> getdevicelist (){
        List<Bike> deviceList= deviceRepository.getdevicelist();
        return deviceList;
    }

    public List<Bike> getdevicelistbystatus (String status){
        List<Bike> deviceList= deviceRepository.getdevicelistbystatus(status);
        return deviceList;
    }

    public boolean createdevice(String devicenum,String devicetype,String devicestatus,double devicelat,double devicelng,String deviceaddress,String regionID,String IP){
        try {
            deviceRepository.createdevice(devicenum,devicetype,devicestatus,devicelat,devicelng,deviceaddress,regionID,IP);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public Bike createdevice0(String devicenum,String devicetype,String devicestatus,double devicelat,double devicelng,String deviceaddress,String regionID,String defposID,String IP){
        try {
            Bike a=new Bike();
            a.setDevicenum(devicenum);
            a.setDevicetype(devicetype);
            a.setDevicestatus(devicestatus);
            a.setDevicelat(devicelat);
            a.setDevicelng(devicelng);
            a.setDeviceaddress(deviceaddress);
            a.setRegionID(regionID);
            return deviceRepository.save(a);
        }catch (Exception e){
            return null;
        }
    }

    public void deletedevice(int deviceID){
        deviceRepository.deleteById(deviceID);
    }

    public boolean modifydevice(int deviceID,String devicenum,String devicetype,String devicestatus,double devicelat,double devicelng,String deviceaddress,String regionID,String IP){
        try {
            deviceRepository.modifydevice(deviceID,devicenum,devicetype,devicestatus,devicelat,devicelng,deviceaddress,regionID,IP);
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

    public List<Bike> check(String devicenum){
        List<Bike> list=deviceRepository.check(devicenum);
        return list;
    }
    public List<Bike> searchbynum(String devicenum){
        List<Bike> a=deviceRepository.check(devicenum);
        return a;
    }
    public void deleteall(){
        deviceRepository.deleteAll();
    }

    public void dos(){
        List<Bike> a=deviceRepository.check("MT001");
        double lx=38.759973308405215,rx=41.24086437044588,ly=115.02935726630257,ry=117.75076150839774;
        double lat=a.get(0).getDevicelat();
        double lng=a.get(0).getDevicelng();
        double x=lat+0.3/(int)((Math.random()-0.5)*10+1);
        double y=lng+0.3/(int)((Math.random()-0.5)*10+1);
        if(x>lx && x<rx && y>ly && y<ry) {
            deviceRepository.updatelat("MT001", x, y);
        }
        a=deviceRepository.check("MT019");
        lat=a.get(0).getDevicelat();
        lng=a.get(0).getDevicelng();
        x=lat+0.3/(int)((Math.random()-0.5)*10+1);
        y=lng+0.3/(int)((Math.random()-0.5)*10+1);
        if(x>lx && x<rx && y>ly && y<ry) {
            deviceRepository.updatelat("MT019",x,y);
        }
        a=deviceRepository.check("MT020");
        lat=a.get(0).getDevicelat();
        lng=a.get(0).getDevicelng();
        x=lat+0.3/(int)((Math.random()-0.5)*10+1);
        y=lng+0.3/(int)((Math.random()-0.5)*10+1);
        if(x>lx && x<rx && y>ly && y<ry) {
            deviceRepository.updatelat("MT020",x,y);
        }
    }
}
