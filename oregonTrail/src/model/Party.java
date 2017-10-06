package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
/**
 *
 * @author Kevin's Account
 */
public class Party implements Serializable{
    
    private ArrayList<Actor> partyMembers;
    private int partyMoney;
    //private Wagon wagon;
    private int mapPositions;
    //private ArrayList<Oxen> oxen;
    private int distanceTraveled;
    private int pace;

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
/*
    public Wagon getWagon() {
        return wagon;
    }

    public void setWagon(Wagon wagon) {
        this.wagon = wagon;
    }
*/
    public int getMapPositions() {
        return mapPositions;
    }

    public void setMapPositions(int mapPositions) {
        this.mapPositions = mapPositions;
    }
/*
    public ArrayList<Oxen> getOxen() {
        return oxen;
    }

    public void setOxen(ArrayList<Oxen> oxen) {
        this.oxen = oxen;
    }
*/
    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public int getPace() {
        return pace;
    }

    public void setPace(int pace) {
        this.pace = pace;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.partyMembers);
        hash = 59 * hash + this.partyMoney;
  //      hash = 59 * hash + Objects.hashCode(this.wagon);
        hash = 59 * hash + this.mapPositions;
    //    hash = 59 * hash + Objects.hashCode(this.oxen);
        hash = 59 * hash + this.distanceTraveled;
        hash = 59 * hash + this.pace;
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
      /*  if (!Objects.equals(this.wagon, other.wagon)) {
            return false;
        }
        if (!Objects.equals(this.oxen, other.oxen)) {
            return false;
        }*/
        return true;
    }

    @Override
    public String toString() {
        return "Party{" + "partyMembers=" + partyMembers + ", partyMoney=" + partyMoney + /*", wagon=" + wagon +*/ ", mapPositions=" + mapPositions /*+ ", oxen=" + oxen*/ + ", distanceTraveled=" + distanceTraveled + ", pace=" + pace + '}';
    }
}
