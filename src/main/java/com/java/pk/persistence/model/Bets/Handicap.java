package com.java.pk.persistence.model.Bets;

import com.java.pk.persistence.model.Coupon;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Created by Tomasz on 2017-11-15.
 */
@Entity(name = "handicap")

public class Handicap extends Bets {

    @NotNull
   private int handicap;

    public int getHandicap() {
        return handicap;
    }

    public void setHandicap(int handicap) {
        this.handicap = handicap;
    }

}
