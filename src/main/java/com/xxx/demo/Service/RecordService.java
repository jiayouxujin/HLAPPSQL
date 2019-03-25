package com.xxx.demo.Service;

import com.xxx.demo.Entity.Record;
import com.xxx.demo.Repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Service("recordService")
public class RecordService {

    @Autowired
    RecordRepository recordRepository;

    public List<Record> check(String recordnum){
        List<Record> recordList= recordRepository.check(recordnum);
        return recordList;
    }

    public List<Record> searchDeviceRecord (int deviceID, String devicenum, String devicetype){
        List<Record> recordList= recordRepository.searchDeviceRecord(deviceID);
        return recordList;
    }

    public List<Record> searchAllDeviceRecord (){
        List<Record> recordList= recordRepository.searchAllDeviceRecord();
        return recordList;
    }
    public List<Record> searchRecordbydevicestatus(String status){
        List<Record> recordList= recordRepository.searchRecordbydevicestatus(status);
        return recordList;
    }
    public List<Record> searchRecordbyrecordstatus(String status){
        List<Record> recordList= recordRepository.searchRecordbyrecordstatus(status);
        return recordList;
    }
    public List<Record> searchAllDeviceRecordBytime (Date lowerbound, Date upperbound){
        List<Record> recordList= recordRepository.searchAllDeviceRecordByTime(lowerbound,upperbound);
        return recordList;
    }

    public Boolean addRecord(String devicenum,String devicetype,String devicestatus,double devicelat,double devicelng,String deviceaddress,String regionID,String defposID,Date recordtime,String recordnum){
       try {
           recordRepository.addRecord(devicenum,devicetype,devicestatus,devicelat,devicelng,deviceaddress,regionID,defposID,recordtime,recordnum,"未处理");
           return true;
       }catch (Exception e){
           return false;
       }
    }

    public Record addRecord0(String devicenum,String devicetype,String devicestatus,Date recordtime,String recordnum){
        Record a=new Record();
        a.setDevicenum(devicenum);
        a.setDevicetype(devicetype);
        a.setDevicestatus(devicestatus);
        a.setRecordtime(recordtime);
        a.setRecordnum(recordnum);
        return recordRepository.save(a);
    }

    public void deleteRecord(int recordID){
            recordRepository.deleteById(recordID);
    }

    public Boolean updatestatus(int recordID,int userID,String username,String title,String context,String status){
        try {
            recordRepository.updatestatus(recordID,userID,username,title,context,status);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
