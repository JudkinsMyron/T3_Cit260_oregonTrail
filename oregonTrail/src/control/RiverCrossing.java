/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author jsistemas
 */
public class RiverCrossing {
    private double riverDepth = 0;
    
    public double getRiverDepth() {
        if (riverDepth == 0) {
            setRiverDepth(-10);
        }
        return riverDepth;
    }
    
    public void setRiverDepth(double depth) {
        if (depth == -10) {
            double random = ThreadLocalRandom.current().nextDouble(0, 10);
            riverDepth = random;
        } else {
            riverDepth = depth;
        }
        
    }
    
    public double calculateRiverCrossSuccess(double wagonWeight, double oxenStrength){
        //int riverDepth = Math.random(0, )
        double riverDepth = getRiverDepth();
        
        if (wagonWeight <= 0) {
            wagonWeight = -1;
        }
        if (wagonWeight == -1) {
         return -1;
        }
        if (oxenStrength <  0) {
         return -2;
        }
        if (riverDepth < 0) {
         return -3;
        }
        Boolean success = (oxenStrength / riverDepth) / (wagonWeight / 200) >= 1;
        if (success) {
            return 1;
        } else {
            return 0;
        }
    }
}
