package com.example.crm.crm_backend.dto;


public class ClientDto {
    private Long id;
    private String companyName;
    private String email;
    private String phoneNumber;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ClientDto(){

    }
    public ClientDto(Long id, String companyName, String email, String phoneNumber, String address) {
        this.id = id;
        this.companyName = companyName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}