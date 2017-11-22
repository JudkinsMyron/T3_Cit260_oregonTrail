///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package control;
//
//import java.util.ArrayList;
//import model.Actor;
//import model.Party;
//import model.Supply;
//import model.SupplyType;
//import model.Wagon;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Kevin's Account
// */
//public class TrailStopTest {
//    
//    public TrailStopTest() {
//    }
//
//    /**
//     * Test of calcHuntingSuccess method, of class TrailStop.
//     */
//    @Test
//    public void calcHuntingfailure() {
//        Party party = new Party();
//        ArrayList<Actor> actors = new ArrayList<>();
//        Actor bob = new Actor();
//        bob.setStamina(1);
//        bob.setHuntingSkill(0);
//        actors.add(bob);
//        party.setPartyMembers(actors);
//        
//        TrailStop instance = new TrailStop();
//        double expResult = 0.0;
//        double result = instance.calcHuntingSuccess(party);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    @Test
//    public void calcHuntingSuccess() {
//        Party party = new Party();
//        ArrayList<Actor> actors = new ArrayList<>();
//        Actor bob = new Actor();
//        bob.setStamina(1);
//        bob.setHuntingSkill(50);
//        actors.add(bob);
//        party.setPartyMembers(actors);
//        
//        TrailStop instance = new TrailStop();
//        double expResult = 1.0;
//        double result = instance.calcHuntingSuccess(party);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    @Test
//    public void calcHuntingInvalidHuntingSkill() {
//        Party party = new Party();
//        ArrayList<Actor> actors = new ArrayList<>();
//        Actor bob = new Actor();
//        bob.setStamina(1);
//        bob.setHuntingSkill(-1);
//        actors.add(bob);
//        party.setPartyMembers(actors);
//        
//        TrailStop instance = new TrailStop();
//        double expResult = -1.0;
//        double result = instance.calcHuntingSuccess(party);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    @Test
//    public void calcHuntingSuccessExtreme() {
//        Party party = new Party();
//        ArrayList<Actor> actors = new ArrayList<>();
//        Actor bob = new Actor();
//        bob.setHuntingSkill(100);
//        bob.setStamina(1);
//        actors.add(bob);
//        party.setPartyMembers(actors);
//        
//        TrailStop instance = new TrailStop();
//        double expResult = 1.0;
//        double result = instance.calcHuntingSuccess(party);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    /**
//     * Test of calcGatheringSuccess method, of class TrailStop.
//     */
//    @Test
//    public void testCalcGatheringFailure() {
//        Party party = new Party();
//        ArrayList<Actor> actors = new ArrayList<>();
//        Actor bob = new Actor();
//        bob.setGatheringSkill(0);
//        bob.setStamina(1);
//        actors.add(bob);
//        party.setPartyMembers(actors);
//        
//        TrailStop instance = new TrailStop();
//        double expResult = 0.0;
//        double result = instance.calcGatheringSuccess(party);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    @Test
//    public void testCalcGatheringSuccess() {
//        Party party = new Party();
//        ArrayList<Actor> actors = new ArrayList<>();
//        Actor bob = new Actor();
//        bob.setGatheringSkill(30);
//        bob.setStamina(1);
//        actors.add(bob);
//        party.setPartyMembers(actors);
//        
//        TrailStop instance = new TrailStop();
//        double expResult = 1.0;
//        double result = instance.calcGatheringSuccess(party);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    @Test
//    public void testCalcGatheringNegativeSkill() {
//        Party party = new Party();
//        ArrayList<Actor> actors = new ArrayList<>();
//        Actor bob = new Actor();
//        bob.setGatheringSkill(-1);
//        bob.setStamina(1);
//        actors.add(bob);
//        party.setPartyMembers(actors);
//        
//        TrailStop instance = new TrailStop();
//        double expResult = -1.0;
//        double result = instance.calcGatheringSuccess(party);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    @Test
//    public void testCalcGatheringExtremeSuccess() {
//        Party party = new Party();
//        ArrayList<Actor> actors = new ArrayList<>();
//        Actor bob = new Actor();
//        bob.setGatheringSkill(100);
//        bob.setStamina(1);
//        actors.add(bob);
//        party.setPartyMembers(actors);
//        
//        TrailStop instance = new TrailStop();
//        double expResult = 1.0;
//        double result = instance.calcGatheringSuccess(party);
//        assertEquals(expResult, result, 0.0);
//    }
//
//    /**
//     * Test of goHunting method, of class TrailStop.
//     */
//    @Test
//    public void testGoHuntingSuccess() {
//        Wagon wagon = new Wagon();
//        wagon.setCarryingWeight(2000);
//        wagon.setWagonWeight(1000);
//        ArrayList<Supply> supplies = new ArrayList<>();
//        Supply food = new Supply();
//        food.setType(SupplyType.FOOD);
//        food.setAmount(60);
//        supplies.add(food);
//        wagon.setSupplies(supplies);
//        
//        ArrayList<Actor> actors = new ArrayList<>();
//        Actor bob = new Actor();
//        bob.setHuntingSkill(100);
//        bob.setStamina(1);
//        actors.add(bob);
//        
//        Party party = new Party();
//        party.setPartyMembers(actors);
//        party.setWagon(wagon);
//        
//        TrailStop instance = new TrailStop();
//        double expResult = 1.0;
//        double result = instance.goHunting(party);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    @Test
//    public void testGoHuntingFailure() {
//        Wagon wagon = new Wagon();
//        wagon.setCarryingWeight(2000);
//        wagon.setWagonWeight(1000);
//        ArrayList<Supply> supplies = new ArrayList<>();
//        Supply food = new Supply();
//        food.setType(SupplyType.FOOD);
//        food.setAmount(60);
//        supplies.add(food);
//        wagon.setSupplies(supplies);
//        
//        ArrayList<Actor> actors = new ArrayList<>();
//        Actor bob = new Actor();
//        bob.setHuntingSkill(0);
//        bob.setStamina(1);
//        actors.add(bob);
//        
//        Party party = new Party();
//        party.setPartyMembers(actors);
//        party.setWagon(wagon);
//        
//        TrailStop instance = new TrailStop();
//        double expResult = 0.0;
//        double result = instance.goHunting(party);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    @Test
//    public void testGoHuntingCannotCarryFood() {
//        Wagon wagon = new Wagon();
//        wagon.setCarryingWeight(2000);
//        wagon.setWagonWeight(2000);
//        ArrayList<Supply> supplies = new ArrayList<>();
//        Supply food = new Supply();
//        food.setType(SupplyType.FOOD);
//        food.setAmount(60);
//        supplies.add(food);
//        wagon.setSupplies(supplies);
//        
//        ArrayList<Actor> actors = new ArrayList<>();
//        Actor bob = new Actor();
//        bob.setHuntingSkill(100);
//        bob.setStamina(1);
//        actors.add(bob);
//        
//        Party party = new Party();
//        party.setPartyMembers(actors);
//        party.setWagon(wagon);
//        
//        TrailStop instance = new TrailStop();
//        double expResult = -1.0;
//        double result = instance.goHunting(party);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    
//
//    /**
//     * Test of lookForPlants method, of class TrailStop.
//     */
//    @Test
//    public void testLookForPlantsSuccess() {
//        Wagon wagon = new Wagon();
//        wagon.setCarryingWeight(2000);
//        wagon.setWagonWeight(1000);
//        ArrayList<Supply> supplies = new ArrayList<>();
//        Supply food = new Supply();
//        food.setType(SupplyType.FOOD);
//        food.setAmount(60);
//        supplies.add(food);
//        wagon.setSupplies(supplies);
//        
//        ArrayList<Actor> actors = new ArrayList<>();
//        Actor bob = new Actor();
//        bob.setGatheringSkill(100);
//        bob.setStamina(1);
//        actors.add(bob);
//        
//        Party party = new Party();
//        party.setPartyMembers(actors);
//        party.setWagon(wagon);
//        
//        TrailStop instance = new TrailStop();
//        double expResult = 1.0;
//        double result = instance.lookForPlants(party);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    @Test
//    public void testLookForPlantsFailure() {
//        Wagon wagon = new Wagon();
//        wagon.setCarryingWeight(2000);
//        wagon.setWagonWeight(1000);
//        ArrayList<Supply> supplies = new ArrayList<>();
//        Supply food = new Supply();
//        food.setType(SupplyType.FOOD);
//        food.setAmount(60);
//        supplies.add(food);
//        wagon.setSupplies(supplies);
//        
//        ArrayList<Actor> actors = new ArrayList<>();
//        Actor bob = new Actor();
//        bob.setGatheringSkill(0);
//        bob.setStamina(1);
//        actors.add(bob);
//        
//        Party party = new Party();
//        party.setPartyMembers(actors);
//        party.setWagon(wagon);
//        
//        TrailStop instance = new TrailStop();
//        double expResult = 0.0;
//        double result = instance.lookForPlants(party);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    @Test
//    public void testLookForPlantsCannotCarryFood() {
//        Wagon wagon = new Wagon();
//        wagon.setCarryingWeight(2000);
//        wagon.setWagonWeight(2000);
//        ArrayList<Supply> supplies = new ArrayList<>();
//        Supply food = new Supply();
//        food.setType(SupplyType.FOOD);
//        food.setAmount(60);
//        supplies.add(food);
//        wagon.setSupplies(supplies);
//        
//        ArrayList<Actor> actors = new ArrayList<>();
//        Actor bob = new Actor();
//        bob.setGatheringSkill(100);
//        bob.setStamina(1);
//        actors.add(bob);
//        
//        Party party = new Party();
//        party.setPartyMembers(actors);
//        party.setWagon(wagon);
//        
//        TrailStop instance = new TrailStop();
//        double expResult = -1.0;
//        double result = instance.lookForPlants(party);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//}
