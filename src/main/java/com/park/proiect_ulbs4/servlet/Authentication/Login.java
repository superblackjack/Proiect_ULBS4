package com.park.proiect_ulbs4.servlet.Authentication;

import com.park.proiect_ulbs4.common.UserDetails;
import com.park.proiect_ulbs4.ejb.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sebi
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getRequestDispatcher("/WEB-INF/pages/authentication/login.jsp").forward(request, response);
            
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nume = request.getParameter("nume");

        HttpSession session = request.getSession();
        session.setAttribute("nume", nume);

        request.setAttribute("message", "Email or password incorrect");
        //request.getRequestDispatcher("/WEB-INF/pages/authentication/login.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Login v1.0";
    }
}
