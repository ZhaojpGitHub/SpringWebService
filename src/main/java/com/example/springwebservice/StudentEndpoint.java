package com.example.springwebservice;

import com.alibaba.fastjson.JSON;
import com.springwstest.xml.school.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StudentEndpoint {
    private static final String NAMESPACE_URI = "http://www.springwsTest.com/xml/school";
    @Autowired
    private StudentRepository studentRepository;
    private ObjectFactory objectFactory=new ObjectFactory();

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetStudentByNameRequest")
    @ResponsePayload
    public GetStudentByNameResponse GetStudentByName(@RequestPayload GetStudentByNameRequest request) {
        GetStudentByNameResponse response = objectFactory.createGetStudentByNameResponse();
        response.setStudent(studentRepository.findStudent(request.getName()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetStudentsRequest")
    @ResponsePayload
    public GetStudentsResponse GetStudents(@RequestPayload GetStudentsRequest request) {
        GetStudentsResponse response = objectFactory.createGetStudentsResponse();
        response.setJsonString(JSON.toJSONString(studentRepository.getAllStudentInfo()));
        return response;
    }

}
