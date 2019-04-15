package com.xxx.demo.Controller;

import com.xxx.demo.Common.Response;
import com.xxx.demo.Entity.Solution;
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

    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public String returnIndex(ModelMap map){
        map.addAttribute("name", "yaohuiqin");
        return "login";
    }

}
