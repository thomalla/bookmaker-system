package com.java.pk.persistence.model.Bets;

import com.java.pk.persistence.model.Coupon;
import com.java.pk.persistence.model.Matches;
import com.java.pk.persistence.model.enums.TypeOfBet;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Tomasz on 2017-11-15.
 */
@Entity
@Table(name = "bets")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="bets")
public class Bets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany(mappedBy = "bets", fetch = FetchType.LAZY)
    private List<Coupon> coupon;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "bets_matches",
            joinColumns = {@JoinColumn(name = "match_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "bet_id", referencedColumnName = "id")})
    private List<Matches> matches;

    @Enumerated(EnumType.STRING)
    private TypeOfBet typeOfBet;

    @NotNull
    private double course;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Coupon> getCoupon() {
        return coupon;
    }

    public void setCoupon(List<Coupon> coupon) {
        this.coupon = coupon;
    }

    public TypeOfBet getTypeOfBet() {
        return typeOfBet;
    }

    public void setTypeOfBet(TypeOfBet typeOfBet) {
        this.typeOfBet = typeOfBet;
    }

    public double getCourse() {
        return course;
    }

    public void setCourse(double course) {
        this.course = course;
    }

    public List<Matches> getMatches() {
        return matches;
    }

    public void setMatches(List<Matches> matches) {
        this.matches = matches;
    }

}
