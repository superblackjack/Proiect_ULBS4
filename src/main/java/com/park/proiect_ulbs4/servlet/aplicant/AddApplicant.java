package com.park.proiect_ulbs4.servlet.aplicant;

import com.park.proiect_ulbs4.common.JobDetails;
import com.park.proiect_ulbs4.common.UserDetails;
import com.park.proiect_ulbs4.ejb.ApplicantBean;
import com.park.proiect_ulbs4.ejb.JobBean;
import com.park.proiect_ulbs4.ejb.UserBean;
import com.park.proiect_ulbs4.entity.Job;
import com.park.proiect_ulbs4.entity.User;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
/**
 *
 * @author Sebi
 */
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdminRole", "ClientRole"}))
@WebServlet(name = "AddApplicant", urlPatterns = {"/Applicant/Create"})
public class AddApplicant extends HttpServlet {

    @Inject
    UserBean userBean;

    @Inject
    JobBean jobBean;

    @Inject
    ApplicantBean applicantBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int jobId = Integer.parseInt(request.getParameter("id"));
        JobDetails job = jobBean.findByID(jobId);

        request.setAttribute("jobApply", job);

        request.getRequestDispatcher("/WEB-INF/pages/job/jobs.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Job jobCurent = new Job();
        User user_Id = new User();
        Date date = new Date();
       
        user_Id.setId(Integer.parseInt(request.getParameter("curentUserId")));
        jobCurent.setId(Integer.parseInt(request.getParameter("curentJobId")));

        applicantBean.createApplicant(user_Id, jobCurent, date);
      
        request.getRequestDispatcher("/WEB-INF/pages/myAccount/myAccount.jsp").forward(request, response);
   
    }

    @Override
    public String getServletInfo() {
        return "AddApplicant v1.0";
    }

}
