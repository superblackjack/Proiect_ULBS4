package com.park.proiect_ulbs4.ejb;

import com.park.proiect_ulbs4.common.UserDetails;
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
public class UserBean {

    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    public UserDetails findByID(Integer userId) {
        User user = em.find(User.class, userId);
        return new UserDetails(user.getId(), user.getNume(), user.getPrenume(), user.getEmail(), user.getPassword(), user.getPosition(), user.getCV());
    }

    public List<UserDetails> getAllUsers() {
        LOG.info("getAllUsers");
        try {
            Query query = em.createQuery("SELECT u FROM User u");
            List<User> users = (List<User>) query.getResultList();
            return copyUsersToDetails(users);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<UserDetails> getUserById() {
        LOG.info("getUserById");
        try {
            Query query = em.createQuery("SELECT u FROM User u WHERE u.id = :id");
            List<User> users = (List<User>) query.getResultList();
            return copyUsersToDetails(users);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<UserDetails> getUserByName() {
        LOG.info("getUserByName");
        try {
            Query query = em.createQuery("SELECT u FROM User u WHERE u.nume = :nume");
            List<User> users = (List<User>) query.getResultList();
            return copyUsersToDetails(users);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<UserDetails> getUserBySurname() {
        LOG.info("getUserBySurname");
        try {
            Query query = em.createQuery("SELECT u FROM User u WHERE u.prenume = :prenume");
            List<User> users = (List<User>) query.getResultList();
            return copyUsersToDetails(users);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

//    public List<UserDetails> getUserByEmail() {
//        LOG.info("getUserByEmail");
//        try {
//            Query query = em.createQuery("SELECT u FROM User u WHERE u.email = :email");
//            List<User> users = (List<User>) query.getResultList();
//            return copyUsersToDetails(users);
//        } catch (Exception ex) {
//            throw new EJBException(ex);
//        }
//    }
    // Dupa ce ruleaza programul cu Aplicanti, verifica daca in loc de functia de jos getUserbyEmail merge cea de sus (Cea de jos e pt SessionUser si mai ceva)
    public List<UserDetails> getUserbyEmail(String email) {
        LOG.info("getUserbyEmail");
        try {
            Query query = em.createQuery("SELECT u FROM User u WHERE u.email = :email").setParameter("email", email);
            List<User> users = (List<User>) query.getResultList();
            return copyUsersToDetails(users);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<UserDetails> getUserByPosition() {
        LOG.info("getUserByPosition");
        try {
            Query query = em.createQuery("SELECT u FROM User u WHERE u.position = :position");
            List<User> users = (List<User>) query.getResultList();
            return copyUsersToDetails(users);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<UserDetails> copyUsersToDetails(List<User> users) {
        List<UserDetails> detailsList = new ArrayList<>();
        for (User user : users) {
            UserDetails userDetails = new UserDetails(user.getId(),
                    user.getNume(),
                    user.getPrenume(),
                    user.getEmail(),
                    user.getPosition(),
                    user.getCV());
            detailsList.add(userDetails);
        }
        return detailsList;
    }

    public void createUser(String nume, String prenume, String email, String passwordSha256, String position, String CV) {
        boolean existInDB = false;
        List<UserDetails> totiUserii = getAllUsers();

        for (int i = 0; i < totiUserii.size(); i++) {
            if (totiUserii.get(i).getEmail().equals(email)) {
                existInDB = true;
            }
        }
        if (!existInDB) {
            LOG.info("createUser");
            User user = new User();
            user.setNume(nume);
            user.setPrenume(prenume);
            user.setEmail(email);
            user.setPassword(passwordSha256);
            user.setPosition(position);
            user.setCV(CV);

            em.persist(user);
        } else {
        }
    }

    public void updateUser(Integer userId, String nume, String prenume, String email, String passwordSha256, String position, String CV) {
        LOG.info("updateUser");

        User user = em.find(User.class, userId);
        user.setNume(nume);
        user.setPrenume(prenume);
        user.setEmail(email);
        user.setPassword(passwordSha256);
        user.setPosition(position);
        user.setCV(CV);

        //Job oldJob = user.getJobs();
        //oldUser.getJobs().remove(user);
        //User user = em.find(User.class, userId);
        //user.getJobs().add(job);
        //job.setUser(user);
        em.persist(user);
    }

    public void deleteUsersByIds(Collection<Integer> ids) {
        LOG.info("deleteUsersByIds");
        for (Integer id : ids) {
            User user = em.find(User.class, id);
            em.remove(user);
        }
    }
}
