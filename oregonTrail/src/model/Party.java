package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Kevin's Account
 */
public class Party implements Serializable {

    public ArrayList<Actor> getPremadeCharacters() {
        ArrayList<Actor> partyMembers = new ArrayList<>();
        // create actors
        Actor myron = new Actor();
        myron.setName("Myron");
        Actor kevin = new Actor();
        kevin.setName("Kevin");
        Actor dan = new Actor();
        dan.setName("Dan");
        Actor ricardo = new Actor();
        ricardo.setName("Ricardo");
        Actor steve = new Actor();
        steve.setName("Steve");
        Actor mary = new Actor();
        mary.setName("Mary");
        Actor bethany = new Actor();
        bethany.setName("Bethany");
        Actor margret = new Actor();
        margret.setName("Mary");
        // fill party with actors
        partyMembers.add(myron);
            myron.setHuntingSkill(25);
            myron.setGatheringSkill(15);
            myron.setMoney(600);
            myron.setStamina(90);
            myron.setHealth(60);
        partyMembers.add(mary);
            mary.setHuntingSkill(15);
            mary.setGatheringSkill(25);
            mary.setMoney(750);
            mary.setStamina(75);
            mary.setHealth(70);
        partyMembers.add(kevin);
            kevin.setHuntingSkill(20);
            kevin.setGatheringSkill(20);
            kevin.setMoney(700);
            kevin.setStamina(90);
            kevin.setHealth(80);
        partyMembers.add(bethany);
            bethany.setHuntingSkill(20);
            bethany.setGatheringSkill(30);
            bethany.setMoney(650);
            bethany.setStamina(70);
            bethany.setHealth(80);
        partyMembers.add(margret);
            margret.setHuntingSkill(25);
            margret.setGatheringSkill(15);
            margret.setMoney(700);
            margret.setStamina(90);
            margret.setHealth(80);
        partyMembers.add(dan);
            dan.setHuntingSkill(15);
            dan.setGatheringSkill(10);
            dan.setMoney(400);
            dan.setStamina(40);
            dan.setHealth(50);
        partyMembers.add(ricardo);
            ricardo.setHuntingSkill(20);
            ricardo.setGatheringSkill(25);
            ricardo.setMoney(700);
            ricardo.setStamina(70);
            ricardo.setHealth(70);
        partyMembers.add(steve);
            steve.setHuntingSkill(10);
            steve.setGatheringSkill(15);
            steve.setMoney(700);
            steve.setStamina(750);
            steve.setHealth(80);
        // set values
//        for (Actor actor : partyMembers) {
//            actor.setHuntingSkill(25);
//            actor.setGatheringSkill(15);
//            actor.setMoney(700);
//            actor.setStamina(80);
//            actor.setHealth(80);
//        }
        
        return partyMembers;
    }

    private ArrayList<Actor> partyMembers;
    private int partyMoney;
    private Wagon wagon;
    private int mapPositions;
    private ArrayList<Oxen> oxen;
    private int distanceTraveled;
    private PaceSpeed pace;

    public Party() {
    }

    public ArrayList<Actor> getPartyMembers() {
        return partyMembers;
    }

    public void setPartyMembers(ArrayList<Actor> partyMembers) {
        this.partyMembers = partyMembers;
    }

    public int getPartyMoney() {
        return partyMoney;
    }

    public void setPartyMoney(int partyMoney) {
        this.partyMoney = partyMoney;
    }

    public Wagon getWagon() {
        return wagon;
    }

    public void setWagon(Wagon wagon) {
        this.wagon = wagon;
    }

    public int getMapPositions() {
        return mapPositions;
    }

    public void setMapPositions(int mapPositions) {
        this.mapPositions = mapPositions;
    }

    public ArrayList<Oxen> getOxen() {
        return oxen;
    }

    public void setOxen(ArrayList<Oxen> oxen) {
        this.oxen = oxen;
    }
    
    public double calcOxenStrength() {
        double strengthTotal = 0;
        for (Oxen ox : this.oxen) {
            strengthTotal += ox.getStrength();
        }
        return strengthTotal;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public PaceSpeed getPace() {
        return pace;
    }

    public void setPace(PaceSpeed speed) {
        this.pace = speed;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.partyMembers);
        hash = 59 * hash + this.partyMoney;
        hash = 59 * hash + Objects.hashCode(this.wagon);
        hash = 59 * hash + this.mapPositions;
        hash = 59 * hash + Objects.hashCode(this.oxen);
        hash = 59 * hash + this.distanceTraveled;
        hash = 59 * hash + this.pace.getValue();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Party other = (Party) obj;
        if (this.partyMoney != other.partyMoney) {
            return false;
        }
        if (this.mapPositions != other.mapPositions) {
            return false;
        }
        if (this.distanceTraveled != other.distanceTraveled) {
            return false;
        }
        if (this.pace != other.pace) {
            return false;
        }
        if (!Objects.equals(this.partyMembers, other.partyMembers)) {
            return false;
        }
        if (!Objects.equals(this.wagon, other.wagon)) {
            return false;
        }
        if (!Objects.equals(this.oxen, other.oxen)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Party{" + "partyMembers=" + partyMembers + ", partyMoney=" + partyMoney + ", wagon=" + wagon + ", mapPositions=" + mapPositions + ", oxen=" + oxen + ", distanceTraveled=" + distanceTraveled + ", pace=" + pace + '}';
    }
}
