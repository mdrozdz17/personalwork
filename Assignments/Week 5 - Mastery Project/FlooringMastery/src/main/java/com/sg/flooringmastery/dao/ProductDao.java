/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.models.Product;
import com.sg.flooringmastery.models.Tax;
import com.sg.flooringmastery.ui.ConsoleIO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class ProductDao {
    
      private static final String PRODUCT_FILE = "product.txt";
    private static final String DELIMITER = "::";

    public static List<Product> listAllProducts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static List<Product> listProduct(String productType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private ConsoleIO con = new ConsoleIO();
    List<Product> product = new ArrayList<>();
   

    private void decode() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(PRODUCT_FILE)));
        String[] currentTokens;
        while (sc.hasNextLine()) {
            con.print(sc.nextLine());
            String currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Product currentProduct = new Product();
            
            currentProduct.setProductType((currentTokens[0]));
            currentProduct.setMaterialCostPerSqFt(Double.parseDouble(currentTokens[1]));
            currentProduct.setLaborCostPerSqFt(Double.parseDouble(currentTokens[2]));

            
            product.add(currentProduct);
        }

    }
    
    public List<Product> getProductType(String productType) {
        return product
        .stream()
        .filter(p -> p.getProductType().equals(productType))  
        .collect(Collectors.toList());
        
    }
    
}
