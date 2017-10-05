package model;

import java.io.Serializable;
import java.util.Objects;

public class Actor implements Serializable{
    
    //Just testing
    
    //Class instance variables
    private String name;
    private int health;
    private int huntingSkill;
    private int gatheringSkill;
    private int money;
    private int stamina;

    public Actor() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHuntingSkill() {
        return huntingSkill;
    }

    public void setHuntingSkill(int huntingSkill) {
        this.huntingSkill = huntingSkill;
    }

    public int getGatheringSkill() {
        return gatheringSkill;
    }

    public void setGatheringSkill(int gatheringSkill) {
        this.gatheringSkill = gatheringSkill;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + this.health;
        hash = 67 * hash + this.huntingSkill;
        hash = 67 * hash + this.gatheringSkill;
        hash = 67 * hash + this.money;
        hash = 67 * hash + this.stamina;
        return hash;
    }

    @Override
    public String toString() {
        return "Actor{" + "name=" + name + ", health=" + health + ", huntingSkill=" + huntingSkill + ", gatheringSkill=" + gatheringSkill + ", money=" + money + ", stamina=" + stamina + '}';
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
        final Actor other = (Actor) obj;
        if (this.health != other.health) {
            return false;
        }
        if (this.huntingSkill != other.huntingSkill) {
            return false;
        }
        if (this.gatheringSkill != other.gatheringSkill) {
            return false;
        }
        if (this.money != other.money) {
            return false;
        }
        if (this.stamina != other.stamina) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
}
