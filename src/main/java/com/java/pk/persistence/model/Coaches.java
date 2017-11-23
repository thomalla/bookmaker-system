package com.java.pk.persistence.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


/**
 * Created by Tomasz on 2017-11-15.
 */
@Entity
public class Coaches {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(mappedBy = "coaches")
    private Teams teams;

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
