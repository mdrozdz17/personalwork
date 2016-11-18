/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.model.Address;
import com.sg.addressbook.model.StateContactCount;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class AddressBookDaoDbImpl implements AddressBookDao {
    // #1 - All SQL code is in the form of Prepared Statements

    private static final String SQL_INSERT_CONTACT
            = "insert into contacts (first_name, last_name, street, city, state, zip) values (?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_CONTACT
            = "delete from contacts where address_id = ?";
    private static final String SQL_SELECT_CONTACT
            = "select * from contacts where address_id = ?";
    private static final String SQL_UPDATE_CONTACT
            = "update contacts set first_name = ?, last_name = ?, street = ?, city = ?, state = ?, zip = ? where address_id = ?";
    private static final String SQL_SELECT_ALL_CONTACTS
            = "select * from contacts";
    private static final String SQL_SELECT_CONTACTS_BY_LAST_NAME
            = "select * from contacts where last_name = ?";
    private static final String SQL_SELECT_CONTACTS_BY_STATE
            = "select * from contacts where state = ?";
    // Stats query
    private static final String SQL_SELECT_STATE_CONTACT_COUNTS
            = "SELECT state, count(*) as num_contacts FROM contacts GROUP BY state;";
      // Seach query
      private static final String SQL_SEARCH_CONTACT
            = "Select * from address where first_name like ? "
            + "AND last_name like ? "
            + "AND street like ? "
            + "AND city  like  ? "
            + "AND state like  ? "
            + "AND zip like  ? ";  

    // #2a - Declare JdbcTemplate reference - the instance will be handed to us by Spring
    private JdbcTemplate jdbcTemplate;
    // #2b - We are using Setter Injection to direct Spring to hand us an instance of
    // the JdbcTemplate (see the Spring Configuration section below for configuration
    // details).

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    // #3 - Wrap addContact in a transaction so the we are guaranteed to get the
    // correct LAST_INSERT_ID for our row.
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Address addAddress(Address address) {
        jdbcTemplate.update(SQL_INSERT_CONTACT,
                address.getFirstName(),
                address.getLastName(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZip());
        address.setAddressId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class));
        return address;
    }

    @Override
    public void removeAddress(int addressId) {
        jdbcTemplate.update(SQL_DELETE_CONTACT, addressId);
    }

    @Override
    public List<Address> getAllAddressesByName(String nameToSearch) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Address> searchAddress(Map<SearchTerm, String> criteria) {
          return jdbcTemplate.query(SQL_SEARCH_CONTACT, new ContactMapper(),
               // + "%" so you don't have to type full name when searching.
             criteria.get(SearchTerm.FIRST_NAME) ==  null ? "%" :  criteria.get(SearchTerm.FIRST_NAME) + "%",
             criteria.get(SearchTerm.LAST_NAME) == null ? "%" : criteria.get(SearchTerm.LAST_NAME)+ "%",
             criteria.get(SearchTerm.STREET) == null ? "%" : criteria.get(SearchTerm.STREET)+ "%",
             criteria.get(SearchTerm.CITY) == null ? "%" : criteria.get(SearchTerm.CITY)+ "%",
             criteria.get(SearchTerm.STATE) == null ? "%" : criteria.get(SearchTerm.STATE)+ "%",
             criteria.get(SearchTerm.ZIP) == null ? "%" : criteria.get(SearchTerm.ZIP)+ "%");
    }

    @Override
    public List<StateContactCount> getStateContactCounts() {
        return jdbcTemplate.query(SQL_SELECT_STATE_CONTACT_COUNTS, new StateContactCountMapper());
    }

    @Override
    public void updateAddress(Address address) {
        jdbcTemplate.update(SQL_UPDATE_CONTACT,
                address.getFirstName(),
                address.getLastName(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZip(),
                address.getAddressId());
    }

    @Override
    // #4 - getAllContacts, getContactById, searchContactsByLastName, and
    // searchContactsByCompany require us to pass in mapper
    // class to map the rows from the database into Contact objects
    public List<Address> getAllAddresses() {
        return jdbcTemplate.query(SQL_SELECT_ALL_CONTACTS, new ContactMapper());
    }

    @Override
    public Address getAddressById(int addressId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_CONTACT,
                    new ContactMapper(), addressId);
        } catch (EmptyResultDataAccessException ex) {
            // there were no results for the given contact id - we just want to
            // return null in this case
            return null;
        }
    }


    /*
    @Override
    public List<Contact> searchContactsByLastName(String lastName) {
        return jdbcTemplate.query(SQL_SELECT_CONTACTS_BY_LAST_NAME, new ContactMapper());
    }

    @Override
    public List<Contact> searchContactsByCompany(String company) {
        return jdbcTemplate.query(SQL_SELECT_CONTACTS_BY_COMPANY, new ContactMapper());
    }
    // #5 - This class maps the columns in the 'contacts’ table into properties on the
    // Contact object
     */

    private static final class ContactMapper implements RowMapper<Address> {

        @Override
        public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
            Address address = new Address();
            address.setAddressId(rs.getInt("address_id"));
            address.setFirstName(rs.getString("first_name"));
            address.setLastName(rs.getString("last_name"));
            address.setStreet(rs.getString("street"));
            address.setCity(rs.getString("city"));
            address.setState(rs.getString("state"));
            address.setZip(rs.getString("zip"));

            return address;
        }
    }

    /* Row Mappers - used for mapping database results to Java objects */
    private static final class StateContactCountMapper implements RowMapper<StateContactCount> {

        @Override
        public StateContactCount mapRow(ResultSet rs, int i) throws SQLException {
            // creating a new instance of the Java object that I want to map to
            StateContactCount count = new StateContactCount();
            // Map a resulting field (column) to a Java object's property
            // We have a field in our results from our SQL query called company
            // We are taking the "company" field from SQL and storing it in the company property
            // of our CompanyContactCount object
            
            count.setState(rs.getString("state"));
            count.setNumContacts(rs.getInt("num_contacts"));
            return count;
        }
    }

}
