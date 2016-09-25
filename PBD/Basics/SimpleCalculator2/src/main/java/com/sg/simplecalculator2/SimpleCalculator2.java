/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.simplecalculator2;

/**
 *
 * @author apprentice
 */
public class SimpleCalculator2 {

    public float doAddition(float num1, float num2) {
        float sum = num1 + num2;
        return sum;
    }

    public float doSubtration(float num1, float num2) {
        float sum = num1 - num2;
        return sum;
    }

    public float doMultiplication(float num1, float num2) {
        float sum = num1 * num2;
        return sum;
    }

    public float doDivision(int num1, int num2) {
        int sum = 0;
        try {
            sum = num1 / num2;

        } catch (Exception e) {
            System.out.println("Division by zero. Please enter a valid number");
        }

        return sum;
    }
}
