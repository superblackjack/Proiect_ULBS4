/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.proiect_ulbs4.servlet.job;

import com.park.proiect_ulbs4.common.JobDetails;
import com.park.proiect_ulbs4.ejb.ApplicantBean;
import com.park.proiect_ulbs4.ejb.JobBean;
import com.park.proiect_ulbs4.ejb.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SuperBlackJack
 */
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"ClientRole"}))
@WebServlet(name = "ApplyJob", urlPatterns = {"/Jobs/Apply"})
public class ApplyJob extends HttpServlet {

    @Inject
    ApplicantBean applicantBean;
 
    @Inject
    JobBean jobBean;
    
    @Inject
    UserBean userBean;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int jobId = Integer.parseInt(request.getParameter("id"));
        JobDetails job = jobBean.findByID(jobId);
        request.setAttribute("jobApply", job);
        
        request.getRequestDispatcher("/WEB-INF/pages/job/applyJob.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
