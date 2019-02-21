package com.xxx.demo.Controller;


import com.xxx.demo.Common.Response;
import com.xxx.demo.Entity.Device;
import com.xxx.demo.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/api/device/createdevice")
    public Response createDevice(@RequestParam String devicenum,@RequestParam String devicetype,@RequestParam String devicestatus,@RequestParam double devicelat,@RequestParam double devicelng,@RequestParam String deviceaddress,@RequestParam String regionID,@RequestParam String defposID,@RequestParam String IP){
        try {
            deviceService.createdevice(devicenum,devicetype,devicestatus,devicelat,devicelng,deviceaddress,regionID,defposID,IP);
            return genSuccessResult(true);
        }catch (Exception e){
            return genFailResult("添加失败");
        }
    }


    @PostMapping("/api/device/deletedevice")
    public Response deleteDevice(@RequestParam int deviceID){
        deviceService.deletedevice(deviceID);
        return genSuccessResult(true);
    }

    @PostMapping("/api/device/modifydevice")
    public Response modifyDevice(@RequestParam int deviceID,@RequestParam String devicenum,@RequestParam String devicetype,@RequestParam String devicestatus,@RequestParam double devicelat,@RequestParam double devicelng,@RequestParam String deviceaddress,@RequestParam String regionID,@RequestParam String defposID,@RequestParam String IP){
        deviceService.modifydevice(deviceID,devicenum,devicetype,devicestatus,devicelat,devicelng,deviceaddress,regionID,defposID,IP);
        return genSuccessResult(true);
    }

    @PostMapping("/api/device/updatestatus")
    public Response updateStatus(@RequestParam String devicenum,@RequestParam String devicetype,@RequestParam String newstatus){
        deviceService.updatestatus(devicenum,devicetype,newstatus);
        return genSuccessResult(true);
    }

}