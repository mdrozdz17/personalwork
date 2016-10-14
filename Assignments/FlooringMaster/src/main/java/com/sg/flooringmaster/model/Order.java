/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.model;

/**
 *
 * @author apprentice
 */
public class Order {

    private String date;
    private Integer id;
    private String customerName;
    private String stateName;
    private Double stateTaxes;
    private String productType;
    private Double materialCost;
    private Double laborCost;
    private Double area;
    private Double materialTotal;
    private Double laborTotal;
    private Double tax;
    private Double totalCost;
    
    
    
    public Order() { // Put default constructor first if going to use an overloaded Constructor
        
    }

    // Created overloaded constructor to use for testing
    public Order (int id, String customerName, String stateName, Double stateTaxes, 
            String productType, Double materialCost, Double laborCost, Double area, 
            Double materialTotal, Double laborTotal, Double tax, Double totalCost) {
       this.id = id;
       this.customerName = customerName;
       this.stateName = stateName;
       this.stateTaxes = stateTaxes;
       this.productType = productType;
       this.materialCost = materialCost;
       this.laborCost = laborCost;
       this.area = area;
       this.materialTotal = materialTotal;
       this.laborTotal=laborTotal;
       this.tax = tax;
       this.totalCost = totalCost;
       
       
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getStateTaxes() {
        return stateTaxes;
    }

    public void setStateTaxes(Double stateTaxes) {
        this.stateTaxes = stateTaxes;
    }

    public Double getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(Double materialCost) {
        this.materialCost = materialCost;
    }

    public Double getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(Double laborCost) {
        this.laborCost = laborCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Double getMaterialTotal() {
        return materialTotal;
    }

    public void setMaterialTotal(Double materialTotal) {
        this.materialTotal = materialTotal;
    }

    public Double getLaborTotal() {
        return laborTotal;
    }

    public void setLaborTotal(Double laborTotal) {
        this.laborTotal = laborTotal;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

}
