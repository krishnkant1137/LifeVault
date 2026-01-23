package com.example.demo.dto;

public class NomineeRequestDTO {
    private String fullName;
    private String email;
    private String phone;
    public NomineeRequestDTO() {
    }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
