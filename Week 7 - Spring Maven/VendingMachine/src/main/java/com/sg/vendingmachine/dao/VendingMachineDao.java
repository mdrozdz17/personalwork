/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.model.Item;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface VendingMachineDao {

     public Item addItem(Item item);
    // R - Read - get one object (ID)
    public Item getItemById(int itemId);
    // R - Read - get by name
    public List<Item> getAllItemsByName(String searchByName);
    // R - Read - get all objects (All Contacts)
    public List<Item> getAllItems();
    // U - Update
    public void updateItem(Item item);
    // D - Delete
    public void removeItem(int itemId);
}

