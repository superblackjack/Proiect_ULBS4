package com.park.proiect_ulbs4.servlet.aplicant;

import com.park.proiect_ulbs4.common.JobDetails;
import com.park.proiect_ulbs4.common.UserDetails;
import com.park.proiect_ulbs4.ejb.ApplicantBean;
import com.park.proiect_ulbs4.ejb.JobBean;
import com.park.proiect_ulbs4.ejb.UserBean;
import com.park.proiect_ulbs4.entity.Job;
import com.park.proiect_ulbs4.entity.User;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
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
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdminRole", "ClientRole"}))
@WebServlet(name = "AddApplicant", urlPatterns = {"/Applicant/Create"})
public class AddApplicant extends HttpServlet {

    @Inject
    UserBean userBean;

    @Inject
    JobBean jobBean;

    @Inject
    ApplicantBean applicantBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int jobId = Integer.parseInt(request.getParameter("id"));
        JobDetails job = jobBean.findByID(jobId);

        request.setAttribute("jobApply", job);

        request.getRequestDispatcher("/WEB-INF/pages/job/jobs.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Job jobCurent = new Job();
        User user_Id = new User();
        Date date = new Date();

        user_Id.setId(Integer.parseInt(request.getParameter("curentUserId")));
        jobCurent.setId(Integer.parseInt(request.getParameter("curentJobId")));

        applicantBean.createApplicant(user_Id, jobCurent, date);
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
        
        response.sendRedirect(request.getContextPath() + "/Jobs");
    }

    @Override
    public String getServletInfo() {
        return "AddApplicant v1.0";
    }

}
