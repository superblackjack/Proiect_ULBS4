package com.park.proiect_ulbs4.CV;

import com.park.proiect_ulbs4.common.CvDetails;
import com.park.proiect_ulbs4.ejb.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CVs", urlPatterns = {"/CVs"})
public class CVs extends HttpServlet {

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
            out.println("<title>Servlet CVs</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CVs at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        Integer userId = Integer.parseInt(request.getParameter("id"));
        CvDetails cv = userBean.findCvByUserId(userId);
        if(cv != null){
            response.setContentType(cv.getFileType());
            response.setContentLength(cv.getFileContent().length);
            response.getOutputStream().write(cv.getFileContent());
        }
        else{
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "CVs v1.0";
    }

}
