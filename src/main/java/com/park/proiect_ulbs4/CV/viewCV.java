package com.park.proiect_ulbs4.CV;

import com.park.proiect_ulbs4.common.UserDetails;
import com.park.proiect_ulbs4.ejb.UserBean;
import java.io.IOException;
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
 * @author Sebi
 */
@WebServlet(name = "viewCV", urlPatterns = {"/viewCV"})
public class viewCV extends HttpServlet {

    @Inject
    UserBean userBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        UserDetails user = userBean.findByID(userId);
        request.setAttribute("user", user);

        String pdfPath = userBean.obtainCV(user.getId(), user.getNume(), user.getPrenume());

        HttpSession session = request.getSession();
        session.setAttribute("CVPATH2", pdfPath);

        RequestDispatcher dispatcher = null;

        dispatcher = request.getServletContext().getRequestDispatcher(pdfPath);
        dispatcher.forward(request, response);

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
        return "viewCV v1.0";
    }

}
