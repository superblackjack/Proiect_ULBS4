package com.park.proiect_ulbs4.servlet.user;

import com.park.proiect_ulbs4.common.UserDetails;
import com.park.proiect_ulbs4.ejb.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asus
 */
@WebServlet(name = "SessionUser", urlPatterns = {"/SessionUser"})
public class SessionUser extends HttpServlet {

    @Inject
    UserBean userBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String emailCurent = (String) session.getAttribute("emailUserCurent");
            List<UserDetails> userbyEmail = userBean.getUserbyEmail(emailCurent);
            session.setAttribute("userCurent", userbyEmail.get(0));
            
            request.setAttribute("message", "Email or password incorrect");
            
            RequestDispatcher dispatcher = null;
            
            dispatcher = request.getServletContext().getRequestDispatcher("/index-mask.jsp");
            dispatcher.forward(request, response);
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
        return "SessionUser v1.0 - obtine in variabila session userul curent";
    }

}
