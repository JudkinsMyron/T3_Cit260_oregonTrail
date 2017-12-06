/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import model.FoodRation;
import model.Party;

/**
 *
 * @author Kevin's Account
 */
class FoodRationMenu extends View {

    private Party _party = null;

    FoodRationMenu(Party party) {
        super("\n"
                + "\n-----------------------------------------"
                + "\n     Ration Size"
                + "\n-----------------------------------------"
                + "\n"
                + "\nL: Change the ration size to large"
                + "\nM: Change the ration size to medium"
                + "\nS: Change the ration size to small"
                + "\nQ: Go back to the previous menu");
        _party = party;
    }

    @Override
    public boolean doAction(String input) {
        switch (input.toLowerCase()) {
            case "l":
                _party.setRation(FoodRation.LARGE);
                break;
            case "m":
                _party.setRation(FoodRation.MEDIUM);
                break;
            case "s":
                _party.setRation(FoodRation.SMALL);
                break;
        }
        this.console.println("Your daily food ration is now " + getFoodRationString(_party));
        waitForEnterKey();
        return false;
    }

    private static String getFoodRationString(Party party) {
        if (party.getRation().equals(FoodRation.LARGE)) {
            return "large";
        } else if (party.getRation().equals(FoodRation.MEDIUM)) {
            return "medium";
        } else if (party.getRation().equals(FoodRation.SMALL)) {
            return "small";
        } else {
            return "broken...";
        }
    }

}
