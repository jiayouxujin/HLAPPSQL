package com.xxx.demo.Service;

import com.xxx.demo.Entity.Solution;
import com.xxx.demo.Repository.SolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("solutionService")

public class SolutionService {
    @Autowired
    SolutionRepository solutionRepository;

    public void addSolution(String recordnum,int recordID,Date deltime,int userID,String username,String title,String context) {
        solutionRepository.addSolution(recordnum,recordID,deltime,userID,username,title,context);
    }

    public void updateSolution(int solutionID,String title,String context) {
        solutionRepository.updateSolution(solutionID, title, context);
    }

    public void deleteSolution(int solutionID) {
        solutionRepository.deleteById(solutionID);
    }

    public List<Solution> searchSolutionByName (String username){
        List<Solution> solutionList= solutionRepository.searchSolutionByName(username);
        return solutionList;
    }

}
