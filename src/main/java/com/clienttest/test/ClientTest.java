package com.clienttest.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class ClientTest {
    Log log = LogFactory.getLog(ClientTest.class);
    @Test
    public void test(){
        try{
            StudentPortServiceStub stub =new StudentPortServiceStub();
            stub.startgetStudents(new StudentPortServiceStub.GetStudentsRequest(), new StudentPortServiceCallbackHandler() {
                @Override
                public void receiveResultgetStudents(StudentPortServiceStub.GetStudentsResponse result) {
                    log.info(result.getJsonString());
                }
            });
            log.info("Start!");
            log.info(stub.getStudents(new StudentPortServiceStub.GetStudentsRequest()).getJsonString());
            log.info("End!");
        }catch(Exception error){
            log.error("获取Students信息出错了",error);
        }
    }
}
