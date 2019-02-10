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
    @Query (value = "insert into user set phoneID=?1,password=?2,username=?3,defposID=?4,registerday=?5",nativeQuery = true)
    public User addUser(String phoneID, String password,String username,String defposID,Date registerday);

    @Query (value = "SELECT * from user where username = ?1",nativeQuery = true)
    public User searchUserByName (String username);

    @Transactional
    @Modifying
    @Query(value = "update user set regionID=?2,defposID=?3 where username=?1",nativeQuery = true)
    public void setUserInfo(String username,String regionID,String defposID);

    @Query(value = "select password from user where username = ?1",nativeQuery = true)
    public String getPassword(String username);

    @Transactional
    @Modifying
    @Query (value = "update user set password = ?2 where username = ?1",nativeQuery = true)
    public void changePassword(String username,String password);

    @Transactional
    @Modifying
    @Query (value = "delete from user where username = ?1",nativeQuery = true)
    public void deleteUser(String username);
}
