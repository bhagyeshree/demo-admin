package com.cognizant.goldenretrievers.adminservices;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BadgeController {

    @Autowired
    private BadgesDataStore badgeDataStore;

    @PostMapping("/requestBadge")
    public String test(@RequestBody BadgeRequest badgeRequest) {


        if (null == badgeRequest || badgeRequest.getEmployeeId().isEmpty()) {
            BadgeResult badgeResult =  new BadgeResult();
            badgeResult.setStatusMessage("error");
            //return badgeResult.toString();
            return badgeResult.getBadgeId();
        }

       return  badgeDataStore.getBadge(badgeRequest.getEmployeeId());
    }


    @PostMapping("/returnBadge")
    public String returnBadges(@RequestBody BadgeRequest badgeRequest){


        if (null == badgeRequest || badgeRequest.getBadgeNumber().isEmpty()) {
            BadgeResult badgeResult =  new BadgeResult();
            badgeResult.setStatusMessage("error");
            return badgeResult.toString();
        }

        return badgeDataStore.returnIssuedBadge(badgeRequest.getBadgeNumber());

    }


}
