/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.model;

import java.util.Objects;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author apprentice
 */
public class DVD {
    private int dvdId;
    @NotEmpty(message ="Please enter a DVD Title.")
    @Length(max=50,message = "DVD Title must be no longer than 50 characters.")
    private String title;
   @NotEmpty(message ="Please enter a Release Date.")
   @Pattern(regexp="[0-9]+", message = "The Releaste date must be a Year (i.e 2016)")
   @Length(min=4, max = 4, message = "Release Date must be no longer than 4 characters.")
    private String releaseDate;
   @NotEmpty(message ="Please enter an MPAA Rating.")
   @Length(max = 5, message = "MPAA-Rating must be no longer than 5 characters.")
    private String mpaaRating;
   @NotEmpty(message ="Please enter a Director's Name.")
   @Length(max=50,message = "Director's Name must be no longer than 50 characters.")
    private String directorsName;
   @NotEmpty(message ="Please enter a Studio Name.")
   @Length(max=50,message = "Studio Name must be no longer than 50 characters.")
    private String studio;
   @NotEmpty(message ="Please enter User Notes.")
   @Length(max=200,message = "User Notes must be no longer than 200 characters.")
    private String userRating;
    private String date;

    public int getDvdId() {
        return dvdId;
    }

    public void setDvdId(int dvdId) {
        this.dvdId = dvdId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    @Override
   public int hashCode(){
     int hash = 5;
     hash = 37 * hash + this.dvdId;
     hash = 37 * hash + hash + Objects.hashCode(this.title);
     hash = 37 * hash + hash + Objects.hashCode(this.releaseDate);
     hash = 37 * hash + hash + Objects.hashCode(this.mpaaRating);
     hash = 37 * hash + hash + Objects.hashCode(this.directorsName);
     hash = 37 * hash + hash + Objects.hashCode(this.studio);
     hash = 37 * hash + hash + Objects.hashCode(this.userRating);
     hash = 37 * hash + hash + Objects.hashCode(this.date);

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
        final DVD other = (DVD) obj;
        if (this.dvdId != other.dvdId) {
            return false;
        }
           if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.mpaaRating, other.mpaaRating)) {
            return false;
        }
        if (!Objects.equals(this.directorsName, other.directorsName)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
         if (!Objects.equals(this.userRating, other.userRating)) {
            return false;
        }
         if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }
    
}
