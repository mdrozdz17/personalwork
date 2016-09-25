/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizgrades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class StudentQuizGrades {

    public void run() {

        Map<String, ArrayList> studentMap = createStudentList();

        ConsoleIO io = new ConsoleIO();

        boolean playAgain = true;

        while (playAgain) {

            int choice = io.getInteger("Please Select an option"
                    + " \n 1. View a list of students"
                    + " \n 2. Add a student to list"
                    + " \n 3. Remove a student from list"
                    + " \n 4. View all quiz scores for a student"
                    + " \n 5. View average of quiz scores for a student"
                    + " \n 6. View average score for the entire class"
                    + " \n 7. View students with highest score in the entire class"
                    + " \n 8. View students with lowest score in the entire class"
                    + " \n 9. Exit");

            switch (choice) {

                case 1:
                    listStudents(studentMap);
                    break;
                case 2:
                    studentMap = addStudent(studentMap);
                    break;
                case 3:
                    studentMap = removeStudent(studentMap);
                    break;
                case 4:
                    viewQuizScores(studentMap);
                    break;
                case 5:
                    viewAverageQuizScore(studentMap);
                    break;
                case 6:
                    viewWholeClassAverage(studentMap);
                    break;
                case 7:
                    listStudentsWithHighScore(studentMap);
                    break;
                case 8:
                    listStudentsWithLowScore(studentMap);
                    break;
                case 9:
                    playAgain = false;
                    break;

            }
        }

    }
    // Method to list Students with the lowest score
    public void listStudentsWithLowScore(Map<String, ArrayList> studentMap) {

        Set<String> students = studentMap.keySet();
        ArrayList<Integer> quizScores;
        int lowScore = 100;

        for (String student : students) {

            quizScores = studentMap.get(student);

            lowScore = findStudentLowScore(quizScores, lowScore);

        }

        System.out.println("The following students have a low score of " + lowScore);

        for (String student : students) {

            quizScores = studentMap.get(student);

            if (quizScores.contains(lowScore)) {
                System.out.println(student);
                System.out.println("");
            }
        }

    }
    // Method to find Students with the lowest Quiz Scores
    public int findStudentLowScore(ArrayList<Integer> quizScores, int lowScore) {
        for (int x : quizScores) {

            if (x < lowScore) {
                lowScore = x;
            }
        }
        return lowScore;
    }
    // Method to list students with the highest quiz score
    public void listStudentsWithHighScore(Map<String, ArrayList> studentMap) {

        Set<String> students = studentMap.keySet();
        ArrayList<Integer> quizScores;
        int highScore = 0;

        for (String student : students) {

            quizScores = studentMap.get(student);

            highScore = findClassHighScore(quizScores, highScore);

        }

        System.out.println("The following students have a high score of " + highScore);

        for (String student : students) {

            quizScores = studentMap.get(student);

            if (quizScores.contains(highScore)) {
                System.out.println(student);
                System.out.println("");
            }
        }

    }
    // Method to find the students with the highest score in the class
    public int findClassHighScore(ArrayList<Integer> quizScores, int highScore) {
        for (int x : quizScores) {
            if (x >= highScore) {
                highScore = x;
            }
        }
        return highScore;
    }
    
    // Method to view the class average of the whole class
    public void viewWholeClassAverage(Map<String, ArrayList> studentMap) {

        Set<String> students = studentMap.keySet();
        ArrayList<Integer> quizScores;
        int sum = 0;
        double averageSum = 0;

        for (String student : students) {

            quizScores = studentMap.get(student);

            averageSum = getAverageSum(quizScores, sum);

        }

        System.out.println("The average for the whole class is " + averageSum / studentMap.size());
    }
    
    // Method to get the average sum of quiz scores 
    public double getAverageSum(ArrayList<Integer> quizScores, int sum) {
        double averageSum;
        averageSum = (double) sum / quizScores.size();
        return averageSum;
    }
    
    // Method for view Average Student Quiz Scores
    public void viewAverageQuizScore(Map<String, ArrayList> studentMap) {

        ConsoleIO io = new ConsoleIO();
        String name = io.getStudent(studentMap);
        ArrayList<Integer> quizScores = null;
        int sum = 0;

        Set<String> students = studentMap.keySet();

        for (String student : students) {

            if (student.equals(name)) {

                quizScores = studentMap.get(student);

            }
        }

        for (int x : quizScores) {

            sum += x;

        }

        System.out.println("The average quiz score for this student is " + (double) sum / (quizScores.size()));
        System.out.println("");

    }
    // Method for viewing Quiz Scores. This ties into Console IO.
    public void viewQuizScores(Map<String, ArrayList> studentMap) {

        ConsoleIO io = new ConsoleIO();
        String name = io.getStudent(studentMap);
        ArrayList<Integer> quizScores = null;

        Set<String> students = studentMap.keySet();

        for (String student : students) {

            if (student.equals(name)) {

                quizScores = studentMap.get(student);

            }
        }

        for (int x : quizScores) {

            System.out.println(x);
            System.out.println("");

        }

    }
    // Method for listing all Students
    public void listStudents(Map<String, ArrayList> studentMap) {

        Set<String> names = studentMap.keySet();

        for (String name : names) {

            System.out.println(name);
            System.out.println("");
        }

    }
    
    // Method for removing a student from the HashMap within the Arraylist
    public Map<String, ArrayList> removeStudent(Map<String, ArrayList> studentMap) {

        ConsoleIO io = new ConsoleIO();

        String student = io.getStudent(studentMap);

        studentMap.remove(student);

        return studentMap;
    }

    // Method for adding a student to HashMap within the ArrayList
    public Map<String, ArrayList> addStudent(Map<String, ArrayList> studentMap) {

        ConsoleIO io = new ConsoleIO();

        Scanner sc = new Scanner(System.in);

        System.out.println("Please Enter the student's name");
        String student = sc.nextLine();
        System.out.println("");

        ArrayList<Integer> newStudentScore = new ArrayList();

        int quizScore = io.getQuizScore();

        newStudentScore.add(quizScore);

        studentMap.put(student, newStudentScore);

        return studentMap;

    }

    // create HashMap ArrayList for 5 students
    public Map<String, ArrayList> createStudentList() {

        ArrayList<Integer> DrozdzScores = new ArrayList();

        DrozdzScores.add(100);
        DrozdzScores.add(95);
        DrozdzScores.add(73);
        DrozdzScores.add(80);
        DrozdzScores.add(95);

        ArrayList<Integer> SmithScores = new ArrayList();

        SmithScores.add(79);
        SmithScores.add(84);
        SmithScores.add(82);
        SmithScores.add(100);
        SmithScores.add(26);

        ArrayList<Integer> LongScores = new ArrayList();

        LongScores.add(89);
        LongScores.add(82);
        LongScores.add(26);
        LongScores.add(79);
        LongScores.add(99);

        ArrayList<Integer> MackeyScores = new ArrayList();

        MackeyScores.add(73);
        MackeyScores.add(99);
        MackeyScores.add(81);
        MackeyScores.add(93);
        MackeyScores.add(86);

        ArrayList<Integer> BritoScores = new ArrayList();

        BritoScores.add(69);
        BritoScores.add(89);
        BritoScores.add(72);
        BritoScores.add(97);
        BritoScores.add(86);

        Map<String, ArrayList> studentList = new HashMap();

        studentList.put("Matt Drozdz", DrozdzScores);
        studentList.put("Luke Smith", SmithScores);
        studentList.put("DJ Brito", BritoScores);
        studentList.put("Chris Mackey", MackeyScores);
        studentList.put("David Long", LongScores);

        return studentList;

    }

}
