/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DigitalDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Digital;

/**
 *
 * @author Administrator
 */
public class DigitalControler extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            DigitalDB ddb = new DigitalDB();
            String id = request.getParameter("id");
            int digital_id = 0;
            String error = null;

            // begin: check input after set atribute error
            try {
                digital_id = Integer.parseInt(id);
            } catch (Exception ex) {
                error = "Page not found!";
            }
            
            Digital digital = ddb.selectDigitalById(digital_id);
            
            if (digital == null) {
                error = "Page not found!";
            }

            if (error != null) {
                request.setAttribute("error", error);
            }
            // end: check input after set atribute error

            // begin: set atribute for a digital with id = digital_id and right page
            request.setAttribute("digital", digital);
            request.setAttribute("digital_new", ddb.getDigitalNew());
            request.setAttribute("lastArticles", ddb.selectTop(5));
            // end: set atribute for a digital and right page
            
            request.getRequestDispatcher("/view/home.jsp?action=body").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("handler-error").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
