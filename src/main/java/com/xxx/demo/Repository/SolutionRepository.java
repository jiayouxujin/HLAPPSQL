package com.xxx.demo.Repository;

import com.xxx.demo.Entity.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface SolutionRepository extends JpaRepository<Solution,Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into solution set record_num=?1,record_id=?2,deltime=?3,user_id=?4,user_name=?5,title=?6,context=?7,device_num=?8",nativeQuery = true)
    public void addSolution(String recordnum,int recordID,Date deltime,int userID,String username,String title,String context,String devicenum);


    @Transactional
    @Modifying
    @Query(value = "update solution set title=?2,context=?3 where solution_id=?1",nativeQuery = true)
    public void updateSolution(int solutionID,String title,String context);


    @Query (value = "SELECT * from solution where user_name = ?1",nativeQuery = true)
    public List<Solution> searchSolutionByName (String username);

}
