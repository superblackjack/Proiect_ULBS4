package com.park.proiect_ulbs4.CV;

import com.park.proiect_ulbs4.common.UserDetails;
import com.park.proiect_ulbs4.ejb.UserBean;
import com.park.proiect_ulbs4.entity.User;
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

/**
 *
 * @author Sebi
 */
@MultipartConfig
@WebServlet(name = "uploadCV", urlPatterns = {"/uploadCV"})
public class uploadCV extends HttpServlet {

    @Inject
    UserBean userBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
        //processRequest(request, response);
        Integer userId = Integer.parseInt(request.getParameter("id"));
        UserDetails user = userBean.findByID(userId);
        request.setAttribute("user", user);
        
        request.getRequestDispatcher("/WEB-INF/pages/myAccount/myAccount.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String uploadFilePath = request.getServletContext().getRealPath("../../src/main/webapp/cv");                             //Sebi
        HttpSession session = request.getSession();                                                         //Sebi
        UserDetails user = (UserDetails) session.getAttribute("userCurent");                                //Sebi
        Part o = request.getPart("file");                                                                   //Sebi
        InputStream fileInputStream = o.getInputStream();                                                   //Sebi
        String fileName = user.getId().toString() + "_" + user.getNume() + "_" + user.getPrenume() + ".pdf";//Sebi
        
        
        Integer userId = user.getId();
                
        Part filePart = request.getPart("file");                                                            //PDF
        String fileName2 = filePart.getSubmittedFileName();                                                 //PDF
        String fileType = filePart.getContentType();                                                        //PDF
        long fileSize = filePart.getSize();                                                                 //PDF
        byte[] fileContent = new byte[(int) fileSize];                                                      //PDF
        filePart.getInputStream().read(fileContent);                                                        //PDF
        
        userBean.addCVToUser(userId, fileName2, fileType, fileContent);                                     //PDF
        
        File fileSaveDir = new File(uploadFilePath);                                                        //Sebi
        if(!fileSaveDir.exists()){                                                                          //Sebi
            fileSaveDir.mkdirs();                                                                           //Sebi
        }                                                                                                   //Sebi
        
        File fileToSave = new File(uploadFilePath + File.separator + fileName);                             //Sebi
        Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);              //Sebi
        
        
        
        request.setAttribute("SuccesfulUploadedCV","You have successfully loaded your CV");                 //Sebi
        //response.sendRedirect(request.getContextPath() + "--------------------------");
        request.getRequestDispatcher("/WEB-INF/pages/myAccount/myAccount.jsp").forward(request, response);  //Sebi
    }

    @Override
    public String getServletInfo() {
        return "uploadCV v1.0";
    }

}
