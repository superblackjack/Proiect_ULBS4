package com.park.proiect_ulbs4.servlet.user;

import com.park.proiect_ulbs4.common.JobDetails;
import com.park.proiect_ulbs4.common.UserDetails;
import com.park.proiect_ulbs4.ejb.JobBean;
import com.park.proiect_ulbs4.ejb.UserBean;
import com.park.proiect_ulbs4.entity.User;
import com.park.proiect_ulbs4.util.PasswordUtil;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Sebi
 */
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdminRole"}))
@WebServlet(name = "EditUser", urlPatterns = {"/Users/Update"})
public class EditUser extends HttpServlet {

    @Inject
    UserBean userBean;

    @Inject
    JobBean jobBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //List<JobDetails> jobs = jobBean.getAllJobs();
        //request.setAttribute("jobs", jobs);

        int userId = Integer.parseInt(request.getParameter("id"));
        UserDetails user = userBean.findByID(userId);
        request.setAttribute("user", user);

        request.getRequestDispatcher("/WEB-INF/pages/user/editUser.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nume = request.getParameter("nume");
        String prenume = request.getParameter("prenume");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String position = request.getParameter("position");
        int userId = Integer.parseInt(request.getParameter("user_id"));
        //int jobId = Integer.parseInt(request.getParameter("job_id"));
        
        String userEmail = request.getParameter("user");
        
        List<UserDetails> userbyEmail = userBean.getUserbyEmail(userEmail);
        String ceva = userbyEmail.get(0).getNume();
        request.setAttribute("ceva", ceva);
        String passwordSha256 = PasswordUtil.convertToSha256(password);
        
        userBean.updateUser(userId, nume, prenume, email, passwordSha256, position);

        response.sendRedirect(request.getContextPath() + "/Users");
    }

    @Override
    public String getServletInfo() {
        return "EditJob v1.0";
    }
}
