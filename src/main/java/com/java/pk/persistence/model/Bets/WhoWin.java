package com.java.pk.persistence.model.Bets;

import com.java.pk.persistence.model.Coupon;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Tomasz on 2017-11-15.
 */
@Entity(name = "whowin")

public class WhoWin extends Bets {

    @NotBlank
    private String team;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

}
