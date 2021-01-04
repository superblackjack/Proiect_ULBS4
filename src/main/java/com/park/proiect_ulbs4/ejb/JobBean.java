package com.park.proiect_ulbs4.ejb;

import com.park.proiect_ulbs4.common.JobDetails;
import com.park.proiect_ulbs4.entity.CV;
import com.park.proiect_ulbs4.entity.Job;
import com.park.proiect_ulbs4.entity.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Gabi
 */
@Stateless
public class JobBean {

    private static final Logger LOG = Logger.getLogger(JobBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    public JobDetails findByID(Integer jobId) {
        Job job = em.find(Job.class, jobId);
        return new JobDetails(job.getId(), job.getPost(), job.getDescriere(), job.getUser().getEmail());
    }

    public List<JobDetails> getAllJobs() {
        LOG.info("getAllJobs");
        try {
            Query query = em.createQuery("SELECT j FROM Job j");
            List<Job> jobs = (List<Job>) query.getResultList();
            return copyJobsToDetails(jobs);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<JobDetails> copyJobsToDetails(List<Job> jobs) {
        List<JobDetails> detailsList = new ArrayList<>();
        for (Job job : jobs) {
            JobDetails jobDetails = new JobDetails(job.getId(),
                    job.getPost(),
                    job.getDescriere(),
                    job.getUser().getEmail());
            detailsList.add(jobDetails);
        }
        return detailsList;
    }

    public void createJob(String post, String descriere, Integer userId) {
        LOG.info("createJob");
        Job job = new Job();
        job.setPost(post);
        job.setDescriere(descriere);
        User user = em.find(User.class, userId);
        user.getJobs().add(job);
        job.setUser(user);
        em.persist(job);
    }

    public void updateJob(Integer jobId, String post, String descriere, Integer userId) {
        LOG.info("updateJob");
        Job job = em.find(Job.class, jobId);
        job.setPost(post);
        job.setDescriere(descriere);
        User oldUser = job.getUser();
        oldUser.getJobs().remove(job);
        User user = em.find(User.class, userId);
        user.getJobs().add(job);
        job.setUser(user);
        em.persist(job);
    }

    public void deleteJobsByIds(Collection<Integer> ids) {
        LOG.info("deleteJobsByIds");
        for (Integer id : ids) {
            Job job = em.find(Job.class, id);
            em.remove(job);
        }
    }

    public void addCVToJob(Integer jobId, String filename, String fileType, byte[] fileContent) {
        LOG.info("addCVToJob");
        CV cv = new CV();
        cv.setFilename(filename);
        cv.setFileType(fileType);
        cv.setFileContent(fileContent);
        Job job = em.find(Job.class, jobId);
        job.setCv(cv);
        cv.setJob(job);
        em.persist(cv);
    }
}
