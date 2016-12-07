/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.model.Item;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class VendingMachineDbImpl implements VendingMachineDao {
     private static final String SQL_INSERT_ITEM
            = "insert into item (name, cost, NumInInventory) values (?, ?, ?)";
    private static final String SQL_DELETE_ITEM
            = "delete from item where itemId = ?";
    private static final String SQL_SELECT_ITEM
            = "select * from item where itemId = ?";
    private static final String SQL_UPDATE_ITEM
            = "update item set name= ?, cost = ?, NumInInventory = ? where itemId = ?";
    private static final String SQL_SELECT_ALL_ITEMS
            = "select * from item";
     private static final String SQL_SELECT_DVD_BY_NAME
            = "select * from item where name = ?";
    
    private JdbcTemplate jdbcTemplate;
    // #2b - We are using Setter Injection to direct Spring to hand us an instance of
    // the JdbcTemplate (see the Spring Configuration section below for configuration
    // details).
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Item addItem(Item item) {
             jdbcTemplate.update(SQL_INSERT_ITEM,
                item.getName(),
                item.getCost(),
                item.getNumInInventory());
        item.setId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return item;
    }

    @Override
    public Item getItemById(int itemId) {
              try {
        return jdbcTemplate.queryForObject(SQL_SELECT_ITEM, new ItemMapper(), itemId);
        } catch (EmptyResultDataAccessException ex) {
           // there were no results for the given item id - we just want to
            // return null in this case
            return null;
        }
    }


    @Override
    public List<Item> getAllItemsByName(String searchByName) {
        return jdbcTemplate.query(SQL_SELECT_DVD_BY_NAME, new ItemMapper());
    }

    @Override
    public List<Item> getAllItems() {
     return jdbcTemplate.query(SQL_SELECT_ALL_ITEMS, new ItemMapper());

        
    }

    @Override
    public void updateItem(Item item) {
         jdbcTemplate.update(SQL_UPDATE_ITEM,
                item.getName(),
                item.getCost(),
                item.getNumInInventory(),
                 item.getItemId());
                
    }
    

    @Override
    public void removeItem(int itemId) {
         jdbcTemplate.update(SQL_DELETE_ITEM, itemId);
    }
    
    private static final class ItemMapper implements RowMapper<Item> {

        @Override
        public Item mapRow(ResultSet rs, int i) throws SQLException {
            Item item = new Item();
            item.setId(rs.getInt("itemId"));
            item.setName(rs.getString("name"));
            item.setCost(rs.getDouble("cost"));
            item.setNumInInventory(rs.getInt("NumInInventory"));
            return item;
            
        }
        
    }
    
}
