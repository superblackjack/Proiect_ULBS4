package com.park.proiect_ulbs4.servlet.job;

import com.park.proiect_ulbs4.common.JobDetails;
import com.park.proiect_ulbs4.ejb.JobBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.DeclareRoles;
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
@DeclareRoles({"AdminRole", "ClientRole"})
@ServletSecurity( value = @HttpConstraint(rolesAllowed = {"AdminRole"})
//        httpMethodConstraint = {
//            @HttpMethodConstraint(value = "POST", rolesAllowed = {"AdminRole"})
//        }
)
@WebServlet(name = "Jobs", urlPatterns = {"/Jobs"})
public class Jobs extends HttpServlet {

    @Inject
    private JobBean jobBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("activePage", "Jobs");

        List<JobDetails> jobs = jobBean.getAllJobs();
        request.setAttribute("jobs", jobs);

        request.getRequestDispatcher("/WEB-INF/pages/job/jobs.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String[] jobIdsAsString = request.getParameterValues("job_ids");
        if (jobIdsAsString != null) {
            List<Integer> jobIds = new ArrayList<>();
            for (String jobIdAsString : jobIdsAsString) {
                jobIds.add(Integer.parseInt(jobIdAsString));
            }
            jobBean.deleteJobsByIds(jobIds);
        }
        response.sendRedirect(request.getContextPath() + "/Jobs");
    }

    @Override
    public String getServletInfo() {
        return "Jobs v1.0";
    }
}
