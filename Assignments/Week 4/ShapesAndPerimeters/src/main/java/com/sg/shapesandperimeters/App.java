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
public class App {
    public static void main(String[] args) {
        
        Shape square = new Square("Blue", 4);
        System.out.println("The area of a square is " + square.area());
        System.out.println("The perimeter of a square is " + square.perimeter());
        
        
        Shape rectangle = new Rectangle("Red",4,6);
        System.out.println("The area of a rectangle is " + rectangle.area());
        System.out.println("The area of a rectangle is " + rectangle.perimeter());
        
        Shape triangle = new Triangle("Green",2,2,2,4,6);
        System.out.println("The area of a triangle is " + triangle.area());
        System.out.println("The area of a triangle is " + triangle.perimeter());
        
        Shape circle = new Circle ("Yellow",3);
        System.out.println("The area of a circle is " + circle.area());
        System.out.println("The area of a circle is " + circle.perimeter());
        
        
    }
    
}
