package com.xxx.demo.Controller;

import com.xxx.demo.Common.Response;
import com.xxx.demo.Entity.Operation;
import com.xxx.demo.Repository.OperationRepository;
import com.xxx.demo.Service.DeviceService;
import com.xxx.demo.Service.OperationService;
import com.xxx.demo.Service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.xxx.demo.Common.ResultGenerator.genFailResult;
import static com.xxx.demo.Common.ResultGenerator.genSuccessResult;

@RestController
@CrossOrigin
public class OperationController {
    @Autowired
    OperationService operationService;
    @Autowired
    RecordService recordService;
    @Autowired
    DeviceService deviceService;

    @PostMapping("/api/operation/addoperation")
    public Response addOperation(@RequestParam String operationDay,@RequestParam String deviceidlist){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date=format.parse(operationDay);
            if(operationService.addOperation(date,deviceidlist)){
                //new RecordThread().start();
                return genSuccessResult(true);
            }
            else
            {
                System.out.println("1");
                return genFailResult("添加失败");
            }
        }
        catch (Exception e){
            System.out.println("2");
            return genFailResult("添加失败");
        }
    }

    @GetMapping("/api/operation/getoperationlist")
    public Response getOperationList(){
        List<Operation> operationList=operationService.getOperationList();
        if(operationList.size()==0){
            return genFailResult("无记录获取失败");
        }else{
            return genSuccessResult(operationList);
        }
    }

    @PostMapping("/api/operation/deleteoperation")
    public Response deleteSome(@RequestParam int operationID){
        try{
            operationService.deleteOperation(operationID);//删除操作记录
            return genSuccessResult(true);
        }catch (Exception e){
            return genFailResult("删除操作记录失败");
        }
    }
}
