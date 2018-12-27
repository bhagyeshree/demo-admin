package com.cognizant.goldenretrievers.adminservices;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

final class Badge {


    private  long id;

    private String status;

    private String employeeId;

    public Badge(){

    }

    @JsonCreator
    public Badge(@JsonProperty("status") final String status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Badge)) return false;
        Badge badge = (Badge) o;
        return getId() == badge.getId() &&
                Objects.equals(getStatus(), badge.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStatus());
    }
}
