/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.GamePlay;
import java.util.ArrayList;
import javax.swing.plaf.metal.MetalLookAndFeel;
import model.Actor;
import model.Oxen;
import model.Party;
import model.Player;
import model.Supply;
import model.SupplyType;
import model.Wagon;

/**
 *
 * @author Myron Judkins
 */
public class DailyActivity extends MenuTools {

    private Party _party = null;

    public DailyActivity(Party party) {
        _party = party;
    }

    public void showDailyOptions() {
        boolean done = false;
        do {
            System.out.println(
                    "\n-----------------------------------------"
                    + "\n     Daily Menu"
                    + "\n-----------------------------------------"
                    + "\n"
                    + "\nPlease select from the following options:"
                    + "\n"
                    + "\nC: Continue Journey"
                    + "\nH: Help Menu"
                    + "\nP: Change Pace"
                    + "\nF: Change Food Rations"
                    + "\nR: Rest for a day"
                    + "\nS: Go Hunting"
                    + "\nG: Gather Food"
                    + "\nI: Inventory and Health"
                    + "\nM: View Map"
                    + "\nQ: Quit Game"
            );
            String menuOption = getMenuFeedback();
            if (menuOption.toLowerCase().equals("q")) {
                done = true;
            } else {
                done = doAction(menuOption);
            }

        } while (!done);
    }

    private Boolean doAction(String menuOption) {
        Boolean result = false;
        switch (menuOption.toLowerCase()) {
            case "c":
//                continueJourney();
                result = true;
                setDailyHealth();
                break;
            case "h":
           HelpMenu helpMenu = new HelpMenu();
                helpMenu.showHelpMenu();
                break;
            case "p":
//                changePace();
                break;
            case "f":
//                changeFoodRation();
                break;
            case "r":
//                restForDay();
                setDailyHealth();
                break;
            case "s":
//                goHunting();
                setDailyHealth();
                break;
            case "g":
//                gatherFood();
                setDailyHealth();

                break;
            case "i":
//                partyStatus();
                break;
            case "m":
//                viewMap();
                break;
            default:
                System.out.println("'" + menuOption + "' is not a menu option");
                break;
        }

        return result;
    }

    private void setDailyHealth() {
        GamePlay gamePlay = new GamePlay();
        for (int i = 0; i < _party.getPartyMembers().size(); i++) {
            Actor actor = _party.getPartyMembers().get(i);
            actor.setHealth((int) gamePlay.calculateDailyHealth(actor.getHealth(), actor.getStamina(), 2.5, 10));

        }
        System.out.println("Your Health and food has been updated for Today");
    }
}
