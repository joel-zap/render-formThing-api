package com.joel.model;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "leads")
public class Lead {
    @Id
    private String id;

    @NotBlank(message = "FirstName cannot be empty !")
    private String firstName;

    @NotBlank(message = "LastName cannot be empty !")
    private String lastName;

    @NotBlank(message = "Email cannot be empty !")
    @Email()
    private String email;

    @NotBlank(message = "Mobile cannot be empty !")
    private String mobile;

    public Lead() {
    }

    public Lead(String firstName, String lastName, String email, String mobile) {
//        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
