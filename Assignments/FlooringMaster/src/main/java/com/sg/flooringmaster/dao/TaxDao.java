/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.dao;

import com.sg.flooringmaster.model.Tax;
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
public class TaxDao {

    private static final String TAX_FILE = "tax.txt";
    private static final String DELIMITER = "::";
    private List<Tax> tax = new ArrayList<>();
    private Integer nextId = 1;

    public TaxDao() {
        tax = loadTaxData();

    }

    // @Override
    public Tax addTaxRate(Tax taxRate) {

        taxRate.setId(nextId);

        tax.add(taxRate);

        nextId++;

        saveTaxData();

        return taxRate;
    }

    //@Override
    public Tax readTaxId(Integer id) {

        for (Tax stateTax : tax) {
            if (stateTax.getId() == id) {
                return stateTax;
            }
        }
        return null;
    }

    // @Override
    public void editStateTax(Tax taxRate) {

        ListIterator litr = tax.listIterator();
        while (litr.hasNext()) {

            Tax t = (Tax) litr.next(); //litr.next returns the next element in the list

            if (t.getId() == taxRate.getId()) {

                litr.set(tax); //.set replaces last element return by litr.next

            }
        }
        saveTaxData();
    }

    //@Override
    public void removeStateTax(Tax taxRate) {

        for (Tax stateTax : tax) {
            if (stateTax.getId().equals(taxRate.getId())) {
                tax.remove(stateTax);
                break;
            }
        }

        saveTaxData();
    }

    //@Override
    public List<Tax> readAll() {

        return new ArrayList(tax);
    }

    public void saveTaxData() {

        try {
            PrintWriter out = new PrintWriter(new FileWriter(TAX_FILE));

            for (Tax stateTax : tax) {

                out.print(stateTax.getId());
                out.print(DELIMITER);

                out.print(stateTax.getStateName());
                out.print(DELIMITER);

                out.print(stateTax.getTaxRate());
                out.println("");
            }

            out.flush();
            out.close();

        } catch (IOException ex) {

        }
    }

    public List<Tax> loadTaxData() {

        List<Tax> tempTax = new ArrayList();

        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(TAX_FILE)));
            String[] currentTokens;
            while (sc.hasNextLine()) {
                String currentLine = sc.nextLine();

                currentTokens = currentLine.split(DELIMITER);

                Tax currentTax = new Tax();

                currentTax.setId(Integer.parseInt(currentTokens[0]));
                currentTax.setStateName(currentTokens[1]);
                currentTax.setTaxRate(Double.parseDouble(currentTokens[2]));

                tempTax.add(currentTax);
            }
        } catch (FileNotFoundException ex) {

        }
        return tempTax;
    }
}
