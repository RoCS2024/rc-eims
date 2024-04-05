package com.employee.info.mgmt.appl.model;

import java.sql.Timestamp;

/**
 * Employee model class representing employee information.
 */

public class Employee {
    private String lastName;
    private String firstName;
    private String middleName;
    private String positionInRC;
    private Timestamp dateEmployed;
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
    private String employeeNo;

    /**
     * Default constructor for Employee.
     */

    public Employee(){

    }

    public Employee(String lastName, String firstName, String middleName, String positionInRC, Timestamp dateEmployed, Timestamp birthdate, String birthplace, String sex, String civilStatus, String citizenship, String religion, String height, String weight, String email, String sssNo, String tinNo, String pagibigNo, String employeeNo){

        /**
         * Constructor for Employee with parameters.
         */
        
        
        /**
         * @param lastName Last name of the employee.
         */
        this.lastName = lastName;
        
        /**
         * @param firstName First name of the employee.
         */
        this.firstName = firstName;
        
        /**
         * @param middleName Middle name of the employee.
         */
        this.middleName = middleName;
        
        /**
         * @param positionInRC Position of the employee in the organization.
         */
        this.positionInRC = positionInRC;
        
        /**
         * @param dateEmployed Date when the employee was employed.
         */
        this.dateEmployed = dateEmployed;
        
        /**
         * @param birthdate Birthdate of the employee.
         */
        this.birthdate = birthdate;
        
        /**
         * @param lastName Last name of the employee.
         */
        this.birthplace = birthplace;
        
        /**
         * @param sex Gender of the employee.
         */
        this.sex = sex;
        
        /**
         * @param civilStatus Civil status of the employee.
         */
        this.civilStatus = civilStatus;
        
        /**
         * @param citizenship Citizenship of the employee.
         */
        this.citizenship = citizenship;
        
        /**
         * @param religion Religion of the employee.
         */
        this.religion = religion;
        
        /**
         * @param height Height of the employee (in meters).
         */
        this.height = Double.parseDouble(height);
        
        /**
         * @param weight Weight of the employee (in kilograms).
         */
        this.weight = Double.parseDouble(weight);
        
        /**
         * @param email Email address of the employee.
         */
        this.email = email;
        
        /**
         * @param sssNo Social Security System (SSS) number of the employee.
         */
        this.sssNo = sssNo;
        
        /**
         * @param tinNo Tax Identification Number (TIN) of the employee.
         */
        this.tinNo = tinNo;
        
        /**
         * @param pagibigNo Pag-IBIG Fund number of the employee.
         */
        this.pagibigNo = pagibigNo;
        
        /**
         * @param employeeNo Employee number of the employee.
         */
        this.employeeNo = employeeNo;

    }

    /**
     * Get the last name of the employee.
     * @return The last name of the employee.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of the employee.
     * @param lastName The last name of the employee.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the first name of the employee.
     * @return The first name of the employee.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the employee.
     * @param firstName The first name of the employee.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the middle name of the employee.
     * @return The middle name of the employee.
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Set the middle name of the employee.
     * @param middleName The middle name of the employee.
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Get the position of the employee in the organization.
     * @return The position of the employee.
     */
    public String getPositionInRC() {
        return positionInRC;
    }

    /**
     * Set the position of the employee in the organization.
     * @param positionInRC The position of the employee.
     */
    public void setPositionInRC(String positionInRC) {
        this.positionInRC = positionInRC;
    }

    /**
     * Get the date when the employee was employed.
     * @return The date of employment.
     */
    public Timestamp getDateEmployed() {
        return dateEmployed;
    }

    /**
     * Set the date when the employee was employed.
     * @param dateEmployed The date of employment.
     */
    public void setDateEmployed(Timestamp dateEmployed) {
        this.dateEmployed = dateEmployed;
    }

    /**
     * Get the birthdate of the employee.
     * @return The birthdate of the employee.
     */
    public Timestamp getBirthdate() {
        return birthdate;
    }

    /**
     * Set the birthdate of the employee.
     * @param birthdate The birthdate of the employee.
     */
    public void setBirthdate(Timestamp birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Get the birthplace of the employee.
     * @return The birthplace of the employee.
     */
    public String getBirthplace() {
        return birthplace;
    }

    /**
     * Set the birthplace of the employee.
     * @param birthplace The birthplace of the employee.
     */
    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    /**
     * Get the gender of the employee.
     * @return The gender of the employee.
     */
    public String getSex() {
        return sex;
    }

    /**
     * Set the gender of the employee.
     * @param sex The gender of the employee.
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Get the civil status of the employee.
     * @return The civil status of the employee.
     */
    public String getCivilStatus() {
        return civilStatus;
    }

    /**
     * Set the civil status of the employee.
     * @param civilStatus The civil status of the employee.
     */
    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    /**
     * Get the citizenship of the employee.
     * @return The citizenship of the employee.
     */
    public String getCitizenship() {
        return citizenship;
    }

    /**
     * Set the citizenship of the employee.
     * @param citizenship The citizenship of the employee.
     */
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    /**
     * Get the religion of the employee.
     * @return The religion of the employee.
     */
    public String getReligion() {
        return religion;
    }

    /**
     * Set the religion of the employee.
     * @param religion The religion of the employee.
     */
    public void setReligion(String religion) {
        this.religion = religion;
    }

    /**
     * Get the height of the employee.
     * @return The height of the employee.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Set the height of the employee.
     * @param height The height of the employee.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Get the weight of the employee.
     * @return The weight of the employee.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Set the weight of the employee.
     * @param weight The weight of the employee.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Get the email address of the employee.
     * @return The email address of the employee.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email address of the employee.
     * @param email The email address of the employee.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the Social Security System (SSS) number of the employee.
     * @return The SSS number of the employee.
     */
    public String getSssNo() {
        return sssNo;
    }

    /**
     * Set the Social Security System (SSS) number of the employee.
     * @param sssNo The SSS number of the employee.
     */
    public void setSssNo(String sssNo) {
        this.sssNo = sssNo;
    }

    /**
     * Get the Tax Identification Number (TIN) of the employee.
     * @return The TIN of the employee.
     */
    public String getTinNo() {
        return tinNo;
    }

    /**
     * Set the Tax Identification Number (TIN) of the employee.
     * @param tinNo The TIN of the employee.
     */
    public void setTinNo(String tinNo) {
        this.tinNo = tinNo;
    }

    /**
     * Get the Pag-IBIG Fund number of the employee.
     * @return The Pag-IBIG Fund number of the employee.
     */
    public String getPagibigNo() {
        return pagibigNo;
    }

    /**
     * Set the Pag-IBIG Fund number of the employee.
     * @param pagibigNo The Pag-IBIG Fund number of the employee.
     */
    public void setPagibigNo(String pagibigNo) {
        this.pagibigNo = pagibigNo;
    }

    /**
     * Get the employee number of the employee.
     * @return The employee number of the employee.
     */
    public String getEmployeeNo() {
        return employeeNo;
    }

    /**
     * Set the employee number of the employee.
     * @param employeeNo The employee number of the employee.
     */
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

/**
 * Validation for employee no. should have a pattern.
 * @return true if the employee number is valid, false otherwise.
 */

}
