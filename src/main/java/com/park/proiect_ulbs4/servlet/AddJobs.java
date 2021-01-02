package com.park.proiect_ulbs4.servlet;

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
 * @author SuperBlackJack
 */
@WebServlet(name = "addJobs", urlPatterns = {"/addJobs"})
public class AddJobs extends HttpServlet {

    @Inject
    UserBean userBean;
    
    @Inject
    JobBean jobBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addJobs</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addJobs at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<UserDetails> users = userBean.getAllUsers();
        request.setAttribute("users", users);
        
        request.getRequestDispatcher("/WEB-INF/pages/addJobs.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String post = request.getParameter("post");
        String descriere = request.getParameter("descriere");
        
        int userId = Integer.parseInt(request.getParameter("user_id"));
        jobBean.createJob(post,descriere,userId);
        response.sendRedirect(request.getContextPath()+"/Jobs");
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
