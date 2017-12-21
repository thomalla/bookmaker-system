package com.java.pk.persistence.model;

import com.java.pk.persistence.model.Bets.Bets;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tomasz on 2017-11-15.
 */
@Entity
@Table(name = "matches")
public class Matches implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "matches")
    private Set<Bets> bets = new HashSet<Bets>(0);

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date date;

    private int homeTeamGoals;

    private int awayTeamGoals;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_match_id", nullable = false)
    private Teams teamsH;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "away_match_id", nullable = false)
    private Teams teamsA;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "matches_players",
            joinColumns = {@JoinColumn(name = "match_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "player_id", referencedColumnName = "id")})
    private List<Players> players;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Bets> getBets() {
        return bets;
    }

    public void setBets(Set<Bets> bets) {
        this.bets = bets;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(int awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }

    public Teams getTeamsH() {
        return teamsH;
    }

    public void setTeamsH(Teams teamsH) {
        this.teamsH = teamsH;
    }

    public Teams getTeamsA() {
        return teamsA;
    }

    public void setTeamsA(Teams teamsA) {
        this.teamsA = teamsA;
    }

    public List<Players> getPlayers() {
        return players;
    }

    public void setPlayers(List<Players> players) {
        this.players = players;
    }
}
