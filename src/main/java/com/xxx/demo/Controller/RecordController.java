package com.xxx.demo.Controller;


import com.xxx.demo.Common.Response;
import com.xxx.demo.Entity.Record;
import com.xxx.demo.Service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.xxx.demo.Common.ResultGenerator.genFailResult;
import static com.xxx.demo.Common.ResultGenerator.genSuccessResult;

@RestController
@CrossOrigin
public class RecordController {

    @Autowired
    RecordService recordService;

    @GetMapping("/api/record/getdevicerecord")
    public Response searchDeviceRecord(@RequestParam int deviceID, @RequestParam String devicenum, @RequestParam String devicetype)
    {
        List<Record> recordList = recordService.searchDeviceRecord(deviceID,devicenum,devicetype);
        if (recordList == null||recordList.size()==0){
            return genFailResult("无记录或查询失败");
        }
        else {
            return genSuccessResult(recordList);
        }
    }

    @GetMapping("/api/record/getrecordlist")
    public Response searchAllDeviceRecord()
    {
        List<Record> recordList = recordService.searchAllDeviceRecord();
        if (recordList == null||recordList.size()==0){
            return genFailResult("无记录或查询失败");
        }
        else {
            return genSuccessResult(recordList);
        }
    }

    @GetMapping("/api/record/getrecordlistbytime")
    public Response searchAllDeviceRecordByTime(String lowerbound, String upperbound)
    {
        List<Record> recordList = recordService.searchAllDeviceRecordBytime(lowerbound,upperbound);
        if (recordList == null||recordList.size()==0){
            return genFailResult("无记录或查询失败");
        }
        else {
            return genSuccessResult(recordList);
        }
    }

    @PostMapping("/api/record/createrecord")
    public Response addRecord (@RequestParam String devicenum, @RequestParam String devicetype, @RequestParam String devicestatus, @RequestParam String recordtime){
        try {
            if(recordService.addRecord(devicenum,devicetype,devicestatus,recordtime)){
                return genSuccessResult(true);
            }
            else return genFailResult("添加失败");
        }
        catch (Exception e){
            return genFailResult("添加失败");
        }
    }

    @PostMapping("/api/record/deleterecord")
    public Response deleteRecord(@RequestParam String recordnum){
        try{
            if(recordService.deleteRecord(recordnum)){
                return genSuccessResult(true);
            }
            else return genFailResult("删除记录失败");
        }
        catch(Exception e) {
            return genFailResult("删除记录失败");
        }
    }
}
