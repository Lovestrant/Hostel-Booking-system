package com.example.hostelbookingsystem;

public class Member {
 String fullName; String securityKey; String phoneNumber; String password;

    public Member(String fullName, String securityKey, String phoneNumber, String password) {
        this.fullName = fullName;
        this.securityKey = securityKey;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getSecurityKey() {
        return securityKey;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
