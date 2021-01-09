package com.park.proiect_ulbs4.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sebi
 */
@Entity
@Table(name = "APLICANTI")
@NamedQueries({
    @NamedQuery(name = "Aplicanti.findAll", query = "SELECT a FROM Aplicanti a"),
    @NamedQuery(name = "Aplicanti.findById", query = "SELECT a FROM Aplicanti a WHERE a.id = :id"),
    @NamedQuery(name = "Aplicanti.findByIdUser", query = "SELECT a FROM Aplicanti a WHERE a.idUser = :idUser"),
    @NamedQuery(name = "Aplicanti.findByIdJob", query = "SELECT a FROM Aplicanti a WHERE a.idJob = :idJob"),
    @NamedQuery(name = "Aplicanti.findByDataAplicarii", query = "SELECT a FROM Aplicanti a WHERE a.dataAplicarii = :dataAplicarii"),
}) // Pun functiile dupa in AplicantiBean pe care trebuie sa il creez
public class Aplicant implements Serializable {

    //Relatie Many to Many 
    // - Mai multi Useri pot aplica pentru un Job
    // - Un singur User poate aplica la mai multe Joburi
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_JOB")
    private Job idJob;
    
    @JoinColumn(name = "ID_USER")
    @ManyToOne(fetch = FetchType.LAZY)
    private User idUser;

    private static final long serialVersionUID = 1L;
    @Id
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date dataAplicarii;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Job getIdJob() {
        return idJob;
    }

    public void setIdJob(Job idJob) {
        this.idJob = idJob;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }


    public Date getDataAplicarii() {
        return dataAplicarii;
    }

    public void setDataAplicarii(Date dataAplicarii) {
        this.dataAplicarii = dataAplicarii;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aplicant)) {
            return false;
        }
        Aplicant other = (Aplicant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.park.proiect_ulbs4.entity.Aplicant[ id=" + id + " ]";
    }

}
