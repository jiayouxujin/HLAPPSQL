package com.xxx.demo.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operation_id")
    int operationID;

    @Column
    Date operationday;

    @Column(name = "deviceid_list")
    String deviceidList;

    public Operation(){}

    public Operation(Date operationday, String deviceidList) {
        this.operationday = operationday;
        this.deviceidList = deviceidList;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operationID=" + operationID +
                ", operationday=" + operationday +
                ", deviceidList='" + deviceidList + '\'' +
                '}';
    }

    public int getOperationID() {
        return operationID;
    }

    public void setOperationID(int operationID) {
        this.operationID = operationID;
    }

    public Date getOperationday() {
        return operationday;
    }

    public void setOperationday(Date operationday) {
        this.operationday = operationday;
    }

    public String getDeviceidList() {
        return deviceidList;
    }

    public void setDeviceidList(String deviceidList) {
        this.deviceidList = deviceidList;
    }
}
