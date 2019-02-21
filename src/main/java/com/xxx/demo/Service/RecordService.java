package com.xxx.demo.Service;

import com.xxx.demo.Entity.Record;
import com.xxx.demo.Repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("recordService")
public class RecordService {

    @Autowired
    RecordRepository recordRepository;

    public List<Record> searchDeviceRecord (int deviceID, String devicenum, String devicetype){
        List<Record> recordList= recordRepository.searchDeviceRecord(deviceID);
        return recordList;
    }

    public List<Record> searchAllDeviceRecord (){
        List<Record> recordList= recordRepository.searchAllDeviceRecord();
        return recordList;
    }

    public List<Record> searchAllDeviceRecordBytime (Date lowerbound, Date upperbound){
        List<Record> recordList= recordRepository.searchAllDeviceRecordByTime(lowerbound,upperbound);
        return recordList;
    }

    public Boolean addRecord(String devicenum,String devicetype,String devicestatus,Date recordtime){
       try {
           recordRepository.addRecord(devicenum, devicetype, devicestatus, recordtime);
           return true;
       }catch (Exception e){
           return false;
       }
    }

    public void deleteRecord(int recordID){
            recordRepository.deleteById(recordID);
    }

    public Boolean updatestatus(int recordID,int userID,String username,String title,String context){
        try {
            recordRepository.updatestatus(recordID,userID,username,title,context);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
