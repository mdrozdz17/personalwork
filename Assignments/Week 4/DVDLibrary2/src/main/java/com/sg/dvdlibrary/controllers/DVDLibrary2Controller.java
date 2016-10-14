/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controllers;

import com.sg.dvdlibrary.ui.ConsoleIO;
import com.sg.dvdlibrary.models.DVD;
import com.sg.dvdlibrary.dao.DvdLibraryImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class DVDLibrary2Controller {

    private HashMap<Integer, DVD> dvdMap = new HashMap<Integer, DVD>();

    private DvdLibraryImpl myDvd = new DvdLibraryImpl();
    private ConsoleIO con = new ConsoleIO();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            myDvd.decode();
            while (keepGoing) {
                printMenu();
                menuSelection = con.readInt("Please select from the above choices.", 1, 8);

                switch (menuSelection) {
                    case 1:
                        con.print("Add a DVD to the collection");
                        addDVD();
                        break;
                    case 2:
                        con.print("Delete a DVD from the collection");
                        removeDVD();
                        break;
                    case 3:
                        con.print("List all the DVD's in the collection");
                        dvdTitleList();
                        break;
                    case 4:
                        con.print("Display the Information about a DVD");
                        dvdInformation();
                        break;
                    case 5:
                        con.print("Search for DVD by Title");
                        dvdByTitle();
                        break;
                    case 6:
                        con.print("Edit DVD Information");
                        editDvd();
                        break;
                    case 7:
                        con.print("Find DVD by field");
                        findAddressByField();
                        break;
                    case 8:
                        con.print("Exit DVD Library");
                        keepGoing = false;
                        break;
                    default:
                        con.print("Unknown Command");

                }

            }

            con.print("Thanks for using my DVD Collection");
            myDvd.encode();
        } catch (FileNotFoundException ex) {
            con.print("Error loading DVD Collection.");
        } catch (IOException ex) {
            con.print("Error writing to file");

        }
    }

    private void printMenu() {
        con.print("===================Main Menu===========================");
        con.print("1. Add a DVD to the collection");
        con.print("2. Delete a DVD from the collection");
        con.print("3. List all the DVD's in the collection");
        con.print("4. Display the Information about a DVD");
        con.print("5. Search for DVD by Title");
        con.print("6. Edit DVD Information");
        con.print("7. Find DVD by Field");
        con.print("8. Exit");

    }

    private void removeDVD() {
        boolean keepGoing = true;
        while (keepGoing) {
            int dvdId = con.readInt("Please enter the DVD ID you would like removed");
            myDvd.removeDvd(dvdId);
            con.readString("Dvd successfully removed from collection.  Please hit enter to continue.");

            int i = con.readInt("Would you like to remove another DVD? Please type" + " 1 " + " for yes or " + " 2 " + " for no ");

            if (i == 2) {
                keepGoing = false;
            }
        }
    }

    private void dvdTitleList() {
        Integer[] dvdIds = myDvd.getDvdIdList();
        for (Integer dvdId : dvdIds) {
            DVD currentDvd = myDvd.getDvd(dvdId);

            con.print(dvdId + "." + " " + currentDvd.getTitle());
        }
        con.readString("Please hit enter to continue.");
    }

    private void dvdInformation() {
        Integer[] title = myDvd.getDvdIdList();
        for (Integer titles : title) {
            DVD currentDvd = myDvd.getDvd(titles);
            con.print(titles + " " + currentDvd.getTitle() + " " + currentDvd.getReleaseDate()
                    + " " + currentDvd.getMpaaRating() + " " + currentDvd.getDirectorsName() + " "
                    + currentDvd.getStudio() + " " + currentDvd.getUserRating());

        }
    }

    private void dvdByTitle() {
        String title = con.readString("Please enter the Title of the DVD you would like to find");
        myDvd.findByTitle(title);
        // if (title.contains(",*[a-z].*"));
//        con.print(myDvd.getDvd();
    }

    private void dvdCount() {
        int number = myDvd.getDvdCount();
        con.print("The number of DVD's are: " + number);

    }

    private void addDVD() {
        boolean keepGoing = true;
        while (keepGoing) {
            Integer dvdId = con.readInt("Please enter the DVD ID.");
            String title = con.readString("Please enter the Title of the DVD you would like to add.");
            Integer releaseDate = con.readInt("Please enter the Release Date of the DVD.");
            String mpaaRating = con.readString("Please enter the MPAA Rating of the DVD.");
            String directorsName = con.readString("Please enter the Directors Name of the DVD.");
            String studio = con.readString("Please enter the Studio where the movie was recorded.");
            String userRating = con.readString("Please enter some comments about the DVD.");
            DVD currentDvd = new DVD();
            currentDvd.setDvdId(dvdId);
            currentDvd.setTitle(title);
            currentDvd.setReleaseDate(releaseDate);
            currentDvd.setMpaaRating(mpaaRating);
            currentDvd.setDirectorsName(directorsName);
            currentDvd.setStudio(studio);
            currentDvd.setUserRating(userRating);

            myDvd.addDvd(dvdId, currentDvd);

            con.readString("DVD successfully added to collection.  Please hit enter to continue.");

            int i = con.readInt("Would you like to add another DVD? Please type" + " 1 " + " for yes or " + " 2 " + " for no ");

            if (i == 2) {
                keepGoing = false;
            }
        }
    }

    private void findAddressByField() { // This works
        int menuSelection = 0;

        printSearchMenu();
        menuSelection = con.readInt("Please select from the above choices.", 1, 8);

        switch (menuSelection) {

            case 1:
                String rating = con.readString("Please enter the MPAA Rating you would like to search for");
                myDvd.getDvdByRating(rating);
                break;
            case 2:
                String director = con.readString("Please enter the Director name you would like to search for");
                myDvd.getDirector(director);
                break;
            case 3:
                String studio = con.readString("Please enter the Studio you would like to search for");
                myDvd.getStudio(studio);
                break;
            case 4:
                int year = con.readInt("Enter year");
                printByGivenYear(year);
                break;
            case 5:
                printAverageAge();
                break;
            case 6:
                printNewestMovies();
                break;
            case 7:
                printOldestMovies();
                break;
            case 8:
                printAverageUserRating();
                break;
            default:
                con.print("Unknown Command");

        }
    }

    private void dvdByRating() {
        String rating = con.readString("Please enter the MPAA-Rating you would like to search for");
        myDvd.getDvdByRating(rating);

    }

    private void dvdByDirector() {
        String director = con.readString("Please enter the Director's name would like to search for");
        myDvd.getDirector(director);
    }

    private void dvdByStudio() {
        String studio = con.readString("Please enter the Studio you would like to search for");
        myDvd.getStudio(studio);
    }

    void printAverageUserRating() {

        double average = myDvd.returnAverageUserRating();

        con.readString("The average amount of notes associated with a movie is " + average + "\n");

    }

    public void printByGivenYear(int year) {

        List<DVD> list = myDvd.searchByYear(year);

        list.stream()
        .forEach(d -> printDVDs(d));

    }

    void printOldestMovies() {

        int oldMovie = myDvd.returnOldestMovieYear();

        List<DVD> oldies = myDvd.returnOldestMovies(oldMovie);

        con.print("The Oldest Movie(s) in your collection is from " + oldMovie + "\n");

        oldies.stream().forEach(d -> con.readString(d.getTitle() + "\n"));

    }

    void printNewestMovies() {

        int newMovie = myDvd.returnNewestMovieYear();

        List<DVD> newbies = myDvd.returnNewestMovies(newMovie);

        con.print("The Newest Movie(s) in your collection is from " + newMovie + "\n");

        newbies.stream().forEach(d -> con.readString(d.getTitle() + "\n"));

    }

    void printAverageAge() {

        double average = myDvd.returnAvergageAge();

        average = 2016 - average;

        con.readString("The average age of a movie in your collection is " + average + " years old");
        con.readString("");

    }

    void printDVDs(DVD d) {

        con.print("\t ---------------------------------");
        con.print("\t Title:        " + d.getTitle());
        con.print("\t ---------------------------------");
        con.print("\t Director:     " + d.getDirectorsName());
        con.print("\t ---------------------------------");
        con.print("\t Release Date: " + Integer.toString(d.getReleaseDate()));
        con.print("\t ---------------------------------");
        con.print("\t MPAA Rating:  " + d.getMpaaRating());
        con.print("\t ---------------------------------");
        con.print("\t Studio Name:  " + d.getStudio());
        con.print("\t ---------------------------------");

    }

    private void editDvd() {
        int menuSelection = 0;
        String title = con.readString("Please enter the Title of the DVD you would like to edit");

        printEditMenu();
        menuSelection = con.readInt("Please select from the above choices.", 1, 6);

        DVD editDvd = myDvd.findByTitle(title);

        switch (menuSelection) {
            case 1:
                String newTitle = con.readString("Enter new Title");
                editDvd.setTitle(newTitle);
                break;
            case 2:
                Integer newReleaseDate = con.readInt("Enter new Release Date");
                editDvd.setReleaseDate(newReleaseDate);
                break;
            case 3:
                String newMpaaRating = con.readString("Enter new MPAA Rating");
                editDvd.setMpaaRating(newMpaaRating);
                break;
            case 4:
                String newDirectorsName = con.readString("Enter new Directors Name");
                editDvd.setDirectorsName(newDirectorsName);
                break;
            case 5:
                String newStudio = con.readString("Enter new Studio");
                editDvd.setStudio(newStudio);
                break;
            case 6:
                String newUserRating = con.readString("Enter User Rating");
                editDvd.setUserRating(newUserRating);
                break;
            default:
                con.print("Unknown Command");

                myDvd.update(editDvd.getDvdId(), editDvd);

        }

        con.print("Information Successfully Updated");

    }

    public void printEditMenu() {
        con.print("Please choose what attribute to edit");
        con.print("1. Title");
        con.print("2. Release Date");
        con.print("3. MPAA Rating");
        con.print("4. Director's Name.");
        con.print("5. Studio.");
        con.print("6. User Rating.");

    }

    private void printSearchMenu() {
        con.print("Please choose what field you would like to search by");
        con.print("1. MPAA-Rating");
        con.print("2. Director's Name");
        con.print("3. Studio");
        con.print("4. Movies in last N years");
        con.print("5. Print Average Age of Movies in DVD Library");
        con.print("6. Print Newest Movies in DVD Library");
        con.print("7. Print Oldest Movies in DVD Library");
        con.print("8. Print Average User Rating for Movies");

        

    }
}
