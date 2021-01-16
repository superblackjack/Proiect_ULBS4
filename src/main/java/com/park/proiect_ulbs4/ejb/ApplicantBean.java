package com.park.proiect_ulbs4.ejb;

import com.park.proiect_ulbs4.common.ApplicantDetails;
import com.park.proiect_ulbs4.entity.Applicant;
import com.park.proiect_ulbs4.entity.Job;
import com.park.proiect_ulbs4.entity.User;
import com.park.proiect_ulbs4.javamail.JavaMailUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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

    public void createApplicant(User idUser, Job idJob, Date dataAplicarii) {
        LOG.info("createApplicant");
        Applicant applicant = new Applicant();
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

    public void deleteApplicantsByIds(Collection<Integer> ids) {
        LOG.info("deleteJobsByIds");
        for (Integer id : ids) {
            Applicant applicant = em.find(Applicant.class, id);
            em.remove(applicant);
        }
    }
    
    
   
    
}
