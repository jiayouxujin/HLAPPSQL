package com.xxx.demo.Service;

import com.xxx.demo.Entity.Operation;
import com.xxx.demo.Repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("operationService")
public class OperationService {
    @Autowired
    OperationRepository operationRepository;

    public boolean addOperation(Date operationday, String deviceidlist){
        try{
            operationRepository.addOperation(operationday,deviceidlist);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Operation> getOperationList(){
        try{
            List<Operation> operationList=operationRepository.getoperationlist();
            return operationList;
        }catch (Exception e){
            return null;
        }
    }

    public void deleteOperation(int id){
            operationRepository.deleteById(id);
    }

}
