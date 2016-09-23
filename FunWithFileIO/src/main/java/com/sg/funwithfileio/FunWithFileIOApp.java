/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.funwithfileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
class FunWithFileIOApp {

    private final String OUTPUT_FILE = "DataFiles/OutFile.txt";
    private final String OUTPUT_FILE2 = "DataFiles/Apprentices.txt";


    public void run() {
        // Creating a file
        createMySampleFile();
        // Reading from that file
        readMySampleFile();

        // Data encoding/ decoding
        // Try writing the object to the file\
        // Writing OBJECTS to a file and reading them from a file
        Student s1 = new Student("Sarah",42);
        Student s2 = new Student("Victor",17);
        writeStudentToFile(s1);
        writeStudentToFile(s2);
        readStudentsFromFile();

    }

    private void createMySampleFile() {
        // We have to either try...or catch or throws
        // IOException is  subject to Catch or Specify
        // The IOException is tied to the FileWrite object
        try {
            // PrintWriter may buffer some of our output - so it
            // doesen't immediately write out to the file
            // PrintWriter can store some of it's inputs into memory
            // We will take care of this with flush()
            PrintWriter outPrinter = new PrintWriter(new FileWriter(OUTPUT_FILE));
            outPrinter.println("I've got everything I need right in front of me");
            outPrinter.println("Life's a happy song");
            outPrinter.println("It's Friday");
            // flush forces everything to be written to the file
            // This clears the PrintWriter's buffer
            outPrinter.flush();
            // Close the underlying stream that attaches the PrintWriter to FileWriter
            // the PrintWriter to FileWriter
            // This will free up the file for use to others
            // This allows for proper allocation and deallocation of memory
            // (Proper memory management)
            outPrinter.close();
        } catch (FileNotFoundException fnf) {
            // Tell the user we can't find a file and include the file
            System.out.println("We canot find the file " + OUTPUT_FILE);
            // Include the specific error message for our own sanity
            System.out.println(fnf.getMessage());
        } catch (IOException io) {
            // User friendly prompt that we create
            System.out.println("Problem our sample file");
            // What the system really feels and wants to tell us
            System.out.println(io.getMessage());
        }
    }

    private void readMySampleFile() {
        // Read from the file we created
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(OUTPUT_FILE)));
            // go through the file line-by-line
            // using Scanners iterator
            // While there are things in the Scanner's bufer
            while (sc.hasNextLine()) {
                // Read in the next line
                String stuffToReadIn = sc.nextLine();
                System.out.println(stuffToReadIn);
                // The line below is the same as the above 2
                // System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException fnf) {
            // tell the user we can't read a file with the location
            System.out.println("Problem reading from file: " + OUTPUT_FILE);
            // show a message for our sanity
            System.out.println(fnf.getMessage());

        }
    }

    private void writeStudentToFile(Student apprentice) { // apprentice is in apprentice signature

        // We have to either try...or catch or throws
        // IOException is  subject to Catch or Specify
        // The IOException is tied to the FileWrite object
        try {
            // PrintWriter may buffer some of our output - so it
            // doesen't immediately write out to the file
            // PrintWriter can store some of it's inputs into memory
            // We will take care of this with flush()
            
            // FileOutputStream allows us to open the file in append mode
            // So if the file exists, we're adding to the file
            PrintWriter outPrinter = new PrintWriter(
                    new FileOutputStream(new File(OUTPUT_FILE2), true));
            outPrinter.println(apprentice.encode());
            // flush forces everything to be written to the file
            // This clears the PrintWriter's buffer
            outPrinter.flush();
            // Close the underlying stream that attaches the PrintWriter to FileWriter
            // the PrintWriter to FileWriter
            // This will free up the file for use to others
            // This allows for proper allocation and deallocation of memory
            // (Proper memory management)
            outPrinter.close();
        } catch (FileNotFoundException fnf) {
            // Tell the user we can't find a file and include the file
            System.out.println("We canot find the file " + OUTPUT_FILE2);
            // Include the specific error message for our own sanity
            System.out.println(fnf.getMessage());
        } catch (IOException io) {
            // User friendly prompt that we create
            System.out.println("Problem our sample file");
            // What the system really feels and wants to tell us
            System.out.println(io.getMessage());
        }

    }
    
     private void readStudentsFromFile() {
        // Read from the file we created
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(OUTPUT_FILE2)));
            // go through the file line-by-line
            // using Scanners iterator
            // While there are things in the Scanner's bufer
            while (sc.hasNextLine()) {
                // Read in the next line
                String stuffToReadIn = sc.nextLine();
                // We need to decode this into a student object:
                Student myStudent = new Student();
                  myStudent = myStudent.decode(stuffToReadIn);
                  // Write out the object
                System.out.println(myStudent);
            }
        } catch (FileNotFoundException fnf) {
            // tell the user we can't read a file with the location
            System.out.println("Problem reading from file: " + OUTPUT_FILE2);
            // show a message for our sanity
            System.out.println(fnf.getMessage());

        }
    }

}
