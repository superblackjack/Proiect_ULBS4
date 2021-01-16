package com.park.proiect_ulbs4.servlet.aplicant;

import com.park.proiect_ulbs4.common.ApplicantDetails;
import com.park.proiect_ulbs4.common.UserDetails;
import com.park.proiect_ulbs4.ejb.ApplicantBean;
import com.park.proiect_ulbs4.ejb.JobBean;
import com.park.proiect_ulbs4.ejb.UserBean;
import com.park.proiect_ulbs4.javamail.JavaMailUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sebi
 */
@WebServlet(name = "Applicants", urlPatterns = {"/Applicants"})
public class Applicants extends HttpServlet {

    @Inject
    ApplicantBean applicantBean;

    @Inject
    JobBean jobBean;

    @Inject
    UserBean userBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Applicants</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Applicants at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("activePage", "Applicants");
        List<ApplicantDetails> applicants = applicantBean.getAllApplicants();
        request.setAttribute("applicants", applicants);
        request.getRequestDispatcher("/WEB-INF/pages/applicant/applicants.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] applicantIdsAsString = request.getParameterValues("applicant_ids");
        int situation = Integer.parseInt(request.getParameter("situation"));
        if (applicantIdsAsString != null) {
            List<Integer> applicantIds = new ArrayList<>();
            String Email;
            String JobName;
            String Mesaj = "";
            String Mesajx = "";
            
            if (situation == 0) {
                Mesaj = "We are sorry, you haven't been accepted to ";
                Mesajx = "Good luck next time!";
            }
            if (situation == 1) {
                Mesaj = "Congrats! You have been accepted to ";
                Mesajx = "We will inform you further through a phone call.";
            }

            for (String applicantIdAsString : applicantIdsAsString) {
                applicantIds.add(Integer.parseInt(applicantIdAsString));
                JobName = applicantBean.findByID(Integer.parseInt(applicantIdAsString)).getIdJob().getPost();
                Email = applicantBean.findByID(Integer.parseInt(applicantIdAsString)).getIdUser().getEmail();

                JavaMailUtil.sendMail(Email, Mesaj + JobName + " . \n" + Mesajx);
            }

            applicantBean.deleteApplicantsByIds(applicantIds);
        }
        response.sendRedirect(request.getContextPath() + "/Applicants");
    }

    @Override
    public String getServletInfo() {
        return "Applicants v1.0";
    }
}
