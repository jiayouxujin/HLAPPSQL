package com.xxx.demo.Service;

import com.xxx.demo.Entity.Admin;
import com.xxx.demo.Entity.User;
import com.xxx.demo.Repository.AdminRepository;
import com.xxx.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("adminService")
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    public Admin addUser(Admin user) {
        try {
            Admin newUser = adminRepository.save(user);
            return newUser;
        } catch (Exception e) {
            return null;
        }
    }

    public String getPassword(String username) {
        return adminRepository.getPassword(username);
    }
    public boolean changePassword(String username, String password) {
        try {
            adminRepository.changePassword(username, password);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void deleteUser(int id) {
        adminRepository.deleteById(id);
    }

    public void deleteall(){
        adminRepository.deleteAll();
    }
}
