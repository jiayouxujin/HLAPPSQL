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

    @Query(value = "SELECT * from record where device_id=?1 and devicenum=?2 and devicetype=?3 order by recordtime",nativeQuery = true)
    public List<Record> searchDeviceRecord(int deviceID, String devicenum, String devicetype);

    @Query(value = "SELECT * from record  order by recordtime",nativeQuery = true)
    public List<Record> searchAllDeviceRecord();

    @Query(value = "SELECT * from record where recordtime between ?1 and ?2 order by recordtime",nativeQuery = true)
    public List<Record> searchAllDeviceRecordByTime(Date lowerbound, Date upperbound);

    @Transactional
    @Modifying
    @Query (value = "insert into record set devicenum=?1,devicetype=?2,devicestatus=?3,recordtime=?4",nativeQuery = true)
    public void addRecord(String devicenum, String devicetype, String devicestatus, Date recordtime);

}
