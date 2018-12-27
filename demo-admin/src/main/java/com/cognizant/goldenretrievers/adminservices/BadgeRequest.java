package com.cognizant.goldenretrievers.adminservices;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class BadgeRequest {

    private String employeeId;

    private String badgeNumber;

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String batchNumber) {
        this.badgeNumber = batchNumber;
    }

    public BadgeRequest(){

    }

    @JsonCreator
    public BadgeRequest(@JsonProperty("employeeId") final String employeeId){
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        employeeId = employeeId;
    }
}
