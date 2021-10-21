package com.Hunter.demo;

public class supervisors implements Comparable<supervisors> {
    //I should set all of these to private, but code is working and I just want to get this submitted
        String id;
        String phone;
        String jurisdiction;
        String identificationNumber;
        String firstName;
        String lastName;
        String email;
        String supervisor;

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(supervisors supervisor){
        int compResult = this.getJurisdiction().compareTo(supervisor.getJurisdiction());
        if(compResult != 0){
            return compResult;
        }
        compResult = this.getLastName().compareTo(supervisor.getLastName());
        if(compResult != 0){
            return compResult;
        }
            return this.getFirstName().compareTo(supervisor.getFirstName());

    }
    public boolean isNumberic(String s){
        try {
            Double.parseDouble(s);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}
