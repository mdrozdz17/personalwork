/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.basicarrays3;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class BasicArrays3 {
    
    public static void main(String[] args) {
        int col = 50;
        int row = 5;
     
   int [][] numbers = new int [col][row];
 
for (int i = 0; i < col; i++) {
    for (int j = 0; j < row ; j++){
     Random rGen = new Random();
      numbers [row][col] = rGen.nextInt(100) + 10;
      numbers [i][j] = col + row + (row * i);
    
        
            }
        }
        }
			
				
}
    
