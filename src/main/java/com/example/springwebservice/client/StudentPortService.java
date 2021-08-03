/**
 * StudentPortService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.example.springwebservice.client;

public interface StudentPortService extends javax.xml.rpc.Service {
    public java.lang.String getStudentPortSoap11Address();

    public com.example.springwebservice.client.StudentPort getStudentPortSoap11() throws javax.xml.rpc.ServiceException;

    public com.example.springwebservice.client.StudentPort getStudentPortSoap11(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
