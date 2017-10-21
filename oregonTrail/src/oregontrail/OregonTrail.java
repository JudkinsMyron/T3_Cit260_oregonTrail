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


import model.TestoClass;
import model.Actors;

/**
 *
 * @author Kevin's Account
 */
public class OregonTrail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Oxen beast = new Oxen();
        beast.setStrength(6);
        System.out.println(beast.toString());
        
        Supply something = new Supply();
        something.setType("Food");
        something.setAmount(45);
        System.out.println(something.toString());
        
        Wagon large = new Wagon();
        large.setCarryingWeight(2500);
        large.setSizeDescription("Largest");
        large.setIsBroken(false);
        large.setWagonWeight(800);
        ArrayList<Supply> supplies = new ArrayList<Supply>();
        supplies.add(something);
        large.setSupplies(supplies);
        System.out.println(large.toString());
        
        Actor actor = new Actor();
        actor.setName("Ricardo");
        actor.setHealth(4);
        actor.setHuntingSkill(10);
        actor.setGatheringSkill(5);
        actor.setMoney(1000);
        actor.setStamina(8);
           
        Party party = new Party();        
        party.setDistanceTraveled(1000);
        party.setMapPositions(15);
        ArrayList<Oxen> oxen = new ArrayList<>();
        oxen.add(beast);
        party.setOxen(oxen);
        party.setPace(3);
        ArrayList<Actor> partyMembers = new ArrayList<>();
        partyMembers.add(actor);
        party.setPartyMembers(partyMembers);
        party.setPartyMoney(1500);
        party.setWagon(large);
        System.out.println(actor.toString());
        System.out.println(party.toString());               
               
        Player theBestOne = new Player();
        theBestOne.setName("Dancho");
        theBestOne.setParty(party);
        System.out.println(theBestOne.toString());

    }
        
}
