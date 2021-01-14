package com.park.proiect_ulbs4.entity;

import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Elix
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)

    public Integer id;

    private String nume;

    private String prenume;

    private String email;

    private String password;

    private String position;

    private String curriculum;

    @JsonbTransient
    @OneToMany(mappedBy = "user")
    private Collection<Job> jobs;

    @OneToMany(mappedBy = "idUser")
    private Collection<Applicant> aplicanti;
    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CV cv;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Collection<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Collection<Job> jobs) {
        this.jobs = jobs;
    }

    public Collection<Applicant> getAplicanti() {
        return aplicanti;
    }

    public void setAplicanti(Collection<Applicant> aplicanti) {
        this.aplicanti = aplicanti;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }
    
    public CV getCv() {
        return cv;
    }

    public void setCv(CV cv) {
        this.cv = cv;
    }
    
    public String obtainCV() {
        URL s = this.getClass().getProtectionDomain().getCodeSource().getLocation();
        String p = s.getPath();
        String returnat = "";
        if (p.contains("/")) {
            p = p.replace("WEB-INF/classes/com/park/proiect_ulbs4/entity/User.class", "cv/");
            p = p.replace("WEB-INF/classes/com/park/proiect_ulbs4/entity/User.class", "cv/");
            returnat += "cv/";
        }
        p += id.toString() + ".pdf";
        returnat += id.toString() + ".pdf";

        try {
            p = java.net.URLDecoder.decode(p, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            // Nu se va intampla deoarece valoarea provine din propriul JDK - StandardCharsets
        }
        
        File file = new File(p);
        if(file.exists()){
            return returnat;
        }else{
            return "#";
        }
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.park.proiect_ulbs4.entity.User[ id=" + id + " ]";
    }
}
