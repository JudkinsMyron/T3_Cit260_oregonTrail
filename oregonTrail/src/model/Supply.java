/*
 * This file is part of an independent project and must not be 
 * copyied without authorization.
 */
package model;

import java.util.Objects;

/**
 *
 * @author Dan Ortega
 */
public class Supply {
    
    private SupplyType type;
    private double amount;

    
    public Supply() {
    }

    public SupplyType getType() {
        return type;
    }

    public void setType(SupplyType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.type);
        hash = (int) (83 * hash + this.amount);
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
        final Supply other = (Supply) obj;
        if (this.amount != other.amount) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Supply{" + "type=" + type + ", amount=" + amount + '}';
    }
    
    
}
