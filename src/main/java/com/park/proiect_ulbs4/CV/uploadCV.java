package com.park.proiect_ulbs4.CV;

import com.park.proiect_ulbs4.common.JobDetails;
import com.park.proiect_ulbs4.common.UserDetails;
import com.park.proiect_ulbs4.ejb.UserBean;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.park.proiect_ulbs4.ejb.JobBean;

/**
 *
 * @author Sebi
 */
@MultipartConfig
@WebServlet(name = "uploadCV", urlPatterns = {"/uploadCV"})
public class uploadCV extends HttpServlet {

    @Inject
    UserBean userBean;
    
    @Inject
    JobBean jobBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet uploadCV</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet uploadCV at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/myAccount/myAccount.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uploadFilePath = request.getServletContext().getRealPath("../../src/main/webapp/cv");
        HttpSession session = request.getSession();
        UserDetails user = (UserDetails) session.getAttribute("userCurent");
        Part o = request.getPart("file");
        InputStream fileInputStream = o.getInputStream();
        String fileName = user.getId().toString() + "_" + user.getNume() + "_" + user.getPrenume() + ".pdf";

        Integer userId = user.getId();

        Part filePart = request.getPart("file");
        String fileType = filePart.getContentType();
        long fileSize = filePart.getSize();
        byte[] fileContent = new byte[(int) fileSize];
        filePart.getInputStream().read(fileContent);

        userBean.addCVToUser(userId, fileName, fileType, fileContent);

        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }

        File fileToSave = new File(uploadFilePath + File.separator + fileName);
        Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);

        //request.setAttribute("SuccesfulUploadedCV", "You have successfully loaded your CV");
        //request.getRequestDispatcher("/WEB-INF/pages/job/applyJob.jsp").forward(request, response);
        response.sendRedirect(request.getContextPath() + "/Jobs");
    }

    @Override
    public String getServletInfo() {
        return "uploadCV v1.0";
    }

}
