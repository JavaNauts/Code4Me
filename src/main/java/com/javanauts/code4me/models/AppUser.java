package com.javanauts.code4me.models;

<<<<<<< HEAD:src/main/java/com/javanauts/code4me/models/appUser.java
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class appUser {
=======
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

>>>>>>> c04c7563ce0b65b01aef36cfa86e81b78c236768:src/main/java/com/javanauts/code4me/models/AppUser.java
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    @OneToOne
    Profile profile;

    @OneToMany(mappedBy = "appUser")
    List<Receipts> receiptList;

    protected AppUser() {
    }

    public AppUser(String userName, String password, String firstName,
                   String lastName, String email) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
