package com.arobs.library.model.employee.entity;

import com.arobs.library.model.book.entity.Book;
import com.arobs.library.model.employee.helper.UserRole;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50, unique = true)
    @NotNull
    private String name;

    @Enumerated(EnumType.STRING)
    @Column
    @NotNull
    private UserRole role;

    @Column(nullable = false, length = 50)
    @NotNull
    private String password;

    @Column(nullable = false, length = 50)
    @Email
    private String email;

    @Column(name = "ban_end_date")
    private Date banEndDate;

    public Employee() {
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
        if(role == null){
            throw new IllegalStateException();
        }
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

    //class specific methods
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Employee)) {
            return false;
        }
        return name != null && name.equals(((Employee) obj).getName());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
