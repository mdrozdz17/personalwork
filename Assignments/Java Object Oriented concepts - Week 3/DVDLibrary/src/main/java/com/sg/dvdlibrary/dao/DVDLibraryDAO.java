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
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class DVDLibraryDAO {

    public static final String DVD_FILE = "dvd.txt";
    public static final String DELIMITER = "::";
    private int dvdID = 1;
    private ConsoleIO con = new ConsoleIO();

    private HashMap<Integer, DVD> dvdMap = new HashMap();

    public void decode() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
        String[] currentTokens;
        while (sc.hasNextLine()) {
            //con.print(sc.nextLine());
            String currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            DVD currentDVD = new DVD();

            currentDVD.setDvdId(Integer.parseInt((currentTokens[0])));
            currentDVD.setTitle(currentTokens[1]);
            currentDVD.setReleaseDate(Integer.parseInt((currentTokens[2])));
            currentDVD.setMpaaRating(currentTokens[3]);
            currentDVD.setDirectorsName(currentTokens[4]);
            currentDVD.setStudio(currentTokens[5]);
            currentDVD.setUserRating(currentTokens[6]);

            dvdMap.put(Integer.parseInt((currentTokens[0])), currentDVD);
        }

    }

    public void encode() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(DVD_FILE));
        Set<Integer> keySet = dvdMap.keySet();
        for (Integer i : keySet) {

            out.print((dvdMap.get(i)).getDvdId());
            out.print(DELIMITER);

            out.print((dvdMap.get(i)).getTitle());
            out.print(DELIMITER);

            out.print((dvdMap.get(i)).getReleaseDate());
            out.print(DELIMITER);

            out.print((dvdMap.get(i)).getMpaaRating());
            out.print(DELIMITER);

            out.print((dvdMap.get(i)).getDirectorsName());
            out.print(DELIMITER);

            out.print((dvdMap.get(i)).getStudio());
            out.print(DELIMITER);

            out.print((dvdMap.get(i)).getUserRating());
            out.println("");

        }
        out.flush();
        out.close();
    }

    public Integer[] getDvdIdList() {
        Set<Integer> keySet = dvdMap.keySet();
        Integer[] keyArray = new Integer[keySet.size()];
        keyArray = keySet.toArray(keyArray);
        return keyArray;
    }

    public DVD getDvd(Integer dvdId) {
        return dvdMap.get(dvdId);
    }

    public DVD removeDvd(Integer dvdId) {
        return dvdMap.remove(dvdId);

    }

    public int getDvdCount() {
        return dvdMap.size();

    }

    public DVD addDvd(Integer dvdId, DVD dvd) {
        return dvdMap.put(dvdId, dvd);
    }

    public DVD findByTitle(String title) {
        Set<Integer> keySet = dvdMap.keySet();
        // create an instance of DVD to return it
        DVD tempDvd = new DVD();
        for (Integer i : keySet) {

            if ((dvdMap.get(i)).getTitle().equals(title)) {
                // if ((dvdMap.get(i)).getTitle().matches(",*[a-z].*")); {

                //set tempDvd to dvdMap to be able to return it
                tempDvd = dvdMap.get(i);
                con.print("ID: " + i);
                con.print("Title: " + (dvdMap.get(i)).getTitle());
                con.print("Release Date: " + (dvdMap.get(i)).getReleaseDate());
                con.print("MPAA Rating: " + (dvdMap.get(i)).getMpaaRating());
                con.print("Studio: " + (dvdMap.get(i)).getStudio());
                con.print("Directors Name: " + (dvdMap.get(i)).getDirectorsName());
                con.print("User Rating: " + (dvdMap.get(i)).getUserRating());

            }

        }
        // return tempDvd from instance of DVD
        return tempDvd;

    }

    public DVD update(Integer dvdId, DVD dvd) {
        return dvdMap.put(dvdId, dvd);
    }

    public void getDvdByRating(String rating) {
        dvdMap
                .values()
                .stream()
                .filter(r -> r.getMpaaRating().equalsIgnoreCase(rating))
                .forEach((DVD d) -> {
                    con.print(d.getDvdId()+ " " );
                    con.print(d.getTitle() + " " );
                    con.print(d.getReleaseDate() + " ");
                    con.print(d.getDirectorsName() + " ");
                    con.print(d.getStudio() + " ");
                    con.print(d.getUserRating() + " ");
                    con.print("=====================================");

                });

    }

    public void getDirector(String director) {
       dvdMap
                .values()
                .stream()
                .filter(d -> d.getDirectorsName().equalsIgnoreCase(director))
                .forEach((DVD d) -> {
                    con.print(d.getDvdId()+ " " );
                    con.print(d.getTitle() + " " );
                    con.print(d.getReleaseDate() + " ");
                    con.print(d.getMpaaRating() + " ");
                    con.print(d.getStudio() + " ");
                    con.print(d.getUserRating() + " ");
                    con.print("=====================================");

                });
    }

    public void getStudio(String studio) {
        dvdMap
                .values()
                .stream()
                .filter(s -> s.getStudio().equalsIgnoreCase(studio))
                .forEach((DVD d) -> {
                    con.print(d.getDvdId()+ " " );
                    con.print(d.getTitle() + " " );
                    con.print(d.getReleaseDate() + " ");
                    con.print(d.getMpaaRating() + " ");
                    con.print(d.getDirectorsName() + " ");
                    con.print(d.getUserRating() + " ");
                    con.print("=====================================");

                });
    }
}
