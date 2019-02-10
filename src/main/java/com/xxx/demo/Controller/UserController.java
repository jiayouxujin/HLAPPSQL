package com.xxx.demo.Controller;

import com.xxx.demo.Common.Random;
import com.xxx.demo.Common.Response;
import com.xxx.demo.Common.SendMail;
import com.xxx.demo.Entity.User;
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

    @Value("${version}")
    private String version;

    @PostMapping("/add-user")
    public Response addUser (@RequestBody User thisUser){
        thisUser.setdefposID("防区一");
        thisUser.setregionID("区域一");
        User newUser = userService.addUser(thisUser);

        if (newUser == null){
            return genFailResult("添加失败，该用户名已被注册过");
        }
        else {
            return genSuccessResult(newUser);
        }
    }

    @GetMapping("/get-user-by-name")
    public Response getUserByName (@RequestParam String username){
        User thisUser = userService.searchUserByName(username);
        if (thisUser == null){
            return genFailResult("获取失败");
        }
        else {
            return genSuccessResult(thisUser);
        }
    }

    @GetMapping("/get-verification-code")
    public Response getVerificationCode(@RequestParam String mail){
        String vcode = Random.getRandomNumString(6);
        try{
            SendMail sendMail = new SendMail("tql_tql","HuaWei2018","tql_tql@163.com","tql","www");
            sendMail.send("local",mail, vcode,"www");
            return genSuccessResult(vcode);
        }
        catch (Exception e){
            return genFailResult(e.getMessage());
        }
    }

    @PostMapping("/set-user-info")
    public Response setUserInfo(@RequestBody User user){

        try {
            userService.updateUser(user.getUsername(),user.getRegionID(),user.getDefposID());
            return genSuccessResult();
        }
        catch (Exception e){
            return genFailResult("更新失败");
        }
    }

    @PostMapping ("/user-login")
    public Response getPassword (@RequestBody User user){

        try{
            String correctPassword = userService.getPassword(user.getUsername());
            if (correctPassword.equals(user.getPassword())){
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

    @PostMapping("/change-password")
    public Response changePassword(@RequestBody User user){
        userService.changePassword(user.getMail(),user.getPassword());
        String vcode = Random.getRandomNumString(6);
        try{
            SendMail sendMail = new SendMail("tql_tql","HuaWei2018","tql_tql@163.com","tql","www");
            sendMail.send("local",user.getMail(), vcode,"www");
            return genSuccessResult(vcode);
        }
        catch (Exception e){
            return genFailResult("发送验证邮件失败，请重试");
        }
    }

    @PostMapping("/delete-user")
    public Response deleteUser(@RequestBody User user){
        try{
            userService.deleteUser(user.getUsername());
        }
        catch(Exception e) {
            return genFailResult("删除用户失败");
        }
    }

    @GetMapping("/get-version")
    public Response getVersion(){
        return genSuccessResult (version);
    }
}
