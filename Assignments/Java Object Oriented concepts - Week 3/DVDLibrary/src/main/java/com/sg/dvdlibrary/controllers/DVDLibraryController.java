/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controllers;

import com.sg.dvdlibrary.ui.ConsoleIO;
import com.sg.dvdlibrary.models.DVD;
import com.sg.dvdlibrary.dao.DVDLibraryDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class DVDLibraryController {

    private HashMap<Integer, DVD> dvdMap = new HashMap<Integer, DVD>();

    private DVDLibraryDAO myDvd = new DVDLibraryDAO();
    private ConsoleIO con = new ConsoleIO();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            //  myDvd.readAddress();
            while (keepGoing) {
                printMenu();
                menuSelection = con.readInt("Please select from the above choices.", 1, 7);

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
                        editMenu();
                        break;
                    case 7:
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
        con.print("7. Exit");

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

    private void editMenu() {
        int menuSelection = 0;
        String title = con.readString("Please enter the Title of the DVD you would like to edit");

        printEditMenu();
        menuSelection = con.readInt("Please select from the above choices.", 1, 6);

        switch (menuSelection) {
            case 1:
                con.print("Edit title of DVD");
                editTitle();
                break;
            case 2:
                con.print("Edit Release Date of DVD");
                editReleaseDate();
                break;
            case 3:
                con.print("Edit MPAA Rating of DVD");
                editMpaaRating();
                break;
            case 4:
                con.print("Edit Director's name of DVD");
                editDirectorsName();
                break;
            case 5:
                con.print("Edit Studio name of DVD");
                editStudioName();
                break;
            case 6:
                con.print("Edit User Rating of DVD");
                editUserRating();
                break;
            default:
                con.print("Unknown Command");

        }

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

    private void editTitle() {
        int dvdId = 0;

        String title = (dvdMap.get(dvdId)).getTitle();

        Set<Integer> keySet = dvdMap.keySet();

        for (Integer i : keySet) {

            if (i == dvdId) {

                int releaseDate = con.readInt("Please enter the new Release Date of the DVD.");
                String mpaaRating = con.readString("Please enter the new MPAA Rating of the DVD.");
                String directorsName = con.readString("Please enter the new Directors Name of the DVD.");
                String studio = con.readString("Please enter the new Studio of where the movie was recorded.");
                String userRating = con.readString("Please enter new comments about the DVD.");
                DVD newDvd = new DVD();
                newDvd.setTitle(title);
                newDvd.setReleaseDate(releaseDate);
                newDvd.setMpaaRating(mpaaRating);
                newDvd.setStudio(studio);
                newDvd.setUserRating(userRating);

                myDvd.editTitle(dvdId, newDvd);

                con.readString("DVD Title has successfully been updated");

            }
        }
    }

    private void editReleaseDate() {
        int dvdId = 0;
        int releaseDate = con.readInt("Please enter the new Release Date of the DVD.");
        DVD newDvd = new DVD();
        newDvd.setReleaseDate(releaseDate);

        myDvd.editReleaseDate(dvdId, newDvd);

        con.readString("DVD Release Date has successfully been updated");

    }

    private void editMpaaRating() {
        int dvdId = 0;
        String mpaaRating = con.readString("Please enter the new MPAA Rating of the DVD.");
        DVD newDvd = new DVD();
        newDvd.setMpaaRating(mpaaRating);

        myDvd.addDvd(dvdId, newDvd);

        con.readString("DVD MPAA Rating has successfully been updated");

    }

    private void editDirectorsName() {
        int dvdId = 0;
        String directorsName = con.readString("Please enter the new Directors Name of the DVD.");
        DVD newDvd = new DVD();
        newDvd.setDirectorsName(directorsName);

        myDvd.editDirectorsName(dvdId, newDvd);

        con.readString("DVD Title has successfully been updated");

    }

    private void editStudioName() {
        int dvdId = 0;
        String studio = con.readString("Please enter the new Studio of where the movie was recorded.");
        DVD newDvd = new DVD();
        newDvd.setStudio(studio);

        myDvd.editStudioName(dvdId, newDvd);

        con.readString("DVD Studio has successfully been updated");

    }

    private void editUserRating() {
        int dvdId = 0;
        String userRating = con.readString("Please enter new comments about the DVD.");
        DVD newDvd = new DVD();
        newDvd.setUserRating(userRating);

        myDvd.editUserRating(dvdId, newDvd);

        con.readString("DVD comments have been updated");

    }
}
