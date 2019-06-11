package com.xxx.demo.Repository;

import com.xxx.demo.Entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into operation set operationday=?1,deviceid_list=?2",nativeQuery = true)
    public void addOperation(Date operationday, String deviceidList);

    @Query (value = "SELECT * from operation ",nativeQuery = true)
    public List<Operation> getoperationlist();
}
