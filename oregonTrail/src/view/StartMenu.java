/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.RiverCrossing;
import control.StartController;
import java.util.ArrayList;
import model.Actor;
import model.Oxen;
import model.PaceSpeed;
import model.Party;
import model.Player;
import model.Supply;
import model.SupplyType;
import model.Wagon;

/**
 *
 * @author Kevin's Account
 */
public class StartMenu extends View {

    public StartMenu() {
        super("\n-----------------------------------------"
                    + "\n     Main Menu"
                    + "\n-----------------------------------------"
                    + "\n"
                    + "\nPlease select from the following options:"
                    + "\n"
                    + "\nS: Start New Game"
                    + "\nH: Help Menu"
                    + "\nL: Load Game"
                    + "\nQ: Quit Game");
    }

    public void startGame() {
        displayBanner();
        display();
    }

    private void displayBanner() {
        System.out.println(
                "\n********************************"
                + "\n*                              *"
                + "\n*   Welcome to Oregon Trail    *"
                + "\n*      By Myron and Kevin      *"
                + "\n*                              *"
                + "\n*   You will travel to Oregon  *"
                + "\n*   across the United States.  *"
                + "\n*   You and your team will try *"
                + "\n*   to survive as you trek     *"
                + "\n*   across America. Good luck. *"
                + "\n*                              *"
                + "\n********************************"
        );
    }

    @Override
    public boolean doAction(String input) {
            switch (input.toLowerCase()) {
                case "s":
                    StartController startController = new StartController();
                    Party party = startController.partyCreation();
                    // for test only
                    forTestOnly(party);
                                 
                    break;
                case "l":
                    loadGame();
                    break;
                case "h":
                    showHelpMenu();
                    break;
            }
        return false;
    }

    
    private void loadGame() {
        System.out.println("The load game funtion will go here...");
    }

    private void showHelpMenu() {
        System.out.println(
                "\n-----------------------------------------"
                + "\n     Help Menu"
                + "\n-----------------------------------------"
                + "\n"
                + "\nSelecting 'Start New Game' will create a new game with a"
                + "\nnew party"
                + "\n"
                + "\nSelecting 'Load Game' will load a your previous game"
                + "\n"
                + "\nQuiting the game will exit this application...don't go yet!"
                + "\n"
                + "\nPress the Enter key to return to the menu..."
        );
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
    private void forTestOnly(Party party){
        // this is for testing purposes only
        DailyActivity dailyActivity = new DailyActivity(party);
        dailyActivity.display();
        // this is for testing purposes only
        RiverCrossing riverCrossing = new RiverCrossing();
        RiverCrossingMenu rcm = new RiverCrossingMenu(party, riverCrossing);
        rcm.display();
        // Visit the Fort
        FortMenu fortMenu = new FortMenu(party);
        fortMenu.display();
        dailyActivity.display();
    }
   

}
