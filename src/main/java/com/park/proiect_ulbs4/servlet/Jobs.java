/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.proiect_ulbs4.servlet;

import com.park.proiect_ulbs4.common.JobDetails;
import com.park.proiect_ulbs4.ejb.JobBean;
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
 * @author Sebi
 */
@WebServlet(name = "Jobs", urlPatterns = {"/Jobs"})
public class Jobs extends HttpServlet {

    @Inject
    private JobBean jobBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setAttribute("activePage","Jobs");
         
         List<JobDetails> jobs=jobBean.getAllJobs();
         request.setAttribute("jobs",jobs);
         
         request.getRequestDispatcher("/WEB-INF/pages/jobs.jsp").forward(request, response);
         
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
