/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import exceptions.DailyHealthException;
import exceptions.GamePlayException;
import exceptions.PrintingException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import model.Actor;
import model.Party;
import model.Player;
import model.Supply;
import view.DailyActivity;


/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;*/
/**
 *
 * @author Myron Judkins
 */
public class GamePlay implements Serializable {

//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
// public double calculateDailyHealth(double actorHealth, double actorStamina, double dailyFoodEaten, double dailyMilesTraveled){
    public double calculateDailyHealth(double actorHealth, double actorStamina, double dailyFoodEaten, double dailyMilesTraveled) throws DailyHealthException {
        //I have yet to be sure where to get these variables

        if (actorStamina <= 0 || actorStamina > 100) {
            throw new DailyHealthException("Actor Stamina is out of range");
        }
        if (actorHealth <= 0 || actorHealth > 100) {
            throw new DailyHealthException("Actor Health is out of range");
        }
        if (dailyFoodEaten >= 10) {
            throw new DailyHealthException("Food Eaten today is too high");
        }
        if (dailyFoodEaten < 0) {
            throw new DailyHealthException("Food Eaten today is less than zero");
        }
        if (dailyMilesTraveled < 0 || dailyMilesTraveled > 25) {
            throw new DailyHealthException("Miles traveled is out of range");
        }
        double newHealth = (actorHealth + (((dailyFoodEaten * 5) / (dailyMilesTraveled + 1)) - (dailyMilesTraveled * (actorStamina / 220))));
        double newerHealth = Math.round(newHealth);
        if (newerHealth > 100) {
            newerHealth = 100;
        }
        if (0 > newerHealth) {
            newerHealth = 0;
        }
        actorHealth = newerHealth;

        return actorHealth;
    }

    public double calculateAverageStrength(Party party) {
        double totalHealth = 0;

        for (Actor actor : party.getPartyMembers()) {
            totalHealth += actor.getHealth();
        }

        if (totalHealth < 0) {
            return -1;
        }

        return totalHealth / party.getPartyMembers().size();
    }

    public String setDailyHealth(Party party) throws DailyHealthException {
        GamePlay gamePlay = new GamePlay();
        double averageHealth = 0;
        int partyMemberCounter = 0;
        String message = "Your Health and food has been updated for Today";
        for (Actor actor : party.getPartyMembers()) {
            actor.setHealth((int) gamePlay.calculateDailyHealth(actor.getHealth(), actor.getStamina(), 2.5, 8));
            message += "\n Health for " + actor.getName() + " is " + actor.getHealth();
            averageHealth = averageHealth + actor.getHealth();
            if (actor.getHealth() > 0) {
                partyMemberCounter++;
            }
        }
        message += "\n The Average Health for party members is " + (averageHealth / partyMemberCounter);
        return message;
    }

    public static void saveGame(Player player, String filePath)
            throws GamePlayException {
        try (FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            output.writeObject(player);
        } catch (Exception e) {
            throw new GamePlayException(e.getMessage());
        }
    }

    public static void loadGame(String filepath)
            throws GamePlayException {
        Player player = null;
        try (FileInputStream fips = new FileInputStream(filepath)) {
            ObjectInputStream input = new ObjectInputStream(fips);
            player = (Player) input.readObject();
        } catch (Exception e) {
            throw new GamePlayException(e.getMessage());
        }
        DailyActivity dailyActivity = new DailyActivity(player);
        dailyActivity.display();
    }

    public static boolean printPartyHealthReport(Party party, String filepath) throws PrintingException {
        try {
            PrintWriter pw = new PrintWriter(filepath);
            pw.println("        ACTORS AND ATTRIBUTES       ");
            pw.println("**************************************************");
            pw.println("Name            Health  Stamina Hunting Gathering");
            pw.println("**************************************************");
            for (Actor actor : party.getPartyMembers()) {
                String dataSection = actor.getHealth() +
                        "       " +  actor.getStamina() +
                        "       " +  actor.getHuntingSkill() +
                        "       " +  actor.getGatheringSkill();
                String row = actor.getName();
                for(int i = actor.getName().length() - 1; i < 16; i++) {
                    row+= " ";
                }
                pw.println(row + dataSection);
            }
            pw.flush();
            return true;
        } catch (Exception e) {
            throw new PrintingException("Unable to print Party Health to " + filepath);
        }
    }
    public static boolean printInventory(ArrayList<Supply> supplies, String filepath) throws PrintingException {
        try {
            PrintWriter pm = new PrintWriter(filepath);
            pm.println("       Inventory on the Wagon       ");
            pm.println("**************************************************");
            pm.println("Item            Amount on hand");
            pm.println("**************************************************");
            for (Supply supply : supplies) {
                String stringAmount = Double.toString(supply.getAmount()) ;
                String row = supply.getType().toString();
                
                for(int i = supply.getType().toString().length() - 1; i < 16; i++) {
                    row+= " ";
                }
                pm.println(row + stringAmount);
            }
            pm.flush();
            return true;
        } catch (Exception e) {
            throw new PrintingException("Unable to print Inventory to " + filepath);
        }
    }


}


