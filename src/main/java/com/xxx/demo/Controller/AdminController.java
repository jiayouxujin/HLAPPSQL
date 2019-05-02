package com.xxx.demo.Controller;

import com.xxx.demo.Common.Response;
import com.xxx.demo.Entity.Solution;
import com.xxx.demo.Service.AdminService;
import com.xxx.demo.Service.RecordService;
import com.xxx.demo.Service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.xxx.demo.Common.ResultGenerator.genFailResult;
import static com.xxx.demo.Common.ResultGenerator.genSuccessResult;

@Controller
public class AdminController {
    @Value("${version}")
    private String version;


    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public String returnLogin(ModelMap map){
        //
        return "login";
    }

    @RequestMapping(value = "/devicelist",method = RequestMethod.GET)
    public String returndevicelist(ModelMap map){
        return "devicelist";
    }

    @RequestMapping(value = "/map",method = RequestMethod.GET)
    public String returnmap(ModelMap map){
        return "map";
    }
    @RequestMapping(value = "/statistics",method = RequestMethod.GET)
    public String returnstatistics(ModelMap map){
        return "statistics";
    }
    @RequestMapping(value = "/recordlist",method = RequestMethod.GET)
    public String returnRecordList(ModelMap map){
        return "recordlist";
    }
    @RequestMapping(value = "/userManagement",method = RequestMethod.GET)
    public String returnusermanagement(ModelMap map){
        return "userManagement";
    }
    @RequestMapping(value = "/start",method = RequestMethod.GET)
    public String returnstart(ModelMap map){
        return "start";
    }
    @RequestMapping(value = "/end",method = RequestMethod.GET)
    public String returnend(ModelMap map){
        return "end";
    }
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String returnhome(ModelMap map){
        return "home";
    }
    @RequestMapping(value = "/insurance",method = RequestMethod.GET)
    public String returninsurance(ModelMap map){
        return "insurance";
    }
    @RequestMapping(value = "/repairlist",method = RequestMethod.GET)
    public String returnrepairlist(ModelMap map){
        return "repairlist";
    }
}