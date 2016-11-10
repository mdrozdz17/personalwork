/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

/**
 *
 * @author apprentice
 */
public enum Rating {
    G ("G"),
    PG ("PG"),
    PG13 ("PG-13"),
    R ("R"),
    NC17 ("NC-17"),
    NR ("NR");
    
    private final String name;
    
    private Rating(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }
}
