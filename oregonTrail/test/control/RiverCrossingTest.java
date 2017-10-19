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
 * @author jsistemas
 */
public class RiverCrossingTest {
    
    @Test
    public void successfulCrossing() {
        double oxenStrength=30;
        double wagonWeight=2000;
        RiverCrossing instance= new RiverCrossing();
        instance.setRiverDepth(3);
        double expResult=1;
        double result = instance.calculateRiverCrossSuccess(wagonWeight, oxenStrength);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void unsuccessfulCrossing() {
        double oxenStrength=40;
        double wagonWeight=5000;
        RiverCrossing instance= new RiverCrossing();
        instance.setRiverDepth(5);
        double expResult=0;
        double result = instance.calculateRiverCrossSuccess(wagonWeight, oxenStrength);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void negativeWagonWeight() {
        double oxenStrength=30;
        double wagonWeight=-1;
        RiverCrossing instance= new RiverCrossing();
        instance.setRiverDepth(3);
        double expResult=-1;
        double result = instance.calculateRiverCrossSuccess(wagonWeight, oxenStrength);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void negativeOxenStrength() {
        double oxenStrength=-1;
        double wagonWeight=2000;
        RiverCrossing instance= new RiverCrossing();
        instance.setRiverDepth(3);
        double expResult=-2;
        double result = instance.calculateRiverCrossSuccess(wagonWeight, oxenStrength);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void negativeRiverDepth() {
        double oxenStrength=30;
        double wagonWeight=2000;
        RiverCrossing instance= new RiverCrossing();
        instance.setRiverDepth(-1);
        double expResult=-3;
        double result = instance.calculateRiverCrossSuccess(wagonWeight, oxenStrength);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void boundaryLightWagon() {
        double oxenStrength=30;
        double wagonWeight=1;
        RiverCrossing instance= new RiverCrossing();
        instance.setRiverDepth(3);
        double expResult=1;
        double result = instance.calculateRiverCrossSuccess(wagonWeight, oxenStrength);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void boundaryDeathOxen() {
        double oxenStrength=0;
        double wagonWeight=2000;
        RiverCrossing instance= new RiverCrossing();
        instance.setRiverDepth(3);
        double expResult=0;
        double result = instance.calculateRiverCrossSuccess(wagonWeight, oxenStrength);
        assertEquals(expResult, result, 0);
    }
    @Test
    public void boundaryLowRiver() {
        double oxenStrength=30;
        double wagonWeight=2000;
        RiverCrossing instance= new RiverCrossing();
        instance.setRiverDepth(1);
        double expResult=1;
        double result = instance.calculateRiverCrossSuccess(wagonWeight, oxenStrength);
        assertEquals(expResult, result, 0);
    }
}
