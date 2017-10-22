/*
 * This file is part of an independent project and must not be 
 * copyied without authorization.
 */
package control;

/**
 *
 * @author Dan Ortega
 */
public class TravelControl {
    
    
    public double calcDailyMilesTraveled(double partyAvgHealth, double oxenStrength, double totalWagonWeight) {
    
        if(partyAvgHealth > 10 || partyAvgHealth < 4)
            return -1;
        if(oxenStrength > 60 || oxenStrength <4)
            return -1;
        if(totalWagonWeight < 150)
            return -1;
        
        double partyHealthIncrease = ((partyAvgHealth - 4)* 1.5) + 1;
        double oxenStrengthIncrease = ((oxenStrength -4) * 0.5) + 2;
        double weightDecrease = ((totalWagonWeight - 150) * 0.03);

        double roughMiles = partyHealthIncrease + oxenStrengthIncrease - weightDecrease;
        
        if(roughMiles < 0)
            return 0.0;
            
        return roughMiles;
    
    }
    
    
    
}
