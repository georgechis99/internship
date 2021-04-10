package com.arobs.library.model.dto;

import com.arobs.library.model.helper.UserRole;

import java.sql.Date;

public class EmployeeDTO {

    private Integer id;
    private String name;
    private UserRole role;
    private String password;
    private String email;
    private Date banEndDate;

    public EmployeeDTO(Integer id, String name, UserRole role, String password, String email, Date banEndDate) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.password = password;
        this.email = email;
        this.banEndDate = banEndDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBanEndDate() {
        return banEndDate;
    }

    public void setBanEndDate(Date banEndDate) {
        this.banEndDate = banEndDate;
    }
}
