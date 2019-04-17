package com.xxx.demo.Controller;

import com.xxx.demo.Common.Random;
import com.xxx.demo.Common.Response;
import com.xxx.demo.Entity.User;
import com.xxx.demo.Service.AdminService;
import com.xxx.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import static com.xxx.demo.Common.ResultGenerator.genFailResult;
import static com.xxx.demo.Common.ResultGenerator.genSuccessResult;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @Value("${version}")
    private String version;

    @PostMapping("/api/admin/login")
    public Response returnlogin(@RequestParam String username,@RequestParam String password){
        if(adminService.getPassword(username).equals(password)){
            return genSuccessResult("success");
        }
        return genFailResult("fail");
    }

    @PostMapping("/api/user/adduser")
    public Response addUser (@RequestBody User thisUser){
        thisUser.setDefposID("防区一");
        thisUser.setRegionID("区域一");
        User newUser = userService.addUser(thisUser);

        if (newUser == null){
            return genFailResult("添加失败，该用户名已被注册过");
        }
        else {
            return genSuccessResult(newUser);
        }
    }

    @GetMapping("/api/user/getuserInfo")
    public Response getUserByName(@RequestParam String username){
        User thisUser = userService.searchUserByName(username);
        if (thisUser == null){
            return genFailResult("获取失败");
        }
        else {
            return genSuccessResult(thisUser);
        }
    }

    @PostMapping("/api/user/updateuserInfo")
    public Response updateUserInfo(@RequestParam String username,@RequestParam String regionID,@RequestParam String defposID){
        try {
            userService.updateUserInfo(username, regionID, defposID);
            return genSuccessResult(true);
        }
        catch (Exception e){
            return genFailResult("更新失败");
        }
    }

    @PostMapping ("/api/user/login")
    public Response getPassword (@RequestParam String username,@RequestParam String password){
        try{
            String correctPassword = userService.getPassword(username);
            if (correctPassword.equals(password)){
                return genSuccessResult(true);
            }
            else {
                return genSuccessResult(false);
            }
        }
        catch (Exception e){
            return genFailResult("未知错误");
        }

    }

    @PostMapping("/api/user/changepassword")
    public Response changePassword(@RequestParam String username,@RequestParam String password){
        userService.changePassword(username,password);
        return genSuccessResult(true);
    }

    @PostMapping("/api/user/deleteuser")
    public Response deleteUser(@RequestParam int userID){
        try{
            userService.deleteUser(userID);
            return genSuccessResult(true);
        }
        catch(Exception e) {
            return genFailResult("删除用户失败");
        }
    }

    @PostMapping("/api/user/deleteall")
    public Response deleteall(){
        try{
            userService.deleteall();
            return genSuccessResult(true);
        }
        catch(Exception e) {
            return genFailResult("清空失败");
        }
    }

    @GetMapping("/get-version")
    public Response getVersion(){
        return genSuccessResult (version);
    }
}
