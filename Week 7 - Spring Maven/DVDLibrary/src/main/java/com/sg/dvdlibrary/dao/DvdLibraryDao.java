/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.model.DVD;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface DvdLibraryDao {
    
    // C - Create
    public DVD addDVD(DVD dvd);
    // R - Read - get one object (ID)
    public DVD getDVDById(int dvdId);
    // R - Read - get by name
    public List<DVD> getAllDVDSByName(String searchByName);
    // R - Read - get all objects (All DVDs)
    public List<DVD> getAllDVDS();
    // U - Update
    public void updateDVD(DVD dvd);
    // D - Delete
    public void removeDVD(int dvdId);
    
   public void decode() throws FileNotFoundException;
   
   public void encode() throws IOException;
   
   
    
    // Search will allow us ot search by any field
    // Our map may look something like this
    // Title = 
    // Release Date =
    // Mpaa Rating = 
    // Directors Name 
    // Studio
    // User Rating
    public List<DVD> searchDVD(Map<SearchTerm,String> criteria);
    
}



