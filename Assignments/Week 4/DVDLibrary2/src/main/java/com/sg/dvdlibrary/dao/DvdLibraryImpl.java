/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.models.DVD;
import com.sg.dvdlibrary.ui.ConsoleIO;
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
public class DvdLibraryImpl implements DVDLibrary2DAO {

    public static final String DVD_FILE = "dvd.txt";
    public static final String DELIMITER = "::";
    private int dvdID = 1;
    private ConsoleIO con = new ConsoleIO();

    private HashMap<Integer, DVD> dvdMap = new HashMap();

    @Override
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

    @Override
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

    @Override
    public Integer[] getDvdIdList() {
        Set<Integer> keySet = dvdMap.keySet();
        Integer[] keyArray = new Integer[keySet.size()];
        keyArray = keySet.toArray(keyArray);
        return keyArray;
    }

    @Override
    public DVD getDvd(Integer dvdId) {
        return dvdMap.get(dvdId);
    }

    @Override
    public DVD removeDvd(Integer dvdId) {
        return dvdMap.remove(dvdId);

    }

    @Override
    public int getDvdCount() {
        return dvdMap.size();

    }

    @Override
    public DVD addDvd(Integer dvdId, DVD dvd) {
        return dvdMap.put(dvdId, dvd);
    }

    @Override
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

    @Override
    public DVD update(Integer dvdId, DVD dvd) {
        return dvdMap.put(dvdId, dvd);
    }

    @Override
    public void getDvdByRating(String rating) {
        dvdMap
                .values()
                .stream()
                .filter(r -> r.getMpaaRating().equalsIgnoreCase(rating))
                .forEach((DVD d) -> {
                    con.print(d.getDvdId() + " ");
                    con.print(d.getTitle() + " ");
                    con.print(d.getReleaseDate() + " ");
                    con.print(d.getDirectorsName() + " ");
                    con.print(d.getStudio() + " ");
                    con.print(d.getUserRating() + " ");
                    con.print("=====================================");

                });

    }

    @Override
    public void getDirector(String director) {
        dvdMap
                .values()
                .stream()
                .filter(d -> d.getDirectorsName().equalsIgnoreCase(director))
                .forEach((DVD d) -> {
                    con.print(d.getDvdId() + " ");
                    con.print(d.getTitle() + " ");
                    con.print(d.getReleaseDate() + " ");
                    con.print(d.getMpaaRating() + " ");
                    con.print(d.getStudio() + " ");
                    con.print(d.getUserRating() + " ");
                    con.print("=====================================");

                });
    }

    @Override
    public void getStudio(String studio) {
        dvdMap
                .values()
                .stream()
                .filter(s -> s.getStudio().equalsIgnoreCase(studio))
                .forEach((DVD d) -> {
                    con.print(d.getDvdId() + " ");
                    con.print(d.getTitle() + " ");
                    con.print(d.getReleaseDate() + " ");
                    con.print(d.getMpaaRating() + " ");
                    con.print(d.getDirectorsName() + " ");
                    con.print(d.getUserRating() + " ");
                    con.print("=====================================");

                });
    }

    @Override
    public List<DVD> searchByYear(int date) {

        return dvdMap
                .values()
                .stream()
                .filter(d -> d.getReleaseDate() >= date)
                .collect(
                        Collectors.toList());

    }

    @Override
    public double returnAverageUserRating() {

        OptionalDouble averageNotes = dvdMap
                .values()
                .stream()
                .mapToDouble(d -> d.getUserRating().length())
                .average();

        return averageNotes.getAsDouble();

    }

    @Override
    public double returnAvergageAge() {

        OptionalDouble averageAge = dvdMap
                .values()
                .stream()
                .mapToDouble(d -> d.getReleaseDate())
                .average();

        return averageAge.getAsDouble();
    }

    @Override
    public int returnNewestMovieYear() {

        OptionalInt newMovie = dvdMap
                .values()
                .stream()
                .mapToInt(d -> d.getReleaseDate())
                .max();

        return newMovie.getAsInt();

    }

    @Override
    public int returnOldestMovieYear() {

        OptionalInt oldestMovie = dvdMap
                .values()
                .stream()
                .mapToInt(d -> d.getReleaseDate())
                .min();

        return oldestMovie.getAsInt();

    }

    @Override
    public List<DVD> returnNewestMovies(int year) {

        return dvdMap
                .values()
                .stream()
                .filter(d -> d.getReleaseDate() == year)
                .collect(
                        Collectors.toList());

    }

    @Override
    public List<DVD> returnOldestMovies(int year) {

        return dvdMap
                .values()
                .stream()
                .filter(d -> d.getReleaseDate() == year)
                .collect(
                        Collectors.toList());

    }

}
