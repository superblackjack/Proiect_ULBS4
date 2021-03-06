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
    private String curriculum;

    public UserDetails(Integer id, String nume, String prenume, String email, String position, String curriculum) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.position = position;
        this.curriculum = curriculum;
    }

    public UserDetails(Integer id, String nume, String prenume, String email, String password, String position, String curriculum) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.password = password;
        this.position = position;
        this.curriculum = curriculum;
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

    public String getCurriculum() {
        return curriculum;
    }
}
