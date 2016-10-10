/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shapesandperimeters;

import java.math.BigInteger;

/**
 *
 * @author apprentice
 */
public class Square extends Shape {
    
    private String color;
    private double side;
    
    
    public Square (String color, double side ) {
        this.color=color;
        this.side=side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double perimeter() {
        return side * 4;
    }
    
}
