package com.example.jdbc111.bean;

import org.springframework.stereotype.Component;

@Component
public class Empolyee {
    //`id` int(11) NOT NULL AUTO_INCREMENT,
    //  `lastName` varchar(255) DEFAULT NULL,
    //  `email` varchar(255) DEFAULT NULL,
    //  `gender` int(2) DEFAULT NULL,
    //  `d_id` int(11) DEFAULT NULL,
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer dId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}
