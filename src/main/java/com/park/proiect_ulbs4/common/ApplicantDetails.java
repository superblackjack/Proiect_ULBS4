/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.proiect_ulbs4.common;

import com.park.proiect_ulbs4.entity.Job;
import com.park.proiect_ulbs4.entity.User;
import java.util.Date;

/**
 *
 * @author Sebi
 */
public class ApplicantDetails implements java.io.Serializable {
    
    private Integer id;
    private User idUser;
    private Job idJob;
    private Date dataAplicarii; 

    public ApplicantDetails(Integer id, User idUser, Job idJob, Date dataAplicarii) {
        this.id = id;
        this.idUser = idUser;
        this.idJob = idJob;
        this.dataAplicarii = dataAplicarii;
    }

    public Integer getId() {
        return id;
    }

    public User getIdUser() {
        return idUser;
    }

    public Job getIdJob() {
        return idJob;
    }

    public Date getDataAplicarii() {
        return dataAplicarii;
    }
}
