/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.dao;

import com.sg.flooringmaster.model.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ProductDao {

    private static final String FILENAME = "product.txt";
    private static final String DELIMITER = "::";
    private List<Product> products = new ArrayList<>();
    private Integer nextId = 1;

    public ProductDao() {
        products = loadProductData();

    }

    // @Override
    public Product addProduct(Product product) {

        product.setId(nextId);

        products.add(product);

        nextId++;

        saveProductData();

        return product;
    }

    //@Override
    public Product readProductId(Integer id) {

        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    // @Override
    public void editProduct(Product product) {

     //   for (Product pd : products) {
      //      if (pd.getId().equals(product.getId())) {
        //        products.remove(pd);
        //        products.add(product);
         //      break;
          //  }
       // }
      //  saveProductData();
   // }
    
         ListIterator litr = products.listIterator();
        while (litr.hasNext()) {

            Product p = (Product) litr.next(); //litr.next returns the next element in the list

            if (p.getId() == product.getId()) {

                litr.set(product); //.set replaces last element return by litr.next

            }
        }
        saveProductData();
    }

    //@Override
    public void removeProduct(Product product) {

        for (Product pd : products) {
            if (pd.getId().equals(product.getId())) {
                products.remove(pd);
                break;
            }
        }

        saveProductData();
    }

    //@Override
    public List<Product> readAll() {

        return new ArrayList(products);
    }

    public void saveProductData() {

        try {
            PrintWriter out = new PrintWriter(new FileWriter(FILENAME));

            for (Product product : products) {

                out.print(product.getId());
                out.print(DELIMITER);

                out.print(product.getProductType());
                out.print(DELIMITER);

                out.print(product.getCost());
                out.print(DELIMITER);

                out.print(product.getLaborCost());
                out.println("");

            }

            out.flush();
            out.close();

        } catch (IOException ex) {

        }
    }

    public List<Product> loadProductData() {

        List<Product> tempProduct = new ArrayList();

        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(FILENAME)));
            String[] currentTokens;
            while (sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                currentTokens = currentLine.split(DELIMITER);

                Product currentProduct = new Product();

                currentProduct.setId(Integer.parseInt(currentTokens[0]));
                currentProduct.setProductType(currentTokens[1]);
                currentProduct.setCost(Double.parseDouble(currentTokens[2]));
                currentProduct.setLaborCost(Double.parseDouble(currentTokens[3]));

                tempProduct.add(currentProduct);

            }
        } catch (FileNotFoundException ex) {

        }
        return tempProduct;
    }
}
