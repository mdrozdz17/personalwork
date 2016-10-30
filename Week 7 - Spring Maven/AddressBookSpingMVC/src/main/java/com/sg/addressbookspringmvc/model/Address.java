/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbookspringmvc.model;

import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author apprentice
 */
public class Address {
   private int addressId;
   @NotEmpty(message ="Please enter a First Name.")
   @Length(max=50,message = "First Name must be no longer than 50 characters.")
   private String firstName;
   @NotEmpty(message ="Please enter a Last Name.")
   @Length(max=50,message = "Last Name must be no longer than 50 characters.")
   private String lastName;
   @NotEmpty(message ="Please enter a Street Address.")
   @Length(max=50,message = "Street Address can not be longer than 50 characters.")
   private String street;
   @NotEmpty(message = "Please enter a City.")
   @Length(max=21,message = "City can not be longer than 21 characters.")
   private String city;
   @NotEmpty(message ="Please select a State.")
  //@Length(max=10,message = "State cannot be longer than")
   private String state;
   @NotEmpty(message = "Please enter a Zip Code.")
   @Length(min = 5, max=5,message = "Zip Code must be 5 characters long.")
   @Pattern(regexp="[0-9]+")
   private String zip;
   


    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
       public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
   
   
   @Override
   public int hashCode(){
     int hash = 5;
     hash = 37 * hash + this.addressId;
     hash = 37 * hash + hash + Objects.hashCode(this.firstName);
     hash = 37 * hash + hash + Objects.hashCode(this.lastName);
     hash = 37 * hash + hash + Objects.hashCode(this.street);
     hash = 37 * hash + hash + Objects.hashCode(this.city);
     hash = 37 * hash + hash + Objects.hashCode(this.state);
     hash = 37 * hash + hash + Objects.hashCode(this.zip);


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
        final Address other = (Address) obj;
        if (this.addressId != other.addressId) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.street, other.street)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
         if (!Objects.equals(this.zip, other.zip)) {
            return false;
        }
        return true;
    }
}
