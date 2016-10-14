package com.sg.flooringmastery.models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author apprentice
 */
public class Order {

    private Integer orderNumber;
    private String customerName;
    private String state;
    private double taxRate;
    private String productType;
    private double area;
    private double materialCostPerSqFt;
    private double laborCostPerSqFt;
    private double materialCost;
    private double laborCost;
    private double tax;
    private double totalCost;
    private String date;

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getMaterialCostPerSqFt() {
        return materialCostPerSqFt;
    }

    public void setMaterialCostPerSqFt(double materialCostPerSqFt) {
        this.materialCostPerSqFt = materialCostPerSqFt;
    }

    public double getLaborCostPerSqFt() {
        return laborCostPerSqFt;
    }

    public void setLaborCostPerSqFt(double laborCostPerSqFt) {
        this.laborCostPerSqFt = laborCostPerSqFt;
    }

    public double getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(double materialCost) {
        this.materialCost = materialCost;
    }

    public double getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Order Number: " + orderNumber + "\nCustomer Name: " + customerName + "\nState: " + state
                + "\nTax Rate: " + taxRate + "\nProduct Type: " + productType
                + "\nArea: " + area + "\nMaterial Cost Per Square Foot: " + materialCostPerSqFt
                + "\nLabor Cost Per Square Foot: " + laborCostPerSqFt + "\nMaterial Cost: "
                + materialCost + "\nLabor Cost: " + laborCost + "\nTax: "
                + tax + "\nTotal Cost: " + totalCost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

  
}
