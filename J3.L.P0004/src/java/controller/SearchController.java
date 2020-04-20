/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.PagingBean;
import dao.DigitalDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class SearchController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String error = null;
            String page = request.getParameter("page");
            String title = request.getParameter("title");

            // begin: get total pages with title
            PagingBean bean = new PagingBean();
            bean.setTitle(title);
            int pages = bean.getPages();
            // end: get total pages with title

            // begin: check page and title if it is not correct set atribute error
            if (page == null || title == null) {
                error = "Page not found!";
            } else {
                int p = 0;

                try {
                    p = Integer.parseInt(page);
                } catch (Exception ex) {
                    error = "Page not found!";
                }

                if (p > pages || p <= 0) {
                    error = "Page not found!";
                }

                if (title.isEmpty()) {
                    error = "Page not found!";
                }
            }

            if (error != null) {
                request.setAttribute("error", error);
            }
            // end: check page and title if it is not correct set atribute error

            // begin: set atribute for right page
            DigitalDB ddb = new DigitalDB();
            request.setAttribute("digital_new", ddb.getDigitalNew());
            request.setAttribute("lastArticles", ddb.selectTop(5));
            //end: set atribute for right page
            
            request.getRequestDispatcher("/view/home.jsp?action=bodySearch").forward(request, response);
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
