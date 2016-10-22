package com.sg.luckysevensweb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author apprentice
 */
@WebServlet(urlPatterns = {"/LuckySevensServlet"})
public class LuckySevensServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DecimalFormat d = new DecimalFormat("'$'0.00");
        String myInput = request.getParameter("myInput");
        int die1; // declare dice1
        int die2; // declare dice2
        double money; // How much $ was won or lost
        double mostMoneyHeld; // Most money held by the player at one point in time
        int rollCountMax = 0; // Roll Count Max when user had the most money
        int rollCountTotal = 0; // Total number of rolls when depletion was hit

        money = Double.parseDouble(myInput);
        
        mostMoneyHeld = money;
        
           while (money > 0) {
            rollCountTotal++;
            
        Random rGen = new Random();
        die1 = rGen.nextInt(6) + 1;
        die2 = rGen.nextInt(6) + 1;

        
        if (die1 + die2 == 7) {
            money += 4; // win $4
        } else {
            money -= 1; // lose $1
        }
       
        if (money > mostMoneyHeld) {
            mostMoneyHeld = money;
            rollCountMax = rollCountTotal;
        }
           }
      
       String message1 = "You were broke after " + rollCountTotal + " rolls";
       String message2 = "You should have quit after " + rollCountMax
                + " rolls when you had  " + d.format(mostMoneyHeld) + ".";
        
        request.setAttribute("message1", message1);
        request.setAttribute("message2", message2);

        RequestDispatcher rd = request.getRequestDispatcher("response.jsp");

        rd.forward(request,response);
        
        processRequest(request, response);
    
           
           }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

