/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Myron Judkins
 */
public class GamePlayTest {
    
 

    @Test
    public void testCalculateDailyHealthValid1() {
        System.out.println("testCalculateDailyHealthValid1");
        double actorHealth = 70.0;
        double actorStamina = 85.0;
        double dailyFoodEaten = 2.0;
        double dailyMilesTraveled = 5.0;
        GamePlay instance = new GamePlay();
        double expResult = 70.0;
        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
        assertEquals(expResult, result, 0.0);
    }

     @Test
    public void testCalculateDailyHealthValid2() {
        System.out.println("testCalculateDailyHealthValid2");
        double actorHealth = 30.0;
        double actorStamina = 45.0;
        double dailyFoodEaten = 0.8;
        double dailyMilesTraveled = 3.0;
        GamePlay instance = new GamePlay();
        double expResult = 30.0;
        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
        assertEquals(expResult, result, 0.0);
    } 
    
     @Test
    public void testCalculateDailyHealthNegativeStamina() {
        System.out.println("testCalculateDailyHealthNegativeStamina");
        double actorHealth = 30.0;
        double actorStamina = -1.0;
        double dailyFoodEaten = 3.0;
        double dailyMilesTraveled = 12.0;
        GamePlay instance = new GamePlay();
        double expResult = -1.0;
        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
        assertEquals(expResult, result, 0.0);
    } 
    
    @Test
    public void testCalculateDailyHealthStaminaOverload() {
        System.out.println("testCalculateDailyHealthStaminaOverload");
        double actorHealth = 30.0;
        double actorStamina = 101.0;
        double dailyFoodEaten = 4.0;
        double dailyMilesTraveled = 8.0;
        GamePlay instance = new GamePlay();
        double expResult = -1.0;
        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
        assertEquals(expResult, result, 0.0);
    } 
    
    @Test
    public void testCalculateDailyHealthOverHealth() {
        System.out.println("testCalculateDailyHealthOverHealth");
        double actorHealth = 101.0;
        double actorStamina = 100.0;
        double dailyFoodEaten = 0.0;
        double dailyMilesTraveled = 8.0;
        GamePlay instance = new GamePlay();
        double expResult = -1.0;
        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
        assertEquals(expResult, result, 0.0);
    } 
    
    @Test
    public void testCalculateDailyHealthUnderHealth() {
        System.out.println("testCalculateDailyHealthUnderHealth");
        double actorHealth = 0.0;
        double actorStamina = 100.0;
        double dailyFoodEaten = 5.0;
        double dailyMilesTraveled = 8.0;
        GamePlay instance = new GamePlay();
        double expResult = -1.0;
        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testCalculateDailyNegativeFood() {
        System.out.println("testCalculateDailyNegativeFood");
        double actorHealth = 100.0;
        double actorStamina = 100.0;
        double dailyFoodEaten = -0.1;
        double dailyMilesTraveled = 8.0;
        GamePlay instance = new GamePlay();
        double expResult = -1.0;
        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
        assertEquals(expResult, result, 0.0);
    } 
    
    @Test
    public void testCalculateDailyHealthOverFood() {
        System.out.println("testCalculateDailyHealthOverFood");
        double actorHealth = 50.0;
        double actorStamina = 100.0;
        double dailyFoodEaten = 10.1;
        double dailyMilesTraveled = 8.0;
        GamePlay instance = new GamePlay();
        double expResult = -1.0;
        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
        assertEquals(expResult, result, 0.0);
    } 
    
    @Test
    public void testCalculateDailyHealthNegativeMiles() {
        System.out.println("testCalculateDailyHealthNegativeMiles");
        double actorHealth = 100.0;
        double actorStamina = 100.0;
        double dailyFoodEaten = 5.0;
        double dailyMilesTraveled = -0.1;
        GamePlay instance = new GamePlay();
        double expResult = -1.0;
        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
        assertEquals(expResult, result, 0.0);
    } 
    
    @Test
    public void testCalculateDailyHealthOverMiles() {
        System.out.println("testCalculateDailyHealthOverMiles");
        double actorHealth = 100.0;
        double actorStamina = 100.0;
        double dailyFoodEaten = 3.0;
        double dailyMilesTraveled = 26.0;
        GamePlay instance = new GamePlay();
        double expResult = -1.0;
        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
        assertEquals(expResult, result, 0.0);
    } 
    
    @Test
    public void testCalculateDailyHealthBoundryResting() {
        System.out.println("testCalculateDailyHealthBoundryResting");
        double actorHealth = 1.0;
        double actorStamina = 1.0;
        double dailyFoodEaten = 3.5;
        double dailyMilesTraveled = 0.0;
        GamePlay instance = new GamePlay();
        double expResult = 19.0;
        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
        assertEquals(expResult, result, 0.0);
    } 
    
    @Test
    public void testCalculateDailyHealthBoundryStrong() {
        System.out.println("testCalculateDailyHealthBoundryStrong");
        double actorHealth = 100.0;
        double actorStamina = 100.0;
        double dailyFoodEaten = 0.0;
        double dailyMilesTraveled = 8.0;
        GamePlay instance = new GamePlay();
        double expResult = 96.0;
        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
        assertEquals(expResult, result, 0.0);
    }
   
    @Test
    public void testCalculateDailyHealthBoundryDistance() {
        System.out.println("testCalculateDailyHealthBoundryDistance");
        double actorHealth = 25.0;
        double actorStamina = 100.0;
        double dailyFoodEaten = 2.0;
        double dailyMilesTraveled = 20.0;
        GamePlay instance = new GamePlay();
        double expResult = 16.0;
        double result = instance.calculateDailyHealth(actorHealth, actorStamina, dailyFoodEaten, dailyMilesTraveled);
        assertEquals(expResult, result, 0.0);
    }
    
    
    
    
    
}
