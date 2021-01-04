package com.park.proiect_ulbs4.common;

/**
 *
 * @author Asus
 */
public class UserDetails {

    private Integer id;
    private String nume;
    private String prenume;
    private String email;
    private String password;
    private String position;

    public UserDetails(Integer id, String nume, String prenume, String email, String position) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.position = position;
    }

    public UserDetails(Integer id, String nume, String prenume, String email, String password, String position) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.password = password;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPosition() {
        return position;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
