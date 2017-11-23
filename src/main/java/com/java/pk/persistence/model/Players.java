package com.java.pk.persistence.model;

import com.java.pk.persistence.model.Bets.Bets;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tomasz on 2017-11-15.
 */
@Entity
@Table(name = "players")
public class Players {

    @Id
    @GeneratedValue
    private long id;

    @ManyToMany(mappedBy = "players", fetch = FetchType.LAZY)
    private List<Matches> matches;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
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

    public List<Matches> getMatches() {
        return matches;
    }

    public void setMatches(List<Matches> matches) {
        this.matches = matches;
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
