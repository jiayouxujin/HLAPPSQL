package com.xxx.demo.Controller;

import com.xxx.demo.Common.Response;
import com.xxx.demo.Entity.Device;
import com.xxx.demo.Entity.Record;
import com.xxx.demo.Service.DeviceService;
import com.xxx.demo.Service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.xxx.demo.Common.ResultGenerator.genFailResult;
import static com.xxx.demo.Common.ResultGenerator.genSuccessResult;

@RestController
@CrossOrigin
public class DeviceController {


    @Autowired
    DeviceService deviceService;
    @Autowired
    RecordService recordService;

    public class RecordThread extends Thread{
        Record record=new Record();
        @Override
        public void run() {
            record=recordService.addRecord0("0","0","0",null,"0");
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            recordService.deleteRecord(record.getRecordID());
        }
    }
    public class DeviceThread extends Thread{
        Device device=new Device();
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

    @GetMapping("/api/device/check")
    public Response check(){
        List<Device> list=deviceService.check("0");
        if(list.isEmpty()) return genSuccessResult(false);
        else return genSuccessResult(true);
    }

    @GetMapping("/api/device/getdevicelist")
    public Response getDeviceList()
    {
        List<Device> deviceList = deviceService.getdevicelist();
        if (deviceList == null||deviceList.size()==0){
            return genFailResult("无记录或查询失败");
        }
        else {
            return genSuccessResult(deviceList);
        }
    }

    @GetMapping("/api/device/getdevicelistbystatus")
    public Response getDeviceList(@RequestParam String status)
    {
        List<Device> deviceList = deviceService.getdevicelistbystatus(status);
        if (deviceList == null||deviceList.size()==0){
            return genFailResult("无记录或查询失败");
        }
        else {
            return genSuccessResult(deviceList);
        }
    }

    @PostMapping("/api/device/createdevice")
    public Response createDevice(@RequestParam String devicenum,@RequestParam String devicetype,@RequestParam String devicestatus,@RequestParam double devicelat,@RequestParam double devicelng,@RequestParam String deviceaddress,@RequestParam String regionID,@RequestParam String defposID,@RequestParam String IP){
        try {
            deviceService.createdevice(devicenum,devicetype,devicestatus,devicelat,devicelng,deviceaddress,regionID,defposID,IP);
            new DeviceThread().start();
            return genSuccessResult(true);
        }catch (Exception e){
            return genFailResult("添加失败");
        }
    }


    @PostMapping("/api/device/deletedevice")
    public Response deleteDevice(@RequestParam int deviceID){
        deviceService.deletedevice(deviceID);
        new DeviceThread().start();
        return genSuccessResult(true);
    }
    
    @PostMapping("/api/device/deletesome")
    public Response deletesome(@RequestParam(value = "deviceID[]") int []deviceID){
        deviceService.deletesome(deviceID);
        new DeviceThread().start();
        return genSuccessResult(true);
    }

    @PostMapping("/api/device/modifydevice")
    public Response modifyDevice(@RequestParam int deviceID,@RequestParam String devicenum,@RequestParam String devicetype,@RequestParam String devicestatus,@RequestParam double devicelat,@RequestParam double devicelng,@RequestParam String deviceaddress,@RequestParam String regionID,@RequestParam String defposID,@RequestParam String IP){
        deviceService.modifydevice(deviceID,devicenum,devicetype,devicestatus,devicelat,devicelng,deviceaddress,regionID,defposID,IP);
        new DeviceThread().start();
        return genSuccessResult(true);
    }

    @PostMapping("/api/device/updatestatus")
    public Response updateStatus(@RequestParam String devicenum,@RequestParam String newstatus){
        if(deviceService.updatestatus(devicenum,newstatus)){
            List<Device> a=deviceService.searchbynum(devicenum);
            Device device=a.get(0);
            if(device.getDevicestatus()!=newstatus){
                Date date=new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                recordService.addRecord(devicenum,device.getDevicetype(),newstatus,device.getDevicelat(),device.getDevicelng(),device.getDeviceaddress(),device.getRegionID(),device.getDefposID(),date,device.getDevicetype()+format.format(date).substring(17));
                new DeviceThread().start();
                //new RecordThread().start();
                return genSuccessResult(true);
            }
                else return genSuccessResult("新状态与当前状态相同");
        }
        else return genFailResult("修改失败");
    }

    @PostMapping("/api/device/deleteall")
    public Response deleteall(){
        try{
            deviceService.deleteall();
            new DeviceThread().start();
            return genSuccessResult(true);
        }
        catch(Exception e) {
            return genFailResult("清空失败");
        }
    }
}
