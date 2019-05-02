package com.xxx.demo.Repository;

import com.xxx.demo.Entity.Bike;
import org.hibernate.boot.model.source.spi.JpaCallbackSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Bike,Integer> {
    @Query(value = "SELECT * from bike order by device_num",nativeQuery = true)
    public List<Bike> getdevicelist();

    @Query(value = "SELECT * from bike where device_status=?1",nativeQuery = true)
    public List<Bike> getdevicelistbystatus(String status);

    @Transactional
    @Modifying
    @Query (value = "insert into bike set device_num=?1,device_type=?2,device_status=?3,device_lat=?4,device_lng=?5,device_address=?6,region_id=?7,ip=?8",nativeQuery = true)
    public void createdevice(String devicenum,String devicetype,String devicestatus,double devicelat,double devicelng,String deviceaddress,String regionID,String IP);

    @Transactional
    @Modifying
    @Query (value = "insert into bike set device_num=?1,device_type=?2,device_status=?3,device_lat=?4,device_lng=?5,device_address=?6,region_id=?7,ip=?8 SELECT @@device_id",nativeQuery = true)
    public Bike createdevice0(String devicenum,String devicetype,String devicestatus,double devicelat,double devicelng,String deviceaddress,String regionID,String IP);

    @Transactional
    @Modifying
    @Query (value = "update bike set device_num=?2,device_type=?3,device_status=?4,device_lat=?5,device_lng=?6,device_address=?7,region_id=?8,ip=?9 where device_id=?1",nativeQuery = true)
    public void modifydevice(int deviceID,String devicenum,String devicetype,String devicestatus,double devicelat,double devicelng,String deviceaddress,String regionID,String IP);


    @Transactional
    @Modifying
    @Query (value = "update bike set device_status=?2 where device_num=?1",nativeQuery = true)
    public void updatestatus(String devicenum,String newstatus);

    @Transactional
    @Modifying
    @Query (value = "update bike set device_lat=?2,device_lng=?3 where device_num=?1",nativeQuery = true)
    public void updatelat(String devicenum,double devicelat,double devicelng);

    @Query(value = "SELECT * from bike where device_num=?1",nativeQuery = true)
    public List<Bike> check(String devicenum);

}
