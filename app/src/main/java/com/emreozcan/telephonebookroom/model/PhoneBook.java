package com.emreozcan.telephonebookroom.model;

public class PhoneBook {
    private String personName;
    private String personNumber;

    public PhoneBook() {
    }

    public PhoneBook(String personName, String personNumber) {
        this.personName = personName;
        this.personNumber = personNumber;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
    }
}
