package com.xxx.demo.Repository;

import com.xxx.demo.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{

    @Transactional
    @Modifying
    @Query (value = "insert into admin set password=?2,user_name=?1",nativeQuery = true)
    public Admin addUser(String username, String password);

    @Query (value = "SELECT * from admin where user_name = ?1",nativeQuery = true)
    public Admin searchUserByName (String username);

    @Query(value = "select password from admin where user_name = ?1",nativeQuery = true)
    public String getPassword(String username);

    @Transactional
    @Modifying
    @Query (value = "update admin set password = ?2 where user_name = ?1",nativeQuery = true)
    public void changePassword(String username,String password);

}
