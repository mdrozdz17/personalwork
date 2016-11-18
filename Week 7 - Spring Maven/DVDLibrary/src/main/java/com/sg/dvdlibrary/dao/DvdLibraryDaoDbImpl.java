/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.model.DVD;
import com.sg.dvdlibrary.model.DVDTitleCount;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class DvdLibraryDaoDbImpl implements DvdLibraryDao {
    //#1 All SQL code in the form of Prepared Statments
    
    // Used for adding
    private static final String SQL_INSERT_DVD
            = "insert into dvds (title, releaseDate, mpaaRating, directorsName, studio, userRating) values (?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_DVD
            = "delete from dvds where dvdId = ?";
    // Get DVD By ID
    private static final String SQL_SELECT_DVD
            = "select * from dvds where dvdId = ?";
    // Update specfic DVD Field
    private static final String SQL_UPDATE_DVD
            = "update dvds set title= ?, releaseDate = ?, mpaaRating = ?, directorsName = ?, studio = ?, userRating = ? where dvdId = ?";
    private static final String SQL_SELECT_ALL_DVD
            = "select * from dvds";
    private static final String SQL_SELECT_DVD_BY_TITLE
            = "select * from dvds where title = ?";
    private static final String SQL_SELECT_DVD_BY_MPAARATING
            = "select * from dvds where mpaaRating = ?";
    // Stats query
    private static final String SQL_SELECT_DVD_TITLE_COUNTS
            = "select dvds, count(*) as num_dvds from dvd group by mpaaRating";
    // Seach query
      private static final String SQL_SEARCH_DVDS
            = "Select * from dvds where title like ? "
            + "AND releaseDate like ? "
            + "AND mpaaRating like ? "
            + "AND directorsName  like  ? "
            + "AND studio like  ? "
            + "AND userRating like  ? ";         
    
     // #2a - Declare JdbcTemplate reference - the instance will be handed to us by Spring
    private JdbcTemplate jdbcTemplate;
    // #2b - We are using Setter Injection to direct Spring to hand us an instance of
    // the JdbcTemplate (see the Spring Configuration section below for configuration
    // details).
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }
    

    @Override
    // #3 - Wrap addDVD in a transaction so the we are guaranteed to get the
    // correct LAST_INSERT_ID for our row.
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public DVD addDVD(DVD dvd) {
        jdbcTemplate.update(SQL_INSERT_DVD,
                dvd.getTitle(),
                dvd.getReleaseDate(),
                dvd.getMpaaRating(),
                dvd.getDirectorsName(),
                dvd.getStudio(),
                dvd.getUserRating());
        dvd.setDvdId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return dvd;
    }

    @Override
    //DVDMapper defined below that implements RowMapper
    public DVD getDVDById(int dvdId) {
        try {
        return jdbcTemplate.queryForObject(SQL_SELECT_DVD, new DVDMapper(), dvdId);
        } catch (EmptyResultDataAccessException ex) {
           // there were no results for the given dvd id - we just want to
            // return null in this case
            return null;
        }
    }

    @Override
    public List<DVD> getAllDVDSByTitle(String searchByName) {
        return jdbcTemplate.query(SQL_SELECT_DVD_BY_TITLE, new DVDMapper());
    }

    @Override
    public List<DVD> getAllDVDS() {
        return jdbcTemplate.query(SQL_SELECT_ALL_DVD, new DVDMapper());
    }

    @Override
    public void updateDVD(DVD dvd) {
        jdbcTemplate.update(SQL_UPDATE_DVD,
                dvd.getTitle(),
                dvd.getReleaseDate(),
                dvd.getMpaaRating(),
                dvd.getDirectorsName(),
                dvd.getStudio(),
                dvd.getUserRating(),
                dvd.getDvdId());
                
    }

    @Override
    public void removeDVD(int dvdId) {
        jdbcTemplate.update(SQL_DELETE_DVD, dvdId);
    }
    
    @Override
    public List<DVDTitleCount> getDVDTitleCounts() {
        return jdbcTemplate.query(SQL_SELECT_DVD_TITLE_COUNTS, new DVDTitleCountMapper());
    }

    @Override
    public void decode() throws FileNotFoundException {
        // Not needed for Database
    }

    @Override
    public void encode() throws IOException {
        // Not needed for Database
    }

    @Override
    public List<DVD> searchDVD(Map<SearchTerm, String> criteria) {
       return jdbcTemplate.query(SQL_SEARCH_DVDS, new DVDMapper(),
               // + "%" so you don't have to type full name when searching.
             criteria.get(SearchTerm.TITLE) ==  null ? "%" :  criteria.get(SearchTerm.TITLE) + "%",
             criteria.get(SearchTerm.RELEASE_DATE) == null ? "%" : criteria.get(SearchTerm.RELEASE_DATE)+ "%",
             criteria.get(SearchTerm.MPAA_RATING) == null ? "%" : criteria.get(SearchTerm.MPAA_RATING)+ "%",
             criteria.get(SearchTerm.DIRECTORS_NAME) == null ? "%" : criteria.get(SearchTerm.DIRECTORS_NAME)+ "%",
             criteria.get(SearchTerm.STUDIO) == null ? "%" : criteria.get(SearchTerm.STUDIO)+ "%",
             criteria.get(SearchTerm.USER_RATING) == null ? "%" : criteria.get(SearchTerm.USER_RATING)+ "%");
       
    }
    
    
    private static final class DVDMapper implements RowMapper<DVD> {

        @Override
        public DVD mapRow(ResultSet rs, int i) throws SQLException {
            DVD dvd = new DVD();
            dvd.setDvdId(rs.getInt("dvdId"));
            dvd.setTitle(rs.getString("title"));
            dvd.setReleaseDate(rs.getString("releaseDate"));
            dvd.setMpaaRating(rs.getString("mpaaRating"));
            dvd.setDirectorsName(rs.getString("directorsName"));
            dvd.setStudio(rs.getString("studio"));
            dvd.setUserRating(rs.getString("userRating"));
            return dvd;
            
        }
        
    }
    
     /* Row Mappers - used for mapping database results to Java objects */
    // RowMapper<DVDTitleCount> - DVDTitleCount is a DTO
    private static final class DVDTitleCountMapper implements RowMapper<DVDTitleCount> {

        @Override
        public DVDTitleCount mapRow(ResultSet rs, int i) throws SQLException {
            // create a new instance of the Java Object that I want to map to
            DVDTitleCount count = new DVDTitleCount();
            // We have a field in our results from our SQL query called title
            // We are taking the "title" field from SQL and storing it in the title property
            // of our DVDTitleCount object
            
            count.setTitle(rs.getString("title"));
            count.setNumDVDS(rs.getInt("num_dvds"));
            return count;
        }
        
    }
    
}
