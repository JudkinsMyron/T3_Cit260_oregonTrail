/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author Myron Judkins
 */
public class Oxen implements Serializable {
   // class instance variables
   private int strength;

    public Oxen() {
    }

    
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.strength;
        return hash;
    }

    @Override
    public String toString() {
        return "Oxen{" + "strength=" + strength + '}';
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
        final Oxen other = (Oxen) obj;
        if (this.strength != other.strength) {
            return false;
        }
        return true;
    }
 
    
   
}
