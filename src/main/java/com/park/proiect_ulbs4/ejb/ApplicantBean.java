package com.park.proiect_ulbs4.ejb;

import com.park.proiect_ulbs4.common.ApplicantDetails;
import com.park.proiect_ulbs4.common.UserDetails;
import com.park.proiect_ulbs4.entity.Applicant;
import com.park.proiect_ulbs4.entity.Job;
import com.park.proiect_ulbs4.entity.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sebi
 */
@Stateless
public class ApplicantBean {

    private static final Logger LOG = Logger.getLogger(ApplicantBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    public ApplicantDetails findByID(Integer applicantId) {
        Applicant applicant = em.find(Applicant.class, applicantId);
        return new ApplicantDetails(applicant.getId(), applicant.getIdUser(), applicant.getIdJob(), applicant.getDataAplicarii());
    }

    public void createApplicant(Integer id, User idUser, Job idJob, Date dataAplicarii) {
        LOG.info("createApplicant");
        Applicant applicant = new Applicant();
        applicant.setId(id);
        applicant.setIdUser(idUser);
        applicant.setIdJob(idJob);
        applicant.setDataAplicarii(dataAplicarii);

        em.persist(applicant);
    }

    public List<ApplicantDetails> getAllApplicants() {
        LOG.info("getAllApplicants");
        try {
            Query query = em.createQuery("SELECT a FROM Applicant a");
            List<Applicant> applicants = (List<Applicant>) query.getResultList();
            return copyApplicantsToDetails(applicants);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<ApplicantDetails> copyApplicantsToDetails(List<Applicant> applicants) {
        List<ApplicantDetails> detailsList = new ArrayList<>();
        for (Applicant applicant : applicants) {
            ApplicantDetails userDetails = new ApplicantDetails(applicant.getId(),
                    applicant.getIdUser(),
                    applicant.getIdJob(),
                    applicant.getDataAplicarii());
            detailsList.add(userDetails);
        }
        return detailsList;
    }

//    public void createApplicant(Integer id, UserDetails user, Job job, Date dataAplicarii) {
//        LOG.info("createApplicant");
//        Applicant applicant = new Applicant();
//        applicant.setId(id);
//        applicant.setIdUser(user);
//        applicant.setIdJob(job);
//        applicant.setDataAplicarii(dataAplicarii);
//
//        em.persist(applicant);
//    }
}
