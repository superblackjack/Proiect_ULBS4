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
    private String position;

    public UserDetails(Integer id, String nume, String prenume, String email, String position) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
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

    public String getPosition() {
        return position;
    }
}
