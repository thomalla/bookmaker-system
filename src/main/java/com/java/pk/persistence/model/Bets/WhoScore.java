package com.java.pk.persistence.model.Bets;

import com.java.pk.persistence.model.Coupon;
import com.java.pk.persistence.model.Players;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tomasz on 2017-11-15.
 */
@Entity
@DiscriminatorValue("whoscorebets")
public class WhoScore extends Bets {

    @NotNull
    private int scorer_id;

    @NotNull
    private int number;

    public int getScorer_id() {
        return scorer_id;
    }

    public void setScorer_id(int scorer_id) {
        this.scorer_id = scorer_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
