package com.xxx.demo.Repository;

import com.xxx.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

    @Transactional
    @Modifying
    @Query (value = "insert into user set phone_id=?3,password=?2,user_name=?1,defpos_id=?5,registerday=?6,region_id=?4",nativeQuery = true)
    public User addUser(String username, String password,String phoneID,String regionID,String defposID,Date registerday);

    @Query (value = "SELECT * from user where user_name = ?1",nativeQuery = true)
    public User searchUserByName (String username);

    @Transactional
    @Modifying
    @Query(value = "update user set region_id=?2,defpos_id=?3 where user_name=?1",nativeQuery = true)
    public void updateUserInfo(String username,String regionID,String defposID);

    @Query(value = "select password from user where user_name = ?1",nativeQuery = true)
    public String getPassword(String username);

    @Transactional
    @Modifying
    @Query (value = "update user set password = ?2 where user_name = ?1",nativeQuery = true)
    public void changePassword(String username,String password);

}
