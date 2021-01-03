package com.park.proiect_ulbs4.servlet;

import com.park.proiect_ulbs4.common.JobDetails;
import com.park.proiect_ulbs4.common.UserDetails;
import com.park.proiect_ulbs4.ejb.JobBean;
import com.park.proiect_ulbs4.ejb.UserBean;
import java.io.IOException;
import java.util.List;
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
 * @author Elix
 */
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdminRole"}))
@WebServlet(name = "EditJob", urlPatterns = {"/EditJob"})
public class EditJob extends HttpServlet {
    
@Inject
UserBean userBean;

@Inject
JobBean jobBean;

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


    @Override
    public String getServletInfo() {
        return "EditJob v1.0";
    }
}
