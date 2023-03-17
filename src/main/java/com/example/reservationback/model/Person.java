package com.example.reservationback.model;

import javax.persistence.Embeddable;
import java.lang.reflect.Array;

@Embeddable
public class Person {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    public Person() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Person(String firstname, String lastname, String email, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }

    public String[] toArray(){
        return new String[] {this.firstname, this.lastname, this.email, this.phone};
    }


}
