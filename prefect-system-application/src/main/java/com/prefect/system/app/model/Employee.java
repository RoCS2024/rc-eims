package com.prefect.system.app.model;

import java.sql.Timestamp;

public class Employee {
    private String lastName;
    private String firstName;
    private String middleName;
    private String positionInRc;
    private String dateEmployed;
    private Timestamp birthdate;
    private String birthplace;
    private String sex;
    private String civilStatus;
    private String citizenship;
    private String religion;
    private double height;
    private double weight;
    private String email;
    private String sssNo;
    private String tinNo;
    private String pagibigNo;
    private String employeeId;

    public Employee() {

    }
    public Employee
            (String lastName, String firstName, String middleName, String positionInRc, String dateEmployed, Timestamp birthdate, String birthplace, String sex, String civilStatus, String citizenship, String religion, double height, double weight, String email, String sssNo, String tinNo, String pagibigNo, String employeeId)
    {
        this.lastName = lastName;
        this.firstName= firstName;
        this.middleName= middleName;
        this.positionInRc = positionInRc;
        this.dateEmployed = dateEmployed;
        this.birthdate= birthdate;
        this.birthplace=birthplace;
        this.sex=sex;
        this.civilStatus=civilStatus;
        this.citizenship= citizenship;
        this.religion=religion;
        this.religion = religion;
        this.height = height;
        this.weight = weight;
        this.email = email;
        this.sssNo = sssNo;
        this.tinNo = tinNo;
        this.pagibigNo = pagibigNo;
        this.employeeId = employeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPositionInRc() {
        return positionInRc;
    }

    public void setPositionInRc(String positionInRc) {
        this.positionInRc = positionInRc;
    }

    public String getDateEmployed() {
        return dateEmployed;
    }

    public void setDateEmployed(String dateEmployed) {
        this.dateEmployed = dateEmployed;
    }

    public Timestamp getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Timestamp birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSssNo() {
        return sssNo;
    }

    public void setSssNo(String sssNo) {
        this.sssNo = sssNo;
    }

    public String getTinNo() {
        return tinNo;
    }

    public void setTinNo(String tinNo) {
        this.tinNo = tinNo;
    }

    public String getPagibigNo() {
        return pagibigNo;
    }

    public void setPagibigNo(String pagibigNo) {
        this.pagibigNo = pagibigNo;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setId(long aLong) {
    }
}
