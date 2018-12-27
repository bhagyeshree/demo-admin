package com.cognizant.goldenretrievers.adminservices;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Component
public class BadgesDataStore {



    Map<Integer, String> badges = new HashMap<Integer, String>();

    int counter = 0;

    AtomicInteger badgeNumber = new AtomicInteger();

    public BadgesDataStore(){
        IntStream.rangeClosed(1, 100)
                .forEach(value -> badges.put(value, null));
    }


    public String getBadge(String employeeId) {

        BadgeResult result = new BadgeResult();

        if(badges.containsValue(employeeId)){

            result.setBadgeId("-1");
            result.setStatusMessage("employee already assigned a badge ");
            return result.toString();
        }


        final Map.Entry<Integer, String> firstNonIssuedBadge = badges.entrySet().stream()
                .filter(entry -> entry.getValue() == null)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("badge not available"));

        badges.put(firstNonIssuedBadge.getKey(), employeeId);

             result.setBadgeId(firstNonIssuedBadge.getKey().toString());
             result.setStatusMessage("badge Assigned successfully");
             return result.getBadgeId();


}


    public String returnIssuedBadge(String  badgeNumber) {
        BadgeResult result = new BadgeResult();

        int badgeN = 0;

        try {
            badgeN = Integer.parseInt(badgeNumber);
        } catch (NumberFormatException e) {

            result.setStatusMessage("please enter a number");
            result.setBadgeId(badgeNumber);
            return result.toString();
        }


        if (badges.containsKey(badgeN)) {

            String employee = badges.get(badgeN);

            if (null == employee || employee.isEmpty()) {

                result.setStatusMessage("this badge number is unknown");
                result.setBadgeId(badgeNumber);
                return result.toString();
            }

            badges.put(Integer.parseInt(badgeNumber), null);
            result.setStatusMessage("returned successfully");
            result.setBadgeId(badgeNumber);

            return result.toString();
        }

        result.setStatusMessage("this badge number is unknown");
        result.setBadgeId(badgeNumber);
        return result.toString();

    }





}
