package com.xxx.demo.Controller;

import com.xxx.demo.Common.Response;
import com.xxx.demo.Entity.Solution;
import com.xxx.demo.Service.AdminService;
import com.xxx.demo.Service.RecordService;
import com.xxx.demo.Service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String returndevicelist(ModelMap map,@RequestParam(value="devicenum" ,required=false,defaultValue = "") String devicenum,@RequestParam(value="devicetype" ,required=false,defaultValue = "") String devicetype,@RequestParam(value="regionID" ,required=false,defaultValue = "") String regionID,@RequestParam(value="defposID" ,required=false,defaultValue = "") String defposID,@RequestParam(value="address" ,required=false,defaultValue = "") String address,@RequestParam(value="IP" ,required=false,defaultValue = "") String IP,@RequestParam(value="devicelat" ,required=false,defaultValue = "") String devicelat,@RequestParam(value="devicelng" ,required=false,defaultValue = "") String devicelng){
        map.put("devicenum",devicenum);
        map.put("devicetype",devicetype);
        map.put("regionID",regionID);
        map.put("defposID",defposID);
        map.put("address",address);
        map.put("IP",IP);
        map.put("devicelat",devicelat);
        map.put("devicelng",devicelng);
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



}