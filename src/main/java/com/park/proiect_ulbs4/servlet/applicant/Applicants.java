package com.park.proiect_ulbs4.servlet.applicant;

import com.park.proiect_ulbs4.common.ApplicantDetails;
import com.park.proiect_ulbs4.ejb.ApplicantBean;
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
@WebServlet(name = "Applicants", urlPatterns = {"/Applicants"})
public class Applicants extends HttpServlet {

    @Inject
    ApplicantBean applicantBean;

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
        //processRequest(request, response);
        request.setAttribute("activePage", "Applicants");
        List<ApplicantDetails> applicants = applicantBean.getAllApplicants();
        request.setAttribute("applicants", applicants);
        request.getRequestDispatcher("/WEB-INF/pages/applicant/applicants.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Applicants v1.0";
    }

}
