package com.java.pk.persistence.model;

import com.java.pk.persistence.model.Bets.Bets;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tomasz on 2017-11-15.
 */
@Entity
public class Teams {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teamsH")
    private Set<Matches> matchesH = new HashSet<Matches>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teamsA")
    private Set<Matches> matchesA = new HashSet<Matches>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teams")
    private Set<Players> players = new HashSet<Players>(0);

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coach_id")
    private Coaches coaches;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Matches> getMatchesH() {
        return matchesH;
    }

    public void setMatchesH(Set<Matches> matchesH) {
        this.matchesH = matchesH;
    }

    public Set<Matches> getMatchesA() {
        return matchesA;
    }

    public void setMatchesA(Set<Matches> matchesA) {
        this.matchesA = matchesA;
    }

    public Set<Players> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Players> players) {
        this.players = players;
    }

    public Coaches getCoaches() {
        return coaches;
    }

    public void setCoaches(Coaches coaches) {
        this.coaches = coaches;
    }
}
