/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oregontrail;

import java.util.ArrayList;
import model.Actor;
import model.Party;
import model.Player;
import model.Supply;
import model.Oxen;
import model.Wagon;

/**
 *
 * @author Kevin's Account
 */
public class OregonTrail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Party party = new Party();
        party.setDistanceTraveled(1000);
        party.setMapPositions(15);
        // needs Oxen class
//        ArrayList<Oxen> oxen = new ArrayList<>();
//        Oxen o = new Oxen();
//        oxen.add(o);
//        party.setOxen(oxen);
        party.setPace(3);
        ArrayList<Actor> partyMembers = new ArrayList<>();
        
        
        Actor actor = new Actor();
        actor.setName("Ricardo");
        actor.setHealth(4);
        actor.setHuntingSkill(10);
        actor.setGatheringSkill(5);
        actor.setMoney(1000);
        actor.setStamina(8);
        partyMembers.add(actor);
        party.setPartyMembers(partyMembers);
        party.setPartyMoney(1500);
        // needs wagon class
//        Wagon wagon = new Wagon;
//        party.setWagon(wagon);
        System.out.println(actor.toString());
        System.out.println(party.toString());
        
        
        Player theBestOne = new Player();
        theBestOne.setName("Dancho");
        theBestOne.setParty(party);
        System.out.println(theBestOne.toString());
        
        
        Supply something = new Supply();
        something.setType("Food");
        something.setAmount(45);
        System.out.println(something.toString());
        
        Oxen beast = new Oxen();
        beast.setStrength(6);
        System.out.println(beast.toString());
        
        Wagon large = new Wagon();
        large.setCarryingWeight(2500);
        large.setSizeDescription("Largest");
        large.setIsBroken(false);
        large.setWagonWeight(800);
        System.out.println(large.toString());
    }
    
}
