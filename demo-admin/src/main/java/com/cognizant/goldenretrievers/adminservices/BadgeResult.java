package com.cognizant.goldenretrievers.adminservices;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class BadgeResult {

    private String badgeId;

    private String statusMessage;
    public BadgeResult(){}
    @JsonCreator
    public BadgeResult(@JsonProperty("statusMessage") final String statusMessage, @JsonProperty("badgeId") final String badgeId) {

        this.statusMessage = statusMessage;
        this.badgeId = badgeId;
    }

    public String getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(String badgeId) {
        this.badgeId = badgeId;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    @Override
    public String toString() {
       return  "{\"badgeId\" :" + "\"" + badgeId+ "\" ," + "\"statusMessage\":"
               + "\"" + statusMessage+ "\" " + "}";
   }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BadgeResult)) return false;
        BadgeResult that = (BadgeResult) o;
        return Objects.equals(getBadgeId(), that.getBadgeId()) &&
                Objects.equals(getStatusMessage(), that.getStatusMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBadgeId(), getStatusMessage());
    }
}
