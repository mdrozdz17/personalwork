/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.ui.ConsoleIO;
import com.sg.dvdlibrary.models.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public interface DVDLibrary2DAO {
    
    public void decode() throws FileNotFoundException;
    public void encode() throws IOException;
    public Integer[] getDvdIdList();
    public DVD getDvd(Integer dvdId);
    public DVD removeDvd(Integer dvdId);
    public int getDvdCount();
    public DVD addDvd(Integer dvdId, DVD dvd);
    public DVD findByTitle(String title);
    public DVD update(Integer dvdId, DVD dvd);
    public void getDvdByRating(String rating);
    public void getDirector(String director);
    public void getStudio(String studio);
    public List<DVD> searchByYear(int date);
    public double returnAverageUserRating();
    public double returnAvergageAge();
    public int returnNewestMovieYear();
    public int returnOldestMovieYear();
    public List<DVD> returnNewestMovies(int year);
    public List<DVD> returnOldestMovies(int year);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


        }
    

