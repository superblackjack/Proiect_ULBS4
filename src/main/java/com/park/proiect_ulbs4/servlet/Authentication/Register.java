/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.proiect_ulbs4.servlet.Authentication;

import com.park.proiect_ulbs4.ejb.UserBean;
import com.park.proiect_ulbs4.util.PasswordUtil;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/authentication/register.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nume = request.getParameter("nume");
        String prenume = request.getParameter("prenume");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String position = request.getParameter("position");
        String CV = request.getParameter("CV");
        //String msg=".";
        String passwordSha256 = PasswordUtil.convertToSha256(password);
        
        nume = nume.substring(0,1).toUpperCase() + nume.substring(1).toLowerCase();
        prenume = prenume.substring(0,1).toUpperCase() + prenume.substring(1).toLowerCase();
        userBean.createUser(nume, prenume, email, passwordSha256, position, CV);
        //request.setAttribute("message", msg);
        response.sendRedirect(request.getContextPath() + "/Login");

    }

    public String getServletInfo() {
        return "Register v1.0";
    }

}
