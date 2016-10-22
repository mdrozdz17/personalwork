/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.factorizerweb;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.sum;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "FactorizerServlet", urlPatterns = {"/FactorizerServlet"})
public class FactorizerServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FactorizerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FactorizerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        
        String myInput = request.getParameter("myInput");
        int number;
        number = Integer.parseInt(myInput);
        int factorSum = 0;
        
        ArrayList<Integer> factors = new ArrayList();
        
        for (int i = 1; i < number; i++) {

            if (number % i == 0) {
                factors.add(i); // can't sout so must use an ArrayList
                factorSum = factorSum + i;

            }
        }
        String message1 = "";
        String message2 = "";
        String message3 = ("The factors of " + number + " are:");
        

        // If input number = 1 and itself than the number is Perfect otherwise it is not.
        if (number == factorSum) {
            message1 = (number + " is Perfect!");
        } else {
            message1 = (number + " is not Perfect!");
            

        }

        // If input number = 1 than the number is Prime otherwise it is not.
        if (factorSum == 1) {
           message2 = (number + " is Prime!");
        } else {
            message2 = (number + " is not Prime!");
        }
           request.setAttribute("prime", message1);
           request.setAttribute("perfect", message2);
          request.setAttribute("factors", factors);

            RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
            rd.forward(request, response);
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
