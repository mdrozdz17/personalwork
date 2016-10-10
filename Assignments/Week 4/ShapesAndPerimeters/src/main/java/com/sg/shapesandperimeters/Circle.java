/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shapesandperimeters;

/**
 *
 * @author apprentice
 */
public class Circle extends Shape {
     private double radius;
     double pi = Math.PI;

    public Circle(String color, double radius) {
        this.color = color;
        this.radius = radius;
                
    }   

    @Override
    public double area() {
        
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        
        return 2 * pi * radius;
    }
}
    

