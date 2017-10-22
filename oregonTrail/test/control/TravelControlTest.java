/*
 * This file is part of an independent project and must not be 
 * copyied without authorization.
 */
package control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dan Ortega
 */
public class TravelControlTest {
    
    public TravelControlTest() {
    }

    /**
     * Valid Test 
     */
    @Test
    public void testCalcDailyMilesTraveled1() {
        System.out.println("calcDailyMilesTraveled");
        double partyAvgHealth = 10.0;
        double oxenStrength = 60.0;
        double totalWagonWeight = 150.0;
        TravelControl instance = new TravelControl();
        double expResult = 40.0;
        double result = instance.calcDailyMilesTraveled(partyAvgHealth, oxenStrength, totalWagonWeight);
        assertEquals(expResult, result, 0.0);

    }
    
    /**
     * Valid Test
     */
    @Test
    public void testCalcDailyMilesTraveled2() {
        System.out.println("calcDailyMilesTraveled");
        double partyAvgHealth = 4.0;
        double oxenStrength = 4.0;
        double totalWagonWeight = 250.0;
        TravelControl instance = new TravelControl();
        double expResult = 0.0;
        double result = instance.calcDailyMilesTraveled(partyAvgHealth, oxenStrength, totalWagonWeight);
        assertEquals(expResult, result, 0.0);

    }
    
    
    /**
     * Invalid Test
     */
    @Test
    public void testCalcDailyMilesTraveled3() {
        System.out.println("calcDailyMilesTraveled");
        double partyAvgHealth = 3.0;
        double oxenStrength = 35.0;
        double totalWagonWeight = 360.0;
        TravelControl instance = new TravelControl();
        double expResult = -1.0;
        double result = instance.calcDailyMilesTraveled(partyAvgHealth, oxenStrength, totalWagonWeight);
        assertEquals(expResult, result, 0.0);

    }
    
    
    /**
     * Invalid Test
     */
    @Test
    public void testCalcDailyMilesTraveled4() {
        System.out.println("calcDailyMilesTraveled");
        double partyAvgHealth = 7.0;
        double oxenStrength = 2.0;
        double totalWagonWeight = 360.0;
        TravelControl instance = new TravelControl();
        double expResult = -1.0;
        double result = instance.calcDailyMilesTraveled(partyAvgHealth, oxenStrength, totalWagonWeight);
        assertEquals(expResult, result, 0.0);

    }
    
    
    /**
     * Invalid Test
     */
    @Test
    public void testCalcDailyMilesTraveled5() {
        System.out.println("calcDailyMilesTraveled");
        double partyAvgHealth = 7.0;
        double oxenStrength = 35.0;
        double totalWagonWeight = 3.0;
        TravelControl instance = new TravelControl();
        double expResult = -1.0;
        double result = instance.calcDailyMilesTraveled(partyAvgHealth, oxenStrength, totalWagonWeight);
        assertEquals(expResult, result, 0.0);

    }
    
    
    /**
     * Boundary Test
     */
    @Test
    public void testCalcDailyMilesTraveled6() {
        System.out.println("calcDailyMilesTraveled");
        double partyAvgHealth = 4.0;
        double oxenStrength = 35.0;
        double totalWagonWeight = 200.0;
        TravelControl instance = new TravelControl();
        double expResult = 17.0;
        double result = instance.calcDailyMilesTraveled(partyAvgHealth, oxenStrength, totalWagonWeight);
        assertEquals(expResult, result, 0.0);

    }
    
    
    /**
     * Boundary Test
     */
    @Test
    public void testCalcDailyMilesTraveled7() {
        System.out.println("calcDailyMilesTraveled");
        double partyAvgHealth = 10.0;
        double oxenStrength = 35.0;
        double totalWagonWeight = 200.0;
        TravelControl instance = new TravelControl();
        double expResult = 26.0;
        double result = instance.calcDailyMilesTraveled(partyAvgHealth, oxenStrength, totalWagonWeight);
        assertEquals(expResult, result, 0.0);

    }
    
    
    /**
     * Boundary Test
     */
    @Test
    public void testCalcDailyMilesTraveled8() {
        System.out.println("calcDailyMilesTraveled");
        double partyAvgHealth = 7.0;
        double oxenStrength = 4.0;
        double totalWagonWeight = 160.0;
        TravelControl instance = new TravelControl();
        double expResult = 7.2;
        double result = instance.calcDailyMilesTraveled(partyAvgHealth, oxenStrength, totalWagonWeight);
        assertEquals(expResult, result, 0.0);

    }
    
    
    /**
     * Boundary Test
     */
    @Test
    public void testCalcDailyMilesTraveled9() {
        System.out.println("calcDailyMilesTraveled");
        double partyAvgHealth = 7.0;
        double oxenStrength = 60.0;
        double totalWagonWeight = 300.0;
        TravelControl instance = new TravelControl();
        double expResult = 31.0;
        double result = instance.calcDailyMilesTraveled(partyAvgHealth, oxenStrength, totalWagonWeight);
        assertEquals(expResult, result, 0.0);

    }
    
    
    /**
     * Test of calcDailyMilesTraveled method, of class TravelControl.
     */
    @Test
    public void testCalcDailyMilesTraveled10() {
        System.out.println("calcDailyMilesTraveled");
        double partyAvgHealth = 7.0;
        double oxenStrength = 30.0;
        double totalWagonWeight = 150.0;
        TravelControl instance = new TravelControl();
        double expResult = 20.5;
        double result = instance.calcDailyMilesTraveled(partyAvgHealth, oxenStrength, totalWagonWeight);
        assertEquals(expResult, result, 0.0);

    }
    
    
    
}
