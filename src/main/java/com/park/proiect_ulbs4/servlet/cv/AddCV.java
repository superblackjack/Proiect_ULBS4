package com.park.proiect_ulbs4.servlet.cv;
import com.park.proiect_ulbs4.common.UserDetails;
import com.park.proiect_ulbs4.ejb.JobBean;
import com.park.proiect_ulbs4.ejb.UserBean;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 *
 * @author SuperBlackJack
 */
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"ClientRole"}))
@WebServlet(name = "AddCV", urlPatterns = {"/Users/AddCV"})
@MultipartConfig
       
public class AddCV extends HttpServlet {
    
@Inject
UserBean userBean;

@Inject
JobBean jobBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {     
        int userId = Integer.parseInt(request.getParameter("id"));
        UserDetails user = userBean.findByID(userId);
        request.setAttribute("user", user);
        
        request.getRequestDispatcher("/WEB-INF/pages/cv/addCV.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userIdAsString = request.getParameter("user_id");
        Integer userId = Integer.parseInt(userIdAsString);
        
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String fileType = filePart.getContentType();
        long fileSize = filePart.getSize();
        byte[] fileContent = new byte[(int) fileSize];
        filePart.getInputStream().read(fileContent);
        
        userBean.addCVToUser(userId, fileName, fileType, fileContent);
        response.sendRedirect(request.getContextPath()+"/Jobs");
        
    }



    @Override
    public String getServletInfo() {
        return "AddCV v1.0";
    }
}
