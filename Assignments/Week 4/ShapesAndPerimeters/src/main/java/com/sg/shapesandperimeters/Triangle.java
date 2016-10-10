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
public class Triangle extends Shape {
    
    private String color;
    private double a; // sides of triangle = a,b,c
    private double b;
    private double c;
    private double height;
    private double base;
    
    public Triangle (String color, double a, double b, double c, double height, double base) {
        this.color = color;
        this.a = a;
        this.b = b;
        this.c = c;
        this.height= height;
        this.base=base;
        
    }

    @Override
    public double area() {
        return height * base / 2;
        
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }
    
    
}
