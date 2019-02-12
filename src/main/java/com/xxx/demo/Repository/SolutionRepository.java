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
    @Query(value = "insert into solution set recordnum=?1,deltime=?2,record_id=?3,user_id=?4,username=?5,title=?6,context=?7",nativeQuery = true)
    public void addSolution(String recordnum, Date deltime, int recordID, int userID, String username, String title, String context);


    @Transactional
    @Modifying
    @Query(value = "update solution set solution_id=?1,title=?2,context=?3",nativeQuery = true)
    public void updateSolution(int solutionID,String title,String context);


    @Transactional
    @Modifying
    @Query (value = "delete from solution where solution_id = ?1 and title=?2 and context=?3",nativeQuery = true)
    public void delteSolution(int solutionID,String title,String context);

    @Query (value = "SELECT * from solution where user_name = ?1",nativeQuery = true)
    public List<Solution> searchSolutionByName (String username);

}
