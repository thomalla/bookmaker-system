package com.java.pk.persistence.model;

import com.java.pk.persistence.model.Bets.Bets;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Tomasz on 2017-11-15.
 */
@Entity
@Table(name = "coupon")
public class Coupon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private int bid;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date finalDate;

    @NotNull
    private double possibleWin;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "coupon_bets",
            joinColumns = {@JoinColumn(name = "coupon_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "bet_id", referencedColumnName = "id")})
    private List<Bets> bets;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Users getUser() {
        return users;
    }

    public void setUser(Users user) {
        this.users = user;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public double getPossibleWin() {
        return possibleWin;
    }

    public void setPossibleWin(double possibleWin) {
        this.possibleWin = possibleWin;
    }

    public List<Bets> getBets() {
        return bets;
    }

    public void setBets(List<Bets> bets) {
        this.bets = bets;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

}
