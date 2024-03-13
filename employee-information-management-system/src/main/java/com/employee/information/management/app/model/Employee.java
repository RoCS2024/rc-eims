package com.employee.information.management.app.model;

public class Employee {
    private String lastName;
    private String middleName;
    private String firstName;
    private String positionInRC;
    private String dateEmployed;
    private String birthDate;
    private String birthPlace;
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
    private String employeeNo;

    public Employee() {

    }

    public Employee(String lastName, String middleName, String firstName, String positionInRC, String dateEmployed, String birthDate, String birthPlace, String sex, String civilStatus, String citizenship, String religion, double height, double weight, String email, String sssNo, String tinNo, String pagibigNo, String employeeNo) {
        this.lastName = lastName;
        this.middleName = middleName;
        this.firstName = firstName;
        this.positionInRC = positionInRC;
        this.dateEmployed = dateEmployed;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.sex = sex;
        this.civilStatus = civilStatus;
        this.citizenship = citizenship;
        this.religion = religion;
        this.height = height;
        this.weight = weight;
        this.email = email;
        this.sssNo = sssNo;
        this.tinNo = tinNo;
        this.pagibigNo = pagibigNo;
        this.employeeNo = employeeNo;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPositionInRC() {
        return positionInRC;
    }

    public void setPositionInRC(String positionInRC) {
        this.positionInRC = positionInRC;
    }

    public String getDateEmployed() {
        return dateEmployed;
    }

    public void setDateEmployed(String dateEmployed) {
        this.dateEmployed = dateEmployed;
    }
    public String getBirthDate() {
        return birthDate;
        }

        public void setBirthDate (String birthDate){
            this.birthDate = birthDate;
        }

        public String getBirthPlace () {
            return birthPlace;
        }

        public void setBirthPlace (String birthPlace){
            this.birthPlace = birthPlace;
        }

        public String getSex () {
            return sex;
        }

        public void setSex (String sex){
            this.sex = sex;
        }

        public String getCivilStatus () {
            return civilStatus;
        }

        public void setCivilStatus (String civilStatus){
            this.civilStatus = civilStatus;
        }

        public String getCitizenship () {
            return citizenship;
        }

        public void setCitizenship (String citizenship){
            this.citizenship = citizenship;
        }

        public String getReligion () {
            return religion;
        }

        public void setReligion (String religion){
            this.religion = religion;
        }

        public double getHeight () {
            return height;
        }

        public void setHeight ( double height){
            this.height = height;
        }

        public double getWeight () {
            return weight;
        }

        public void setWeight ( double weight){
            this.weight = weight;
        }

        public String getEmail () {
            return email;
        }

        public void setEmail (String email){
            this.email = email;
        }

        public String getSssNo () {
            return sssNo;
        }

        public void setSssNo (String sssNo){
            this.sssNo = sssNo;
        }

        public String getTinNo () {
            return tinNo;
        }

        public void setTinNo (String tinNo){
            this.tinNo = tinNo;
        }

        public String getPagibigNo () {
            return pagibigNo;
        }

        public void setPagibigNo (String pagibigNo){
            this.pagibigNo = pagibigNo;
        }

        public String getEmployeeNo () {
            return employeeNo;
        }

        public void setEmployeeNo (String employeeNo){
            this.employeeNo = employeeNo;
        }

    }
