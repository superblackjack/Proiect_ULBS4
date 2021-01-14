package com.park.proiect_ulbs4.servlet.user;

import com.park.proiect_ulbs4.common.UserDetails;
import com.park.proiect_ulbs4.ejb.UserBean;
import com.park.proiect_ulbs4.util.PasswordUtil;
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
 * @author Alexandra
 */
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdminRole"}))
@WebServlet(name = "AddUser", urlPatterns = {"/Users/Create"})
public class AddUser extends HttpServlet {

    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<UserDetails> users = userBean.getAllUsers();
        request.setAttribute("users", users);
        
        request.getRequestDispatcher("/WEB-INF/pages/user/addUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nume = request.getParameter("nume");
        String prenume = request.getParameter("prenume");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String position = request.getParameter("position");
        String curriculum = request.getParameter("curriculum");

        String passwordSha256 = PasswordUtil.convertToSha256(password);

        userBean.createUser(nume, prenume, email, passwordSha256, position, curriculum);

        response.sendRedirect(request.getContextPath() + "/Users");
    }

    @Override
    public String getServletInfo() {
        return "AddUser v1.0";
    }
}
