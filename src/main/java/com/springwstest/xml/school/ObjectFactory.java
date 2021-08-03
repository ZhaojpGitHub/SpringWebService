package com.springwstest.xml.school;


import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() { }

    public GetStudentByNameResponse createGetStudentByNameResponse() {
        return new GetStudentByNameResponse();
    }

    public Student createStudent() {
        return new Student();
    }

    public GetStudentsResponse createGetStudentsResponse() {
        return new GetStudentsResponse();
    }

    public GetStudentByNameRequest createGetStudentByNameRequest() {
        return new GetStudentByNameRequest();
    }

    public GetStudentsRequest createGetStudentsRequest() {
        return new GetStudentsRequest();
    }

}
