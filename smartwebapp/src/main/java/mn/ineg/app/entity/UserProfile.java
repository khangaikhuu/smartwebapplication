/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mn.ineg.app.entity;

import java.util.Date;

/**
 *
 * @author developer
 */
public class UserProfile {
    private String username;
    private String firstname;
    private String lastname;
    private String registerNumber;
    private String address;
    private String email;
    private String divisionName;
    private String occCertName;
    private Date occCertDate;
    private String englishLevel;
    private Date englishLevelDate;

    public UserProfile() {
    }
    
    public UserProfile(String username, String firstname, String lastname, String registerNumber, String address, String email) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.registerNumber = registerNumber;
        this.address = address;
        this.email = email;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public String getOccCertName() {
        return occCertName;
    }

    public void setOccCertName(String occCertName) {
        this.occCertName = occCertName;
    }

    public Date getOccCertDate() {
        return occCertDate;
    }

    public void setOccCertDate(Date occCertDate) {
        this.occCertDate = occCertDate;
    }

    public String getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(String englishLevel) {
        this.englishLevel = englishLevel;
    }

    public Date getEnglishLevelDate() {
        return englishLevelDate;
    }

    public void setEnglishLevelDate(Date englishLevelDate) {
        this.englishLevelDate = englishLevelDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
