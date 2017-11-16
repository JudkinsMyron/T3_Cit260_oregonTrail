/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.GamePlay;
import control.MapControl;
import java.util.ArrayList;
import javax.swing.plaf.metal.MetalLookAndFeel;
import model.Actor;
import model.Oxen;
import model.Party;
import model.Player;
import model.Supply;
import model.SupplyType;
import model.Wagon;
import static view.MenuTools.waitForEnterKey;

/**
 *
 * @author Myron Judkins
 */
public class DailyActivity extends View {

    private Party _party = null;

    public DailyActivity(Party party) {
        super("\n-----------------------------------------"
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
                + "\nQ: Quit Game");
        _party = party;
    }

    @Override
    public boolean doAction(String menuOption) {
        Boolean result = false;
        switch (menuOption.toLowerCase()) {
            case "c":
                continueJourney();
                result = true;
                setDailyHealth();
                break;
            case "h":
                HelpMenu helpMenu = new HelpMenu(_party);
                helpMenu.display();
                break;
            case "p":
                changePace();
                break;
            case "f":
                changeFoodRation();
                break;
            case "r":
                restForDay();
                setDailyHealth();
                break;
            case "s":
                goHunting();
                setDailyHealth();
                break;
            case "g":
                gatherFood();
                setDailyHealth();
                break;
            case "i":
                partyStatus();
                break;
            case "m":
                viewMap();
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

    private void continueJourney() {
    _party.setMapPositions(_party.getMapPositions() + 1);
    }

    private void changePace() {
        TeamPaceMenu tpm = new TeamPaceMenu(_party);
        tpm.display();
    }

    private void changeFoodRation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void restForDay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void goHunting() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void gatherFood() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void partyStatus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void viewMap() {
       MapControl mapControl = new MapControl();
        
        mapControl.printMap(_party);
        waitForEnterKey();
    }

}
