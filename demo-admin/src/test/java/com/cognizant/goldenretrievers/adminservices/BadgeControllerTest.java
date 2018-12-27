package com.cognizant.goldenretrievers.adminservices;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.hamcrest.Matchers.contains;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BadgeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private BadgeRequest badgeRequest;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    @Test
    public void requestForBadgeReturnRequestedBadge() throws Exception{
        BadgeResult resultObject = new BadgeResult();
        resultObject.setBadgeId("1");
        resultObject.setStatusMessage("badge Assigned successfully");

        String actual = mvc.perform(post("/requestBadge")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"employeeId\" :" + "\"" + "2" + "\"" + "}"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();


        BadgeResult resultObject1 = new BadgeResult();
        resultObject1.setBadgeId("2");
        resultObject1.setStatusMessage("badge Assigned successfully");

        String actual1 = mvc.perform(post("/requestBadge")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"employeeId\" :" + "\"" + "3" + "\"" + "}"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();


        BadgeResult resultObject2 = new BadgeResult();
        resultObject2.setBadgeId("3");
        resultObject2.setStatusMessage("badge Assigned successfully");

        String actual2 = mvc.perform(post("/requestBadge")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"employeeId\" :" + "\"" + "5" + "\"" + "}"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();


        BadgeResult actualObject2 = OBJECT_MAPPER.readValue(actual2, new TypeReference<BadgeResult>() {
        });

        //Assert
        assertThat(actualObject2, is(resultObject2));
    }





    @Test
    public void returnForBadgeWhatYou() throws Exception{


        String actual = mvc.perform(post("/requestBadge")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"employeeId\" :" + "\"" + "2" + "\"" + "}"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();


        BadgeResult resultObject1 = new BadgeResult();
        resultObject1.setBadgeId("1");
        resultObject1.setStatusMessage("returned successfully");

        String actual1 = mvc.perform(post("/returnBadge")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"badgeNumber\" :" + "\"" + "1" + "\"" + "}"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();


        BadgeResult actualObject1 = OBJECT_MAPPER.readValue(actual1, new TypeReference<BadgeResult>() {
        });

        //Assert
        assertThat(actualObject1, is(resultObject1));
    }






}
