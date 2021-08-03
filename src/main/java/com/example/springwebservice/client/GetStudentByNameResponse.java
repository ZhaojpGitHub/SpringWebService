/**
 * GetStudentByNameResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.example.springwebservice.client;

public class GetStudentByNameResponse  implements java.io.Serializable {
    private com.example.springwebservice.client.Student student;

    public GetStudentByNameResponse() {
    }

    public GetStudentByNameResponse(
           com.example.springwebservice.client.Student student) {
           this.student = student;
    }


    /**
     * Gets the student value for this GetStudentByNameResponse.
     * 
     * @return student
     */
    public com.example.springwebservice.client.Student getStudent() {
        return student;
    }


    /**
     * Sets the student value for this GetStudentByNameResponse.
     * 
     * @param student
     */
    public void setStudent(com.example.springwebservice.client.Student student) {
        this.student = student;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetStudentByNameResponse)) return false;
        GetStudentByNameResponse other = (GetStudentByNameResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.student==null && other.getStudent()==null) || 
             (this.student!=null &&
              this.student.equals(other.getStudent())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getStudent() != null) {
            _hashCode += getStudent().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetStudentByNameResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.springwsTest.com/xml/school", ">GetStudentByNameResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("student");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.springwsTest.com/xml/school", "Student"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.springwsTest.com/xml/school", "Student"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}