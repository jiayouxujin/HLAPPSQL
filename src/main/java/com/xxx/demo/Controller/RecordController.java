package com.xxx.demo.Controller;


import com.xxx.demo.Common.Response;
import com.xxx.demo.Entity.Record;
import com.xxx.demo.Service.RecordService;
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
    public Response searchAllDeviceRecordByTime(String begintime, String endtime) throws ParseException
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date lowerbound=format.parse(begintime);
        Date upperbound=format.parse(endtime);
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
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date=format.parse(recordtime);
            if(recordService.addRecord(devicenum,devicetype,devicestatus,date)){
                return genSuccessResult(true);
            }
            else return genFailResult("添加失败");
        }
        catch (Exception e){
            return genFailResult("添加失败");
        }
    }

    @PostMapping("/api/record/deleterecord")
    public Response deleteRecord(@RequestParam int recordID){
        recordService.deleteRecord(recordID);
        return genSuccessResult(true);
    }

    @PostMapping("/api/record/updatestatus")
    public Response updateStatus (@RequestParam int recordID,@RequestParam int userID,@RequestParam String username,@RequestParam String title,@RequestParam String context){
        try {
            recordService.updatestatus(recordID,userID,username,title,context);
            return genSuccessResult(true);
        }
        catch (Exception e){
            return genFailResult("添加失败");
        }
    }
}
