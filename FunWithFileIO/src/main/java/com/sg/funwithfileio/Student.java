/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.funwithfileio;

/**
 *
 * @author apprentice
 */
public class Student {
    private boolean isHungry;
    private String name;
    private String school;
    private Integer favoriteNumber;
    // Can be anything :: or | or ^ or ~ is recommended
    // Delimter is used to seperate fields/properties in a text file or single-line representation
    private final String DELIMETER = "::";
    
    public Student(String name, Integer faveNumber){ // Constructor (a.k.a method)
        isHungry = true;
        school = "The Software Guild";
        // The keyword "this" makes the property name less ambigious
        // Since the property name and variable name are the same, we need "this"
        this.name = name;
        // We can leave the "this" off if there is no ambiguity
        // Note that this instance's favoriteNumber property is set to the variable faveNumber's value
        favoriteNumber = faveNumber;
    }
    
    // Private default constructor
    // Only decode (and any other methods in here) can use the empty constructor
    // Everyone else needs to use the public constructors
    public Student(){
        
    }
    
    @Override
    public String toString(){
        return "Name: " + name + " \nIs Hungry? " + isHungry;
    }
    
    // Purpose of this is to have a format to write our object to a file
    public String encode(){
        // :: in this case is called a delimeter 
        return name + DELIMETER + isHungry + DELIMETER + favoriteNumber;
        
    }
    
    //Specifically how to decode the object
    public Student decode(String stringToDecode){
        // Object to decode into - that we will return
        Student myStudent = new Student();
        // Splitting a delimited (encoded) String
        // String is currently set to name::isHungry::favoriteNumber
        
        // Part 1 is to split all the properties into a String array where the Delimeter is
        String[] studentProperties = stringToDecode.split(DELIMETER);
        // Part 2 is to assign the values from the String array to the properties
        // That means name is at index 0, isHungry is index 1 and favoriteNumber is index 2
        myStudent.name = studentProperties[0];
        myStudent.isHungry = Boolean.parseBoolean(studentProperties[1]);
        myStudent.favoriteNumber = Integer.parseInt(studentProperties[2]);
        // return the student object
        return myStudent;
        
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public boolean getIsHungry() {
        return isHungry;
    }

    public void setIsHungry(boolean isHungry) {
        this.isHungry = isHungry;
    }
}
        

