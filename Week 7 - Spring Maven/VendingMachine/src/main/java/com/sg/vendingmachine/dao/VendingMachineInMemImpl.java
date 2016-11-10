/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.model.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class VendingMachineInMemImpl implements VendingMachineDao {
    
    private Map<Integer, Item> itemMap = new HashMap<>();
    
    private static int itemIdCounter = 0;
    

    @Override
    public Item addItem(Item item) {
        item.setId(itemIdCounter);
        itemIdCounter++;
        itemMap.put(item.getItemId(), item);
        return item;
    }

    @Override
    public Item getItemById(int itemId) {
        return itemMap.get(itemId);
    }

    @Override
    public List<Item> getAllItemsByName(String searchByName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> allItems = new ArrayList<>(itemMap.values());
        return allItems;
    }

    @Override
    public void updateItem(Item item) {
        itemMap.put(item.getItemId(), item);
    }

    @Override
    public void removeItem(int itemId) {
        itemMap.remove(itemId);
    }
}
