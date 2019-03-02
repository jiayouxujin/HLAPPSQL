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

    public List<Record> searchAllDeviceRecordBytime (Date lowerbound, Date upperbound){
        List<Record> recordList= recordRepository.searchAllDeviceRecordByTime(lowerbound,upperbound);
        return recordList;
    }

    public Boolean addRecord(String devicenum,String devicetype,String devicestatus,Date recordtime,String recordnum){
       try {
           recordRepository.addRecord(devicenum, devicetype, devicestatus, recordtime,recordnum);
           return true;
       }catch (Exception e){
           return false;
       }
    }

    public Record addRecord0(String devicenum,String devicetype,String devicestatus,Date recordtime,String recordnum){
        Record record=recordRepository.addRecord0(devicenum, devicetype, devicestatus, recordtime,recordnum);
        return record;
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
