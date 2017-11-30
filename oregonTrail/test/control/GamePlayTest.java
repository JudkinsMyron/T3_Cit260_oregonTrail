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
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Myron Judkins
// */
//public class GamePlayTest {
//    
// 
//
//    @Test
//    public void testCalculateDailyHealthValid1() {
//        System.out.println("testCalculateDailyHealthValid1");
//        double actorHealth = 70.0;
//        double actorStamina = 85.0;
//        double dailyFoodEaten = 2.0;
//        double dailyMilesTraveled = 5.0;
//        GamePlay instance = new GamePlay();
//        double expResult = 70.0;
//        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
//        assertEquals(expResult, result, 0.0);
//    }
//
//     @Test
//    public void testCalculateDailyHealthValid2() {
//        System.out.println("testCalculateDailyHealthValid2");
//        double actorHealth = 30.0;
//        double actorStamina = 45.0;
//        double dailyFoodEaten = 0.8;
//        double dailyMilesTraveled = 3.0;
//        GamePlay instance = new GamePlay();
//        double expResult = 30.0;
//        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
//        assertEquals(expResult, result, 0.0);
//    } 
//    
//     @Test
//    public void testCalculateDailyHealthNegativeStamina() {
//        System.out.println("testCalculateDailyHealthNegativeStamina");
//        double actorHealth = 30.0;
//        double actorStamina = -1.0;
//        double dailyFoodEaten = 3.0;
//        double dailyMilesTraveled = 12.0;
//        GamePlay instance = new GamePlay();
//        double expResult = -1.0;
//        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
//        assertEquals(expResult, result, 0.0);
//    } 
//    
//    @Test
//    public void testCalculateDailyHealthStaminaOverload() {
//        System.out.println("testCalculateDailyHealthStaminaOverload");
//        double actorHealth = 30.0;
//        double actorStamina = 101.0;
//        double dailyFoodEaten = 4.0;
//        double dailyMilesTraveled = 8.0;
//        GamePlay instance = new GamePlay();
//        double expResult = -1.0;
//        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
//        assertEquals(expResult, result, 0.0);
//    } 
//    
//    @Test
//    public void testCalculateDailyHealthOverHealth() {
//        System.out.println("testCalculateDailyHealthOverHealth");
//        double actorHealth = 101.0;
//        double actorStamina = 100.0;
//        double dailyFoodEaten = 0.0;
//        double dailyMilesTraveled = 8.0;
//        GamePlay instance = new GamePlay();
//        double expResult = -1.0;
//        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
//        assertEquals(expResult, result, 0.0);
//    } 
//    
//    @Test
//    public void testCalculateDailyHealthUnderHealth() {
//        System.out.println("testCalculateDailyHealthUnderHealth");
//        double actorHealth = 0.0;
//        double actorStamina = 100.0;
//        double dailyFoodEaten = 5.0;
//        double dailyMilesTraveled = 8.0;
//        GamePlay instance = new GamePlay();
//        double expResult = -1.0;
//        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    @Test
//    public void testCalculateDailyNegativeFood() {
//        System.out.println("testCalculateDailyNegativeFood");
//        double actorHealth = 100.0;
//        double actorStamina = 100.0;
//        double dailyFoodEaten = -0.1;
//        double dailyMilesTraveled = 8.0;
//        GamePlay instance = new GamePlay();
//        double expResult = -1.0;
//        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
//        assertEquals(expResult, result, 0.0);
//    } 
//    
//    @Test
//    public void testCalculateDailyHealthOverFood() {
//        System.out.println("testCalculateDailyHealthOverFood");
//        double actorHealth = 50.0;
//        double actorStamina = 100.0;
//        double dailyFoodEaten = 10.1;
//        double dailyMilesTraveled = 8.0;
//        GamePlay instance = new GamePlay();
//        double expResult = -1.0;
//        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
//        assertEquals(expResult, result, 0.0);
//    } 
//    
//    @Test
//    public void testCalculateDailyHealthNegativeMiles() {
//        System.out.println("testCalculateDailyHealthNegativeMiles");
//        double actorHealth = 100.0;
//        double actorStamina = 100.0;
//        double dailyFoodEaten = 5.0;
//        double dailyMilesTraveled = -0.1;
//        GamePlay instance = new GamePlay();
//        double expResult = -1.0;
//        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
//        assertEquals(expResult, result, 0.0);
//    } 
//    
//    @Test
//    public void testCalculateDailyHealthOverMiles() {
//        System.out.println("testCalculateDailyHealthOverMiles");
//        double actorHealth = 100.0;
//        double actorStamina = 100.0;
//        double dailyFoodEaten = 3.0;
//        double dailyMilesTraveled = 26.0;
//        GamePlay instance = new GamePlay();
//        double expResult = -1.0;
//        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
//        assertEquals(expResult, result, 0.0);
//    } 
//    
//    @Test
//    public void testCalculateDailyHealthBoundryResting() {
//        System.out.println("testCalculateDailyHealthBoundryResting");
//        double actorHealth = 1.0;
//        double actorStamina = 1.0;
//        double dailyFoodEaten = 3.5;
//        double dailyMilesTraveled = 0.0;
//        GamePlay instance = new GamePlay();
//        double expResult = 19.0;
//        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
//        assertEquals(expResult, result, 0.0);
//    } 
//    
//    @Test
//    public void testCalculateDailyHealthBoundryStrong() {
//        System.out.println("testCalculateDailyHealthBoundryStrong");
//        double actorHealth = 100.0;
//        double actorStamina = 100.0;
//        double dailyFoodEaten = 0.0;
//        double dailyMilesTraveled = 8.0;
//        GamePlay instance = new GamePlay();
//        double expResult = 96.0;
//        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
//        assertEquals(expResult, result, 0.0);
//    }
//   
//    @Test
//    public void testCalculateDailyHealthBoundryDistance() {
//        System.out.println("testCalculateDailyHealthBoundryDistance");
//        double actorHealth = 25.0;
//        double actorStamina = 100.0;
//        double dailyFoodEaten = 2.0;
//        double dailyMilesTraveled = 20.0;
//        GamePlay instance = new GamePlay();
//        double expResult = 16.0;
//        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
//        assertEquals(expResult, result, 0.0);
//    }
//
//    @Test
//    public void testCalculateAverageStrengthEighty() {
//        System.out.println("calculateAverageStrength");
//        Party party = new Party();
//        // create main character
//        Actor mainCharacter = new Actor();
//        mainCharacter.setGatheringSkill(15);
//        mainCharacter.setHealth(80);
//        mainCharacter.setHuntingSkill(25);
//        mainCharacter.setMoney(700);
//        mainCharacter.setStamina(80);
//        // create party
//        ArrayList<Actor> starterCharacters = new ArrayList<>();
//        starterCharacters.add(mainCharacter);
//        starterCharacters.add(party.getPremadeCharacters().get(0));
//        starterCharacters.add(party.getPremadeCharacters().get(1));
//        starterCharacters.add(party.getPremadeCharacters().get(2));
//        for (Actor actor : starterCharacters) {
//            actor.setHealth(80);
//        }
//        party.setPartyMembers(starterCharacters);
//        GamePlay instance = new GamePlay();
//        double expResult = 80.0;
//        double result = instance.calculateAverageStrength(party);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    @Test
//    public void testCalculateAverageStrengthVariable() {
//        System.out.println("calculateAverageStrength");
//        Party party = new Party();
//        // create main character
//        Actor mainCharacter = new Actor();
//        mainCharacter.setGatheringSkill(15);
//        mainCharacter.setHealth(80);
//        mainCharacter.setHuntingSkill(25);
//        mainCharacter.setMoney(700);
//        mainCharacter.setStamina(80);
//        // create party
//        ArrayList<Actor> starterCharacters = new ArrayList<>();
//        starterCharacters.add(mainCharacter);
//        starterCharacters.add(party.getPremadeCharacters().get(0));
//        starterCharacters.add(party.getPremadeCharacters().get(1));
//        starterCharacters.add(party.getPremadeCharacters().get(2));
//        for (int i = 0; i < starterCharacters.size(); i++) {
//            int j = i + 10;
//            starterCharacters.get(i).setHealth(j);
//        }
//        party.setPartyMembers(starterCharacters);
//        GamePlay instance = new GamePlay();
//        double expResult = 11.5;
//        double result = instance.calculateAverageStrength(party);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    @Test
//    public void testCalculateAverageStrengthNegativeHealth() {
//        System.out.println("calculateAverageStrength");
//        Party party = new Party();
//        // create main character
//        Actor mainCharacter = new Actor();
//        mainCharacter.setGatheringSkill(15);
//        mainCharacter.setHealth(80);
//        mainCharacter.setHuntingSkill(25);
//        mainCharacter.setMoney(700);
//        mainCharacter.setStamina(80);
//        // create party
//        ArrayList<Actor> starterCharacters = new ArrayList<>();
//        starterCharacters.add(mainCharacter);
//        starterCharacters.add(party.getPremadeCharacters().get(0));
//        starterCharacters.add(party.getPremadeCharacters().get(1));
//        starterCharacters.add(party.getPremadeCharacters().get(2));
//        for (Actor actor : starterCharacters) {
//            actor.setHealth(-10);
//        }
//        party.setPartyMembers(starterCharacters);
//        GamePlay instance = new GamePlay();
//        double expResult = -1.0;
//        double result = instance.calculateAverageStrength(party);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    
//    @Test
//    public void testCalculateAverageStrengthZero() {
//        System.out.println("calculateAverageStrength");
//        Party party = new Party();
//        // create main character
//        Actor mainCharacter = new Actor();
//        mainCharacter.setGatheringSkill(15);
//        mainCharacter.setHealth(80);
//        mainCharacter.setHuntingSkill(25);
//        mainCharacter.setMoney(700);
//        mainCharacter.setStamina(80);
//        // create party
//        ArrayList<Actor> starterCharacters = new ArrayList<>();
//        starterCharacters.add(mainCharacter);
//        starterCharacters.add(party.getPremadeCharacters().get(0));
//        starterCharacters.add(party.getPremadeCharacters().get(1));
//        starterCharacters.add(party.getPremadeCharacters().get(2));
//        for (Actor actor : starterCharacters) {
//            actor.setHealth(0);
//        }
//        party.setPartyMembers(starterCharacters);
//        GamePlay instance = new GamePlay();
//        double expResult = 0.0;
//        double result = instance.calculateAverageStrength(party);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    @Test
//    public void testCalculateAverageStrengthThousands() {
//        System.out.println("calculateAverageStrength");
//        Party party = new Party();
//        // create main character
//        Actor mainCharacter = new Actor();
//        mainCharacter.setGatheringSkill(15);
//        mainCharacter.setHealth(80);
//        mainCharacter.setHuntingSkill(25);
//        mainCharacter.setMoney(700);
//        mainCharacter.setStamina(80);
//        // create party
//        ArrayList<Actor> starterCharacters = new ArrayList<>();
//        starterCharacters.add(mainCharacter);
//        starterCharacters.add(party.getPremadeCharacters().get(0));
//        starterCharacters.add(party.getPremadeCharacters().get(1));
//        starterCharacters.add(party.getPremadeCharacters().get(2));
//        for (Actor actor : starterCharacters) {
//            actor.setHealth(2000);
//        }
//        party.setPartyMembers(starterCharacters);
//        GamePlay instance = new GamePlay();
//        double expResult = 2000.0;
//        double result = instance.calculateAverageStrength(party);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//    
//    
//    
//}
