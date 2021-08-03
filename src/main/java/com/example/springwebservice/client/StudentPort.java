/**
 * StudentPort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.example.springwebservice.client;

public interface StudentPort extends java.rmi.Remote {
    public com.example.springwebservice.client.GetStudentsResponse getStudents(com.example.springwebservice.client.GetStudentsRequest getStudentsRequest) throws java.rmi.RemoteException;
    public com.example.springwebservice.client.GetStudentByNameResponse getStudentByName(com.example.springwebservice.client.GetStudentByNameRequest getStudentByNameRequest) throws java.rmi.RemoteException;
}
