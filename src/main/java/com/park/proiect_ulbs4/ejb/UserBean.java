/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.proiect_ulbs4.ejb;

import com.park.proiect_ulbs4.common.JobDetails;
import com.park.proiect_ulbs4.common.UserDetails;
import com.park.proiect_ulbs4.entity.Job;
import com.park.proiect_ulbs4.entity.User;
import java.util.ArrayList;
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
public class UserBean {

   private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @PersistenceContext
    private EntityManager em;
    
    public List<UserDetails> getAllUsers() {
        LOG.info("getAllUsers");
        try {
            Query query=em.createQuery("SELECT u FROM User u");
            List<User> users = (List<User>) query.getResultList();
            return copyUsersToDetails(users);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    private List<UserDetails> copyUsersToDetails(List<User> users) {
        List<UserDetails> detailsList = new ArrayList<>();
        for (User user : users) {
            UserDetails UserDetails = new UserDetails(user.getId(),
                    user.getNume(),
                    user.getPrenume(),
                    user.getEmail());
            detailsList.add(UserDetails);
        }
        return detailsList;
    }
}
