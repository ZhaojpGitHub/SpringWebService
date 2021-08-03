package com.example.springwebservice;

//import com.example.springwebservice.client.*;
import com.example.springwebservice.client.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class ClientTest {
    Log log = LogFactory.getLog(ClientTest.class);
    @Test
    public void getStudentByName(){
        try{
            log.info("开始打印Student");
            StudentPortServiceLocator serviceLocator =new StudentPortServiceLocator();
            Student student= serviceLocator.getStudentPortSoap11().getStudentByName(new GetStudentByNameRequest("Lokesh")).getStudent();
            log.info(student.toString());
        }catch(Exception error){
            log.error("获取Student信息出错了",error);
        }
    }
    @Test
    public void getStudents(){
        try{
            log.info("开始打印Students");
            StudentPortServiceLocator serviceLocator =new StudentPortServiceLocator();
            GetStudentsRequest getStudentsRequest = new GetStudentsRequest();
            StudentPort studentPort= serviceLocator.getStudentPortSoap11();
            GetStudentsResponse studentsRequest = studentPort.getStudents(getStudentsRequest);
            String s = studentsRequest.getJsonString();
            log.info(s);
        }catch(Exception error){
            log.error("获取Students信息出错了",error);
        }
    }
}
