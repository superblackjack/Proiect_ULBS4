/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.proiect_ulbs4.servlet;

import com.park.proiect_ulbs4.common.JobDetails;
import com.park.proiect_ulbs4.common.UserDetails;
import com.park.proiect_ulbs4.ejb.JobBean;
import com.park.proiect_ulbs4.ejb.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Elix
 */
@WebServlet(name = "EditJob", urlPatterns = {"/EditJob"})
public class EditJob extends HttpServlet {
    
@Inject
UserBean userBean;

@Inject
JobBean jobBean;

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditJob</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditJob at " + request.getContextPath() + "</h1>");
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
        
        List<UserDetails> users = userBean.getAllUsers();
        request.setAttribute("users",users);
        
        int jobId = Integer.parseInt(request.getParameter("id"));
        JobDetails job = jobBean.findByID(jobId);
        request.setAttribute("job", job);
        
        request.getRequestDispatcher("/WEB-INF/pages/editJob.jsp").forward(request, response);
        
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
        
        String post = request.getParameter("post");
        String descriere = request.getParameter("descriere");
        int userId = Integer.parseInt(request.getParameter("user_id"));
        int jobId = Integer.parseInt(request.getParameter("job_id"));
        
        jobBean.updateJob(jobId,post,descriere,userId);
        
        response.sendRedirect(request.getContextPath()+ "/Jobs");
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
