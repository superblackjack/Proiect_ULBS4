package com.park.proiect_ulbs4.servlet.Authentication;

import com.park.proiect_ulbs4.common.UserDetails;
import com.park.proiect_ulbs4.ejb.UserBean;
import com.park.proiect_ulbs4.util.PasswordUtil;
import java.io.IOException;
import java.util.List;
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
        String curriculum = request.getParameter("curriculum");
        String passwordSha256 = PasswordUtil.convertToSha256(password);

        nume = nume.substring(0, 1).toUpperCase() + nume.substring(1).toLowerCase();
        prenume = prenume.substring(0, 1).toUpperCase() + prenume.substring(1).toLowerCase();

        boolean existInDB = false;
        List<UserDetails> totiUserii = userBean.getAllUsers();

        for (int i = 0; i < totiUserii.size(); i++) {
            if (totiUserii.get(i).getEmail().equals(email)) {
                existInDB = true;
            }
        }
        if (!existInDB) {
            userBean.createUser(nume, prenume, email, passwordSha256, position, curriculum);
            request.setAttribute("SuccesfulRegister", "You have successfully registered");
            request.getRequestDispatcher("/WEB-INF/pages/authentication/login.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "You already have an account created with this email");
            request.getRequestDispatcher("/WEB-INF/pages/authentication/register.jsp").forward(request, response);
        }
    }

    public String getServletInfo() {
        return "Register v1.0";
    }
}
