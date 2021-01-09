package com.park.proiect_ulbs4.ejb;

import com.park.proiect_ulbs4.common.AplicantDetails;
import com.park.proiect_ulbs4.common.UserDetails;
import com.park.proiect_ulbs4.entity.Aplicant;
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
public class AplicantBean {

    private static final Logger LOG = Logger.getLogger(AplicantBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    public AplicantDetails findByID(Integer aplicantId) {
        Aplicant aplicant = em.find(Aplicant.class, aplicantId);
        return new AplicantDetails(aplicant.getId(), aplicant.getIdUser(), aplicant.getIdJob(), aplicant.getDataAplicarii());
    }

    public void createAplicant(Integer id, User idUser, Job idJob, Date dataAplicarii) {
        LOG.info("createAplicant");
        Aplicant aplicant = new Aplicant();
        aplicant.setId(id);
        aplicant.setIdUser(idUser);
        aplicant.setIdJob(idJob);
        aplicant.setDataAplicarii(dataAplicarii);

        em.persist(aplicant);
    }

    public List<AplicantDetails> getAllAplicants() {
        LOG.info("getAllAplicants");
        try {
            Query query = em.createQuery("SELECT a FROM Aplicant a");
            List<Aplicant> aplicanti = (List<Aplicant>) query.getResultList();
            return copyAplicantiToDetails(aplicanti);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<AplicantDetails> copyAplicantiToDetails(List<Aplicant> aplicanti) {
        List<AplicantDetails> detailsList = new ArrayList<>();
        for (Aplicant aplicant : aplicanti) {
            AplicantDetails userDetails = new AplicantDetails(aplicant.getId(),
                    aplicant.getIdUser(),
                    aplicant.getIdJob(),
                    aplicant.getDataAplicarii());
            detailsList.add(userDetails);
        }
        return detailsList;
    }

//    public void createAplicant(Integer id, UserDetails user, Job job, Date dataAplicarii) {
//        LOG.info("createAplicant");
//        Aplicant aplicant = new Aplicant();
//        aplicant.setId(id);
//        aplicant.setIdUser(user);
//        aplicant.setIdJob(job);
//        aplicant.setDataAplicarii(dataAplicarii);
//
//        em.persist(aplicant);
//    }
}
