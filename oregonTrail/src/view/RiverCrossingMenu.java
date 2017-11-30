/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.RiverCrossing;
import exceptions.RiverCrossingException;
import model.Party;
import model.Supply;
import model.SupplyType;

/**
 *
 * @author Kevin's Account
 */
public class RiverCrossingMenu extends View {

    private Party _party = null;
    private RiverCrossing _riverCrossing = null;

    RiverCrossingMenu(Party party, RiverCrossing riverCrossing) {
        super("\n********************************"
                + "\n*                              *"
                + "\n*     As you walk along,       *"
                + "\n*     you hear the sound       *"
                + "\n*     of water. You realize    *"
                + "\n*     you are coming up on     *"
                + "\n*     a river.                 *"
                + "\n*                              *"
                + "\n********************************"
                + "\n"
                + "\n"
                + "\n"
                + "\n-----------------------------------------"
                + "\n     River Crossing"
                + "\n-----------------------------------------"
                + "\n"
                + "\nThe river right now is " + round(riverCrossing.getRiverDepth(), 1) + " feet deep."
                + "\nWhat do you do?"
                + "\n"
                + "\nC: Cross the River"
                + "\nD: Drop supplies"
                + "\nG: Go back and wait for the river to change");
        _party = party;
        _riverCrossing = riverCrossing;
    }

    @Override
    public boolean doAction(String input) {
        boolean done = false;
        switch (input.toLowerCase()) {
            case "c":
                done = attemptToCrossTheRiver(_riverCrossing);
                break;
            case "d":
                dropSupplies(_riverCrossing);
                break;
            case "g":
                this.console.println("You go back to camp and wait");
                _riverCrossing.setRiverDepth(0);
                break;
        }
        return done;
    }

    private boolean attemptToCrossTheRiver(RiverCrossing riverCrossing) {
        int result = 2;
        try {
            result = riverCrossing.calculateRiverCrossSuccess(_party.getWagon().getWagonWeight(), _party.calcOxenStrength());
        } catch (RiverCrossingException rce) {
            ErrorView.display(this.getClass().getName(),rce.getMessage());
        }
        boolean success = false;
        switch (result) {

            case 0:
                this.console.println("You didn't cross the river successfully!");
                break;
            case 1:
                this.console.println("You made it across the river safely");
                success = true;
                break;

        }
        waitForEnterKey();

        return success;
    }

    private void dropSupplies(RiverCrossing riverCrossing) {
        boolean validInput = false;
        SupplyType supplyType = null;
        double amountToDrop = 0;
        double currentAmount = 0;
        while (!validInput) {
            this.console.println(
                    "\n"
                    + "\nWhat type of supplies would you like to drop?"
                    + "\n"
                    + "\nW: Wagon Wheels"
                    + "\nF: Food"
            );

            String input = getMenuFeedback();
            if (input.toLowerCase().equals("w")) {
                supplyType = SupplyType.WAGON_WHEELS;
                validInput = true;
            } else if (input.toLowerCase().equals("f")) {
                supplyType = SupplyType.FOOD;
                validInput = true;
            } else {
                this.console.println("That was not a valid input");
            }

        };

        for (Supply supply : _party.getWagon().getSupplies()) {
            if (supply.getType().equals(supplyType)) {
                currentAmount = supply.getAmount();
            }
        }

        this.console.println(
                "\n"
                + "\nYou currently have " + currentAmount + " " + supplyType
                + "\n"
                + "\nHow much would you like to drop? (enter '0' to return to menu)"
        );
        amountToDrop = getIntFromString();

        double result = riverCrossing.dropSupplies(_party.getWagon(), supplyType, amountToDrop);
        int intChecker = (int) result;
        switch (intChecker) {
            case -1:
                this.console.println("No supply of that type found");
                break;
            case -2:
                this.console.println("You don't have that much to drop");
                break;
            case -3:
                this.console.println("You can't drop a negative amount of supplies, nice try");
                break;
            default:
                this.console.println("\n" + "\nYou dropped " + amountToDrop + " of "
                        + supplyType + " and now have " + result + " remaining");
                break;
        }
        waitForEnterKey();
    }
}
