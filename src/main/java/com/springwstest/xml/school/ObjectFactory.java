//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.7 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2021.08.04 时间 07:07:52 PM ICT 
//


package com.springwstest.xml.school;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.springwstest.xml.school package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.springwstest.xml.school
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetStudentByNameResponse }
     * 
     */
    public GetStudentByNameResponse createGetStudentByNameResponse() {
        return new GetStudentByNameResponse();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link GetStudentsResponse }
     * 
     */
    public GetStudentsResponse createGetStudentsResponse() {
        return new GetStudentsResponse();
    }

    /**
     * Create an instance of {@link GetStudentByNameRequest }
     * 
     */
    public GetStudentByNameRequest createGetStudentByNameRequest() {
        return new GetStudentByNameRequest();
    }

    /**
     * Create an instance of {@link GetStudentsRequest }
     * 
     */
    public GetStudentsRequest createGetStudentsRequest() {
        return new GetStudentsRequest();
    }

}
