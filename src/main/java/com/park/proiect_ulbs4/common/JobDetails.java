package com.park.proiect_ulbs4.common;

/**
 *
 * @author Asus
 */
public class JobDetails implements java.io.Serializable {

    private Integer id;
    private String post;
    private String descriere;
    private String email;

    public JobDetails(Integer id, String post, String descriere, String email) {
        this.id = id;
        this.post = post;
        this.descriere = descriere;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getPost() {
        return post;
    }

    public String getDescriere() {
        return descriere;
    }

    public String getEmail() {
        return email;
    }
}
