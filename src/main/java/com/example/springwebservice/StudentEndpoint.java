package com.example.springwebservice;

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

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetStudentByNameRequest")
    @ResponsePayload
    public GetStudentByNameResponse GetStudentByName(@RequestPayload GetStudentByNameRequest request) {
        GetStudentByNameResponse response = new GetStudentByNameResponse();
        response.setStudent(studentRepository.findStudent(request.getName()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetStudentsRequest")
    @ResponsePayload
    public GetStudentsResponse GetStudents() {
        GetStudentsResponse response = new GetStudentsResponse();
        response.getStudents().add(new Student("test1",78,"地址1"));
        response.getStudents().add(new Student("test2",20,"地址2"));
        return response;
    }

}
