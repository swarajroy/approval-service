package org.agiledev.learnbydoing.approvalservice;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by swarajroy on 12/08/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApprovalServiceApplication.class)
@AutoConfigureMessageVerifier
public class BaseClass {

    @Autowired
    private ApprovalController approvalController;

    @Before
    public void setUp(){
        RestAssuredMockMvc.standaloneSetup(approvalController);
    }

    public void triggerApprovedMessage(){
        approvalController.triggerApprovalMessage();
    }
}
