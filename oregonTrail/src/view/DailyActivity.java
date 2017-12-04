/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.GamePlay;
import control.MapControl;
import control.RiverCrossing;
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
    private Player _player = null;
    private Party _party = null;
    
    public Player getPlayer() {
        return _player;
    }

    public void setParty(Party party) {
        _party = party;
    }

    public Party getParty() {
        return _party;
    }

    public DailyActivity(Player player) {
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
                + "\nT: Save the Game"
                + "\nQ: Quit Game");
        _party = player.getParty();
        _player = player;
    }

    @Override
    public boolean doAction(String menuOption) {
        Boolean result = false;
        GamePlay gamePlay = new GamePlay();
        switch (menuOption.toLowerCase()) {
            case "c":
                result = continueJourney();
                
                 {
                    try {
                        String dailyHealthMessage = gamePlay.setDailyHealth(_party);
                        this.console.println(dailyHealthMessage);
                        waitForEnterKey();
                    } catch (DailyHealthException ex) {
                        ErrorView.display(this.getClass().getName(),ex.getMessage());
                        this.console.println("Major Error Found in setDailyHealth");
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
                        String dailyHealthMessage = gamePlay.setDailyHealth(_party);
                        this.console.println(dailyHealthMessage);
                        waitForEnterKey();
                    } catch (DailyHealthException ex) {
                        ErrorView.display(this.getClass().getName(),ex.getMessage());
                        this.console.println("Major Error Found in setDailyHealth");
                    }
                }
                break;
            case "s":
                goHunting();
                 {
                    try {
                        String dailyHealthMessage = gamePlay.setDailyHealth(_party);
                        this.console.println(dailyHealthMessage);
                        waitForEnterKey();
                    } catch (DailyHealthException ex) {
                        ErrorView.display(this.getClass().getName(),ex.getMessage());
                        this.console.println("Major Error Found in setDailyHealth");
                    }
                }
                break;
            case "g":
                gatherFood();
                 {
                    try {
                        String dailyHealthMessage = gamePlay.setDailyHealth(_party);
                        this.console.println(dailyHealthMessage);
                        waitForEnterKey();
                    } catch (DailyHealthException ex) {
                        ErrorView.display(this.getClass().getName(),ex.getMessage());
                        this.console.println("Major Error Found in setDailyHealth");
                    }
                }
                break;
            case "i":
                partyStatus();
                break;
            case "m":
                viewMap();
                break;
            case "t":
                saveGame();
                break;
            default:
                this.console.println("'" + menuOption + "' is not a menu option");
                break;
        }

        return result;
    }

    private boolean continueJourney() {
        MapControl mapControl = new MapControl();
        boolean endGame = false;
        switch(mapControl.getNextSceneType(_party)){
            case FORT:
                FortMenu fortMenu = new FortMenu(_party);
                fortMenu.display();
                break;
            case RIVER:
                RiverCrossing rc = new RiverCrossing();
                RiverCrossingMenu rcm = new RiverCrossingMenu(_party,rc);
                rcm.display();
                break;    
            case TRAIL:
                this.console.println("You have spent an uneventful day of travel");
                waitForEnterKey();
                break; 
             case TOWN:
                this.console.println("You passed a town but found no services that you need");
                waitForEnterKey();
                break; 
             case OREGON:
                this.console.println("You can rest, you are here!");
                waitForEnterKey();
                endGame = true;
                break;    
        }
        _party.setMapPositions(_party.getMapPositions() + 1);
        return endGame;
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
        try {
            String message = trailStop.goHunting(_party);
            this.console.println(message);
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), e.getMessage());
        }
    }

    private void gatherFood() {
        TrailStop trailStop = new TrailStop();
        try {
            String message = trailStop.lookForPlants(_party);
            this.console.println(message);
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), e.getMessage());
        }
    }

    private void partyStatus() {
                   this.console.println("\n  Print an inventory list to a file"
                    + "\n Enter the file path where the inventory is to be saved: ");
        String filePath = this.getPlayerFeedback();
        try {
            GamePlay.printInventory(_party.getWagon().getSupplies(), filePath);
            this.console.println("\n  File Created Successfully ");
            waitForEnterKey();
        } catch (Exception ex) {
            ErrorView.display("DailyActivity Printing Inventory", ex.getMessage());
        }
    
    }

    private void viewMap() {
        Map map = new Map(_party);
    }

    private void saveGame() {
        this.console.println("\n \n Enter the file path where the game is to be saved: ");
        String filePath = this.getPlayerFeedback();
        try {
            GamePlay.saveGame(getPlayer(), filePath);
        } catch (Exception ex) {
            ErrorView.display("DailyActivity", ex.getMessage());
        }
    }

}
