package com.xxx.demo.Controller;

import com.xxx.demo.Common.Response;
import com.xxx.demo.Entity.Solution;
import com.xxx.demo.Service.RecordService;
import com.xxx.demo.Service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.xxx.demo.Common.ResultGenerator.genFailResult;
import static com.xxx.demo.Common.ResultGenerator.genSuccessResult;

@RestController
@CrossOrigin
public class SolutionController {
    @Autowired
    RecordService recordService;
    @Autowired
    SolutionService solutionService;

    @Value("${version}")
    private String version;

    @PostMapping("/api/solution/addsolution")
    public Response addSolution (@RequestParam String recordnum,@RequestParam int recordID,@RequestParam String deltime,@RequestParam int userID,@RequestParam String username,@RequestParam String title,@RequestParam String context){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date=format.parse(deltime);
            solutionService.addSolution(recordnum,recordID,date,userID,username,title,context);
            recordService.updatestatus(recordID,userID,username,title,context,"已处理");
            return genSuccessResult(true);
        }
        catch (Exception e){
            return genFailResult("添加失败");
        }

    }


    @PostMapping("/api/solution/updatesolution")
    public Response updateSolution(@RequestParam int solutionID,@RequestParam String title,@RequestParam String context){
        try {
            solutionService.updateSolution(solutionID, title, context);
            return genSuccessResult(true);
        }
        catch (Exception e){
            return genFailResult("更新失败");
        }
    }


    @PostMapping("/api/solution/deletesolution")
    public Response deleteSolution(@RequestParam int solutionID){
        try{
            solutionService.deleteSolution(solutionID);
            return genSuccessResult(true);
        }
        catch(Exception e) {
            return genFailResult("删除记录失败");
        }
    }


    @GetMapping("/api/solution/getsolutionlist")
    public Response searchSolutionByName(@RequestParam String username)
    {
        List<Solution> solutionList = solutionService.searchSolutionByName(username);
        if (solutionList == null||solutionList.size()==0){
            return genFailResult("无记录或查询失败");
        }
        else {
            return genSuccessResult(solutionList);
        }
    }
}
