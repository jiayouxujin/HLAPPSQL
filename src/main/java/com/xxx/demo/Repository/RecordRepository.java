package com.xxx.demo.Repository;

import com.xxx.demo.Entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record,Integer> {

    @Query(value = "SELECT * from record where device_id=?1 order by record_time DESC",nativeQuery = true)
    public List<Record> searchDeviceRecord(int deviceID);

    @Query(value = "SELECT * from record order by record_time DESC",nativeQuery = true)
    public List<Record> searchAllDeviceRecord();

    @Query(value = "SELECT * from record where device_status=?1 order by record_time DESC",nativeQuery = true)
    public List<Record> searchRecordbydevicestatus(String status);

    @Query(value = "SELECT * from record where record_status=?1 and device_status=?2 order by record_time DESC",nativeQuery = true)
    public List<Record> searchRecordbyrecordstatus(String status,String devicestatus);

    @Query(value = "SELECT * from record where record_time between ?1 and ?2 order by record_time DESC",nativeQuery = true)
    public List<Record> searchAllDeviceRecordByTime(Date lowerbound, Date upperbound);

    @Query(value = "SELECT * from record where record_num=?1",nativeQuery = true)
    public List<Record> check(String recordnum);


    @Query(value = "SELECT * from record where record_id=?1",nativeQuery = true)
    public Record searchRecordByID(int recordID);

    @Transactional
    @Modifying
    @Query (value = "insert into record set device_num=?1,device_type=?2,device_status=?3,device_lat=?4,device_lng=?5,device_address=?6,region_id=?7,defpos_id=?8,record_time=?9,record_num=?10,record_status=?11",nativeQuery = true)
    public void addRecord(String devicenum,String devicetype,String devicestatus,double devicelat,double devicelng,String deviceaddress,String regionID,String defposID,Date recordtime,String recordnum,String recordstatus);

    @Transactional
    @Modifying
    @Query (value = "insert into record set device_num=?1,device_type=?2,device_status=?3,record_time=?4,record_num=?5",nativeQuery = true)
    public Record addRecord0(String devicenum, String devicetype, String devicestatus, Date recordtime,String recordnum);

    @Transactional
    @Modifying
    @Query (value = "update record set user_id=?2,user_name=?3,title=?4,context=?5,record_status=?6 where record_id=?1",nativeQuery = true)
    public void updatestatus(int recordID,int userID,String username,String title,String context,String newstatus);
}
