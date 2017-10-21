/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import model.Actor;
import model.Party;
import model.Supply;

/**
 *
 * @author Kevin's Account
 */
public class TrailStop {
    
    public double calcHuntingSuccess(Party party) {
        ArrayList<Actor> partyMembers = party.getPartyMembers();
        double totalSkill = 0;
        for (Actor actor : partyMembers) {
            if (actor.getStamina() > 0) {
                totalSkill += actor.getHuntingSkill();
            }
        }
        if (totalSkill < 0) {
            return -1;
        }
        double random = ThreadLocalRandom.current().nextDouble(0, 100);
        boolean success = (totalSkill * random > 50);
        if (success) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public double calcGatheringSuccess(Party party) {
        ArrayList<Actor> partyMembers = party.getPartyMembers();
        double totalSkill = 0;
        for (Actor actor : partyMembers) {
            if (actor.getStamina() > 0) {
                totalSkill += actor.getGatheringSkill();
            }
        }
        if (totalSkill < 0) {
            return -1;
        }
        double random = ThreadLocalRandom.current().nextDouble(1, 100);
        boolean success = (totalSkill * random > 30);
        if (success) {
            return 1;
        } else {
            return 0;
        }
    }

    public double goHunting(Party party) {
        double success = calcHuntingSuccess(party);
        if (success == -1) {
            System.out.println("Hunting skill cannot be negative");
        } else if (success == 0) {
            return 0;
        } else if ( success == 1) {
            double foodToAdd = ThreadLocalRandom.current().nextDouble(1, 20);
            for (Supply supply : party.getWagon().getSupplies()) {
                if (supply.getType().equals("Food")) {
                    double currentSupplyAmount = supply.getAmount();
                    double adjustedSupplyAmount = currentSupplyAmount + foodToAdd;
                    double result = weightCheck(party.getWagon().getCarryingWeight(), 
                            party.getWagon().getWagonWeight(), 
                            supply.getType(), 
                            foodToAdd);
                    if (result == 1) {
                        supply.setAmount(adjustedSupplyAmount);
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        }
        return 0;
    }
    
    public double lookForPlants(Party party) {
        double success = calcGatheringSuccess(party);
        if (success == -1) {
            System.out.println("Gathering skill cannot be negative");
        } else if (success == 0) {
            return 0;
        } else if ( success == 1) {
            double foodToAdd = ThreadLocalRandom.current().nextDouble(1, 10);
            for (Supply supply : party.getWagon().getSupplies()) {
                if (supply.getType().equals("Food")) {
                    double currentSupplyAmount = supply.getAmount();
                    double adjustedSupplyAmount = currentSupplyAmount + foodToAdd;
                    double result = weightCheck(party.getWagon().getCarryingWeight(), 
                            party.getWagon().getWagonWeight(), 
                            supply.getType(), 
                            foodToAdd);
                    if (result == 1) {
                        supply.setAmount(adjustedSupplyAmount);
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        }
        return 0;
    }

    private double weightCheck(double carryingWeight, double wagonWeight, String supplyType, double supplyAmountChange) {
        if (checkForBadSupplyType(supplyType)) {
            return -1;
        }
        if (carryingWeight < 0) {
            return -2;
        }
        if (wagonWeight < 0) {
            return -3;
        }
        double weightToAdd = 0;
        if (supplyType.equals("Wagon Wheels")) {
            weightToAdd = 10 * supplyAmountChange;
        }
        if (supplyType.equals("Food")) {
            weightToAdd = 1 * supplyAmountChange;
        }
        if (weightToAdd + wagonWeight > carryingWeight) {
            return 0;
        } else {
            return 1;
        }
    }
    private boolean checkForBadSupplyType(String supplyType) {
        return (!supplyType.equals("Wagon Wheels") && !supplyType.equals("Food"));
    }
}
