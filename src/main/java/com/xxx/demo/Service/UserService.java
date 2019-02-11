package com.xxx.demo.Service;

import com.xxx.demo.Entity.User;
import com.xxx.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("userService")
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        try {
            User newUser = userRepository.save(user);
            return newUser;
        } catch (Exception e) {
            return null;
        }
    }

    public User searchUserByName(String username) {
        User thisUser = userRepository.searchUserByName(username);
        return thisUser;
    }

    public void updateUserInfo(String username, String regionID, String defposID) {
        userRepository.updateUserInfo(username, regionID, defposID);
    }

    public String getPassword(String username) {
        return userRepository.getPassword(username);
    }

    public boolean changePassword(String username, String password) {
        try {
            userRepository.changePassword(username, password);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
