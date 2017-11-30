/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.GamePlay;
import model.Party;

/**
 *
 * @author Myron's Account
 */
public class HelpMenu extends View {

    private Party _party = null;

    public HelpMenu(Party party) {
        super("\n"
                + "\n  ****  Help Menu   ****"
                + "\nD: See help items for daily travel"
                + "\nT: See help items when you are at a Town or Fort"
                + "\nH: See what items affect your health"
                + "\nP: Print your parties health and stats"
                + "\nQ: Return to previous menu"
                + "\n");
        _party = party;

    }

    @Override
    public boolean doAction(String input) {
        GamePlay gamePlay = new GamePlay();
        if (input.toLowerCase().equals("d")) {
            this.console.println(
                    "\n"
                    + "\n To continue travel you move along at your set pace"
                    + "\n Your Party will move forward, and consume food, and depending"
                    + "\n on conditions you may gain or loose health."
                    + "\n From the Daily Menu you may choose to Hunt for food, or gather food"
                    + "\n to increase food stores. You can also change your pace of travel"
                    + "\n or increase or decrease your food rations. Average people consume "
                    + "\n 2.5 lbs per day. More food and less travel  makes you healthier "
                    + "\n but slower."
                    + "\n ** PRESS Q to return to your game."
            );
        } else if (input.toLowerCase().equals("t")) {
            this.console.println(
                    "\n"
                    + "\n When you come to a Town or Fort you have the opportunity "
                    + "\n to purchase needed supplies at the General Store or Trading Post."
                    + "\n You may also recruit new members to your Party if any have died by"
                    + "\n visiting the Hotel. You may want to recruit those with strengths"
                    + "\n your party needs, or cash to bolster the party money."
                    + "\n ** PRESS Q to return to your game."
            );
        } else if (input.toLowerCase().equals("h")) {
            this.console.println(
                    "\n"
                    + "\n People with higher Stamina recover more quickly, but require "
                    + "\n more food to stay healthy. As you eat more and travel less you"
                    + "\n also gain health. Long days and short (or No) rations will deplete"
                    + "\n Your health, when you reach zero you are dead. Health is 0 to 100"
                    + "\n Right now your average party health is " + gamePlay.calculateAverageStrength(_party)
                    + "\n ** PRESS Q to return to your game."
            );
        } else if (input.toLowerCase().equals("p")) {
            this.console.println("\n \nEnter the file path where the report is to be saved: ");
        String filePath = this.getPlayerFeedback();
        try {
            boolean success = gamePlay.printPartyHealthReport(_party, filePath);
            if (success) {
                this.console.println("The report was successfully printed to '" + filePath + "'");
                waitForEnterKey();
            }
        } catch (Exception ex) {
            ErrorView.display("HelpMenu", ex.getMessage());
        }
        }
        return false;
    }
}
