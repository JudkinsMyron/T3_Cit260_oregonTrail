/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import model.Actor;
import model.Oxen;
import model.PaceSpeed;
import model.Party;
import model.Player;
import model.Supply;
import model.SupplyType;
import model.Wagon;
import view.DailyActivity;
import view.FortMenu;
import static view.MenuTools.getMenuFeedback;
import static view.MenuTools.getPlayerFeedback;
import view.RiverCrossingMenu;

/**
 *
 * @author Myron Judkins
 */
public class StartController {

    public Party partyCreation() {
        System.out.println("Please input a name for your character:");
        String input = getPlayerFeedback();
        // create player
        Player player = new Player();
        player.setName(input);
        Party party = new Party();
        // create main character
        Actor mainCharacter = new Actor();
        mainCharacter.setName(input);
        mainCharacter.setGatheringSkill(15);
        mainCharacter.setHealth(80);
        mainCharacter.setHuntingSkill(25);
        mainCharacter.setMoney(700);
        mainCharacter.setStamina(80);
        // create party
        ArrayList<Actor> starterCharacters = new ArrayList<>();
        starterCharacters.add(mainCharacter);
        starterCharacters.add(party.getPremadeCharacters().get(0));
        starterCharacters.add(party.getPremadeCharacters().get(1));
        starterCharacters.add(party.getPremadeCharacters().get(2));
        party.setPartyMembers(starterCharacters);
        // set money
        int money = 0;
        for (Actor actor : starterCharacters) {
            money += actor.getMoney();
        }
        party.setPartyMoney(money);
        // show the current state of the party
        showPartyInformation(party);
        // set wagon
        chooseWagon(party);
        // buy supplies
        buySupplies(party);
        // set wagon weight
        party.getWagon().setWagonWeight(2000);
        // set oxen
        ArrayList<Oxen> oxen = new ArrayList<>();
        Oxen ox = new Oxen();
        ox.setStrength(30);
        oxen.add(ox);
        oxen.add(ox);
        oxen.add(ox);
        oxen.add(ox);
        party.setOxen(oxen);

        //set pace
        party.setPace(PaceSpeed.MEDIUM);
        party.setDistanceTraveled(0);
        return party;

    }

    private void chooseWagon(Party party) {
        boolean done = false;
        do {
            System.out.println(
                    "\n-----------------------------------------"
                    + "\n     Buy a Wagon"
                    + "\n-----------------------------------------"
                    + "\n"
                    + "\nAvailable Wagons:"
                    + "\nCode |  Size  | Carrying Weight | Max Weight | Suggested Oxen | Cost"
                    + "\n---------------------------------------------------------------------"
                    + "\n L     Large           3000          4000            6          $500"
                    + "\n M     Medium          2300          3000            4          $400"
                    + "\n S     Small           1800          2200            2          $300"
                    + "\n"
                    + "\nInput the wagon you wish to purchase (S/M/L):"
            );
            String input = getMenuFeedback();
            Wagon wagon = new Wagon();
            switch (input.toLowerCase()) {
                case "l":
                    wagon.setCarryingWeight(3000);
                    wagon.setSizeDescription("Large");
                    party.setPartyMoney(party.getPartyMoney() - 500);
                    party.setWagon(wagon);
                    done = true;
                    break;
                case "m":
                    wagon.setCarryingWeight(2300);
                    wagon.setSizeDescription("Medium");
                    party.setPartyMoney(party.getPartyMoney() - 400);
                    party.setWagon(wagon);
                    done = true;
                    break;
                case "s":
                    wagon.setCarryingWeight(1800);
                    wagon.setSizeDescription("Small");
                    party.setPartyMoney(party.getPartyMoney() - 300);
                    party.setWagon(wagon);
                    done = true;
                    break;
                default:
                    System.out.println("That is not a valid option");
                    break;
            }
        } while (!done);
        System.out.println("Congradulations! You bought a " + party.getWagon().getSizeDescription() + " wagon"
                + "\nand have $" + party.getPartyMoney() + " left.");
    }

    private void showPartyInformation(Party party) {
        System.out.println(
                "\nWelcome " + party.getPartyMembers().get(0).getName() + "!"
                + "\n"
                + "\nYour party consists of:"
                + "\nYou, " + party.getPartyMembers().get(0).getName() + ", as the leader"
                + "\n" + party.getPartyMembers().get(1).getName()
                + "\n" + party.getPartyMembers().get(2).getName()
                + "\nand " + party.getPartyMembers().get(3).getName()
                + "\n"
                + "\nYou have $" + party.getPartyMoney()
                + "\n"
                + "\nLets go buy supplies for the trip!"
                + "\nPress the Enter key to return to the menu..."
        );
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    private void buySupplies(Party party) {
//        shortening for developing sakes
        ArrayList<Supply> supplies = new ArrayList<>();
        Supply food = new Supply();
        food.setType(SupplyType.FOOD);
        food.setAmount(60);
        supplies.add(food);
        Supply wagonWheels = new Supply();
        wagonWheels.setType(SupplyType.WAGON_WHEELS);
        wagonWheels.setAmount(2);
        supplies.add(wagonWheels);
        party.getWagon().setSupplies(supplies);
    }
}
