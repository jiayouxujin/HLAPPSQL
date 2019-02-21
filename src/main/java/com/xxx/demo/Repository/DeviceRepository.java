package com.xxx.demo.Repository;

import com.xxx.demo.Entity.Device;
import org.hibernate.boot.model.source.spi.JpaCallbackSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Integer> {
    @Query(value = "SELECT * from device",nativeQuery = true)
    public List<Device> getdevicelist();

    @Transactional
    @Modifying
    @Query (value = "insert into device set device_num=?1,device_type=?2,device_status=?3,device_lat=?4,device_lng=?5,device_address=?6,region_id=?7,defpos_id=?8,ip=?9",nativeQuery = true)
    public void createdevice(String devicenum,String devicetype,String devicestatus,double devicelat,double devicelng,String deviceaddress,String regionID,String defposID,String IP);

    @Transactional
    @Modifying
    @Query (value = "update device set device_num=?2,device_type=?3,device_status=?4,device_lat=?5,device_lng=?6,device_address=?7,region_id=?8,defpos_id=?9,ip=?10 where device_id=?1",nativeQuery = true)
    public void modifydevice(int deviceID,String devicenum,String devicetype,String devicestatus,double devicelat,double devicelng,String deviceaddress,String regionID,String defposID,String IP);


    @Transactional
    @Modifying
    @Query (value = "update device set device_status=?3 where device_num=?1",nativeQuery = true)
    public void updatestatus(String devicenum,String devicetype,String newstatus);

}
