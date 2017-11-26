/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import exceptions.DailyHealthException;
import java.io.Serializable;
import model.Actor;
import model.Party;
import static view.View.waitForEnterKey;


/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;*/

/**
 *
 * @author Myron Judkins
 */
public class GamePlay implements Serializable {

//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
// public double calculateDailyHealth(double actorHealth, double actorStamina, double dailyFoodEaten, double dailyMilesTraveled){
    public double calculateDailyHealth(double actorHealth, double actorStamina, double dailyFoodEaten, double dailyMilesTraveled) throws DailyHealthException {
        //I have yet to be sure where to get these variables

        if (actorStamina <= 0 || actorStamina > 100) {
           throw new DailyHealthException("Actor Stamina is out of range");
        }
        if (actorHealth <= 0 || actorHealth > 100) {
            throw new DailyHealthException("Actor Health is out of range");
        }
        if (dailyFoodEaten >= 10) {
            throw new DailyHealthException("Food Eaten today is too high");
        }
        if (dailyFoodEaten < 0) {
            throw new DailyHealthException("Food Eaten today is less than zero");
        }
        if (dailyMilesTraveled < 0 || dailyMilesTraveled > 25) {
            throw new DailyHealthException("Miles traveled is out of range");
        }
        double newHealth = (actorHealth + (((dailyFoodEaten * 5) / (dailyMilesTraveled + 1)) - (dailyMilesTraveled * (actorStamina / 220))));
        double newerHealth = Math.round(newHealth);
        if (newerHealth > 100) {
            newerHealth = 100;
        }
        if (0 > newerHealth) {
            newerHealth = 0;
        }
        actorHealth = newerHealth;

        return actorHealth;
    }

    public double calculateAverageStrength(Party party) {
        double totalHealth = 0;

        for (Actor actor : party.getPartyMembers()) {
            totalHealth += actor.getHealth();
        }

        if (totalHealth < 0) {
            return -1;
        }

        return totalHealth / party.getPartyMembers().size();
    }

    public void setDailyHealth(Party party) throws DailyHealthException {
        GamePlay gamePlay = new GamePlay();
        double averageHealth = 0 ;
       int partyMemberCounter = 0 ;
        System.out.println("Your Health and food has been updated for Today");
        for (Actor actor : party.getPartyMembers()) {
            actor.setHealth((int) gamePlay.calculateDailyHealth(actor.getHealth(), actor.getStamina(), 2.5, 8));
            System.out.println("Health for " + actor.getName() + " is " + actor.getHealth());
           averageHealth = averageHealth +  actor.getHealth();
           if (actor.getHealth() > 0 )
               partyMemberCounter++ ;
        }
        System.out.println("The Average Health for party members is " + averageHealth / partyMemberCounter );
        waitForEnterKey();
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof GamePlay)) {
//            return false;
//        }
//        GamePlay other = (GamePlay) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "control.GamePlay[ id=" + id + " ]";
//    }
}
