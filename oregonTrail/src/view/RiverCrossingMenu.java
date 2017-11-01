/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.RiverCrossing;
import model.Party;
import model.Supply;
import model.SupplyType;

/**
 *
 * @author Kevin's Account
 */
public class RiverCrossingMenu extends MenuTools {

    private Party _party = null;

    RiverCrossingMenu(Party party) {
        _party = party;
    }

    public void startRiverCrossing() {
        displayBanner();
        showOptions();
    }

    private void displayBanner() {
        System.out.println(
                "\n********************************"
                + "\n*                              *"
                + "\n*     As you walk along,       *"
                + "\n*     you hear the sound       *"
                + "\n*     of water. You realize    *"
                + "\n*     you are coming up on     *"
                + "\n*     a river.                 *"
                + "\n*                              *"
                + "\n********************************"
        );
    }

    private void showOptions() {
        boolean done = false;
        RiverCrossing riverCrossing = new RiverCrossing();

        do {
            System.out.println(
                    "\n-----------------------------------------"
                    + "\n     River Crossing"
                    + "\n-----------------------------------------"
                    + "\n"
                    + "\nThe river right now is " + round(riverCrossing.getRiverDepth(), 2) + " feet deep."
                    + "\nWhat do you do?"
                    + "\n"
                    + "\nC: Cross the River"
                    + "\nD: Drop supplies"
                    + "\nG: Go back and wait for the river to change"
            );
            String input = getMenuFeedback();
            switch (input.toLowerCase()) {
                case "c":
                    done = attemptToCrossTheRiver(riverCrossing);
                    break;
                case "d":
                    dropSupplies(riverCrossing);
                    break;
                case "g":
                    System.out.println("You go back to camp and wait");
                    riverCrossing.setRiverDepth(0);
                    break;
                default:
                    System.out.println("'" + input + "' is not a menu option");
                    break;
            }
        } while (!done);
    }

    private boolean attemptToCrossTheRiver(RiverCrossing riverCrossing) {
        int result = riverCrossing.calculateRiverCrossSuccess(_party.getWagon().getWagonWeight(), _party.calcOxenStrength());
        boolean success = false;
        switch (result) {
            case -1:
                System.out.println("Wagon weight cannot be negative");
                break;
            case -2:
                System.out.println("Oxen strength cannot be negative");
                break;
            case -3:
                System.out.println("River depth cannot be negative");
                break;
            case 0:
                System.out.println("You didn't cross the river successfully!");
                break;
            case 1:
                System.out.println("You made it across the river safely");
                success = true;
                break;
            default:
                System.out.println("Something went wrong, you shouldn't be seeing this...");
                break;
        }
        return success;
    }

    private void dropSupplies(RiverCrossing riverCrossing) {
        boolean validInput = false;
        SupplyType supplyType = null;
        double amountToDrop = 0;
        double currentAmount = 0;
        do {
            System.out.println(
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
                System.out.println("That was not a valid input");
            }

        } while (!validInput);

        for (Supply supply : _party.getWagon().getSupplies()) {
            if (supply.getType().equals(supplyType)) {
                currentAmount = supply.getAmount();
            }
        }

        do {
            System.out.println(
                    "\n"
                    + "\nYou currently have " + currentAmount + " " + supplyType
                    + "\n"
                    + "\nHow much would you like to drop? (enter '0' to return to menu)"
            );
            String input = getPlayerFeedback();

            try {
                amountToDrop = Integer.parseInt(input);
                validInput = true;
            } catch (Exception e) {
                validInput = false;
            }
            if (validInput) {
                double result = riverCrossing.dropSupplies(_party.getWagon(), supplyType, amountToDrop);
                int intChecker = (int) result;
                switch (intChecker) {
                    case -1:
                        System.out.println("No supply of that type found");
                        break;
                    case -2:
                        System.out.println("You don't have that much to drop");
                        break;
                    case -3:
                        System.out.println("You can't drop a negative amount of supplies, nice try");
                        break;
                    default:
                        System.out.println("\n" + "\nYou dropped " + amountToDrop + " of "
                                + supplyType + " and now have " + result + " remaining");
                        break;
                }
            } else {
                System.out.println("That was not a valid input");
            }
        } while (!validInput);

    }
}
