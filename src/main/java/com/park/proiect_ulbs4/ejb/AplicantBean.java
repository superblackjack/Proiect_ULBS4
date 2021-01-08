package com.park.proiect_ulbs4.ejb;

import com.park.proiect_ulbs4.common.AplicantDetails;
import com.park.proiect_ulbs4.entity.Aplicant;
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
        return new AplicantDetails(aplicant.getId(), aplicant.idUser().getId(), aplicant.getIdJob().getId(), aplicant.getDataAplicarii());
    }   
        

    public void createAplicant(Integer id, Integer idUser, Integer idJob, Date dataAplicarii) {

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
}