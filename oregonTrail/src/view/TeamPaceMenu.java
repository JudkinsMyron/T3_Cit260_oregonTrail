/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.PaceSpeed;
import model.Party;

/**
 *
 * @author Kevin's Account
 */
class TeamPaceMenu extends View {

    private Party _party = null;

    TeamPaceMenu(Party party) {
        super("\n"
                + "\n-----------------------------------------"
                + "\n     Team Pace"
                + "\n-----------------------------------------"
                + "\n"
                + "\nF: Change the party pace to fast"
                + "\nM: Change the party pace to medium"
                + "\nS: Change the party pace to slow"
                + "\nQ: Go back to the previous menu");
        _party = party;
    }

    @Override
    public boolean doAction(String input) {
        switch (input.toLowerCase()) {
            case "f":
                _party.setPace(PaceSpeed.FAST);
                break;
            case "m":
                _party.setPace(PaceSpeed.MEDIUM);
                break;
            case "s":
                _party.setPace(PaceSpeed.SLOW);
                break;
        }
        this.console.println("Your team pace is now " + getPaceString(_party));
        waitForEnterKey();
        return false;
    }

    private static String getPaceString(Party party) {
        if (party.getPace().equals(PaceSpeed.FAST)) {
            return "fast";
        } else if (party.getPace().equals(PaceSpeed.MEDIUM)) {
            return "medium";
        } else if (party.getPace().equals(PaceSpeed.SLOW)) {
            return "slow";
        } else {
            return "broken...";
        }
    }

}
