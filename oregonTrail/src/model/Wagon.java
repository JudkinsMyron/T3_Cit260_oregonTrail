/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
/**
 *
 * @author Myron Judkins
 */
public class Wagon implements Serializable{
   
    private String sizeDescription;
    private int carryingWeight;
    private boolean isBroken;
    private int wagonWeight;
    private ArrayList<Supply> supplies; 

    public Wagon() {
    }

    
    public String getSizeDescription() {
        return sizeDescription;
    }

    public void setSizeDescription(String sizeDescription) {
        this.sizeDescription = sizeDescription;
    }

    public int getCarryingWeight() {
        return carryingWeight;
    }

    public void setCarryingWeight(int carryingWeight) {
        this.carryingWeight = carryingWeight;
    }

    public boolean isIsBroken() {
        return isBroken;
    }

    public void setIsBroken(boolean isBroken) {
        this.isBroken = isBroken;
    }

    public int getWagonWeight() {
        return wagonWeight;
    }

    public void setWagonWeight(int wagonWeight) {
        this.wagonWeight = wagonWeight;
    }

    public ArrayList<Supply> getSupplies() {
        return supplies;
    }

    public void setSupplies(ArrayList<Supply> supplies) {
        this.supplies = supplies;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.sizeDescription);
        hash = 29 * hash + this.carryingWeight;
        hash = 29 * hash + (this.isBroken ? 1 : 0);
        hash = 29 * hash + this.wagonWeight;
        hash = 29 * hash + Objects.hashCode(this.supplies);
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
        final Wagon other = (Wagon) obj;
        if (this.carryingWeight != other.carryingWeight) {
            return false;
        }
        if (this.isBroken != other.isBroken) {
            return false;
        }
        if (this.wagonWeight != other.wagonWeight) {
            return false;
        }
        if (!Objects.equals(this.sizeDescription, other.sizeDescription)) {
            return false;
        }
        if (!Objects.equals(this.supplies, other.supplies)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Wagon{" + "sizeDescription=" + sizeDescription + ", carryingWeight=" + carryingWeight + ", isBroken=" + isBroken + ", wagonWeight=" + wagonWeight + ", supplies=" + supplies + '}';
    }
  
    
    
    
    
}
