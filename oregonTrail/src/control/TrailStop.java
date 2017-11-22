/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import exceptions.TrailStopException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import model.Actor;
import model.Party;
import model.Supply;
import model.SupplyType;
import view.View;

/**
 *
 * @author Kevin's Account
 */
public class TrailStop {

    public boolean calcHuntingSuccess(Party party) throws TrailStopException {
        ArrayList<Actor> partyMembers = party.getPartyMembers();
        double totalSkill = 0;
        for (Actor actor : partyMembers) {
            if (actor.getStamina() > 0) {
                totalSkill += actor.getHuntingSkill();
            }
        }
        if (totalSkill < 0) {
            throw new TrailStopException("The hunting skill was below 0");
        }
        double random = ThreadLocalRandom.current().nextDouble(0, 100);
        boolean success = (totalSkill * random > 50);
        return success;
    }

    public boolean calcGatheringSuccess(Party party) throws TrailStopException {
        ArrayList<Actor> partyMembers = party.getPartyMembers();
        double totalSkill = 0;
        for (Actor actor : partyMembers) {
            if (actor.getStamina() > 0) {
                totalSkill += actor.getGatheringSkill();
            }
        }
        if (totalSkill < 0) {
            throw new TrailStopException("The gathering skill was below 0");
        }
        double random = ThreadLocalRandom.current().nextDouble(1, 100);
        boolean success = (totalSkill * random > 30);
        return success;
    }

    public void goHunting(Party party) {
        boolean success = false;
        try {
            success = calcHuntingSuccess(party);
        } catch (TrailStopException tse) {
            System.out.println(tse.getMessage());
        }

        if (success) {
            adjustSuppliesFromSuccess(party);
        }
    }

    private void adjustSuppliesFromSuccess(Party party) {
        double foodToAdd = ThreadLocalRandom.current().nextDouble(1, 20);
        for (Supply supply : party.getWagon().getSupplies()) {
            if (supply.getType() == SupplyType.FOOD) {
                double currentSupplyAmount = supply.getAmount();
                double adjustedSupplyAmount = currentSupplyAmount + foodToAdd;
                boolean weightCheckResult = false;
                try {
                    weightCheckResult = weightCheck(party.getWagon().getCarryingWeight(),
                            party.getWagon().getWagonWeight(),
                            supply.getType(),
                            foodToAdd);

                } catch (TrailStopException tse) {
                    System.out.println(tse.getMessage());
                }

                if (weightCheckResult) {
                    supply.setAmount(adjustedSupplyAmount);
                    System.out.println("You were successful! You now have " + supply.getAmount() + " " + supply.getType());
                    View.waitForEnterKey();
                } else {
                    System.out.println("You found food, but were unable to store it anywhere");
                    View.waitForEnterKey();
                }
            }
        }
    }

    public boolean lookForPlants(Party party) {
        boolean success = false;
        try {
            success = calcGatheringSuccess(party);
        } catch (TrailStopException tse) {
            System.out.println(tse.getMessage());
        }

        if (success) {
            adjustSuppliesFromSuccess(party);
        }
        return success;
    }

    private boolean weightCheck(double carryingWeight, double wagonWeight, SupplyType supplyType, double supplyAmountChange) throws TrailStopException {
        if (checkForBadSupplyType(supplyType)) {
            throw new TrailStopException("Bad supply type");
        }
        if (carryingWeight < 0) {
            throw new TrailStopException("Carrying weight cannot be negative");
        }
        if (wagonWeight < 0) {
            throw new TrailStopException("Wagon weight cannot be negative");
        }
        double weightToAdd = 0;
        if (supplyType == SupplyType.WAGON_WHEELS) {
            weightToAdd = 10 * supplyAmountChange;
        }
        if (supplyType == SupplyType.FOOD) {
            weightToAdd = 1 * supplyAmountChange;
        }
        return (weightToAdd + wagonWeight < carryingWeight);
    }

    private boolean checkForBadSupplyType(SupplyType supplyType) {
        return (!supplyType.equals(SupplyType.WAGON_WHEELS) && !supplyType.equals(SupplyType.FOOD));
    }
}
