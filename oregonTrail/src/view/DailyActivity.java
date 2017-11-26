/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.GamePlay;
import control.MapControl;
import control.TrailStop;
import exceptions.DailyHealthException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        GamePlay gamePlay = new GamePlay();
        switch (menuOption.toLowerCase()) {
            case "c":
                continueJourney();
                result = true;
                 {
                    try {
                        gamePlay.setDailyHealth(_party);
                    } catch (DailyHealthException ex) {
                        Logger.getLogger(DailyActivity.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("Major Error Found in setDailyHealth");
                        break;
                    }
                }
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
                 {
                    try {
                        gamePlay.setDailyHealth(_party);
                    } catch (DailyHealthException ex) {
                        Logger.getLogger(DailyActivity.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("Major Error Found in setDailyHealth");
                    }
                }
                break;
            case "s":
                goHunting();
                 {
                    try {
                        gamePlay.setDailyHealth(_party);
                    } catch (DailyHealthException ex) {
                        Logger.getLogger(DailyActivity.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("Major Error Found in setDailyHealth");
                    }
                }
                break;
            case "g":
                gatherFood();
                 {
                    try {
                        gamePlay.setDailyHealth(_party);
                    } catch (DailyHealthException ex) {
                        Logger.getLogger(DailyActivity.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("Major Error Found in setDailyHealth");
                    }
                }
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
        TrailStop trailStop = new TrailStop();
        trailStop.goHunting(_party);
    }

    private void gatherFood() {
        TrailStop trailStop = new TrailStop();
        trailStop.lookForPlants(_party);
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
