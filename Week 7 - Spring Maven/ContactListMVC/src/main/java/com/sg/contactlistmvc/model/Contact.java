/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.contactlistmvc.model;

import java.util.Objects;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author apprentice
 */
public class Contact {
   private int contactId;
   @NotEmpty(message ="Please enter a First Name.")
   @Length(max=50,message = "First Name must be no longer than 50 characters.")
   private String firstName;
   @NotEmpty(message ="Please enter a Last Name.")
   @Length(max=50,message = "Last Name must be no longer than 50 characters.")
   private String lastName;
   @NotEmpty(message ="Please enter a Company.")
   @Length(max=50,message = "Company Name must be no longer than 50 characters.")
   private String company;
   @NotEmpty(message = "Please enter an Email address.")
   @Email(message = "Please enter a valid Email address.")
   @Length(max=50,message = "Email Address must be no longer than 50 characters.")
   private String email;
   @NotEmpty(message ="Please enter a Phone Number.")
   @Length(max=10,message = "Phone Number must be no longer than 10 characters.")
   private String phone;

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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
   
   @Override
   public int hashCode(){
     int hash = 5;
     hash = 37 * hash + this.contactId;
     hash = 37 * hash + hash + Objects.hashCode(this.firstName);
     hash = 37 * hash + hash + Objects.hashCode(this.lastName);
     hash = 37 * hash + hash + Objects.hashCode(this.company);
     hash = 37 * hash + hash + Objects.hashCode(this.email);
     hash = 37 * hash + hash + Objects.hashCode(this.phone);

     return hash;
   }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contact other = (Contact) obj;
        if (this.contactId != other.contactId) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        return true;
    }
   
}
