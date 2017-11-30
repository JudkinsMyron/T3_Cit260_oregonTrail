/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import exceptions.RiverCrossingException;
import java.util.concurrent.ThreadLocalRandom;
import model.Supply;
import model.SupplyType;
import model.Wagon;

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

    public int calculateRiverCrossSuccess(double wagonWeight, double oxenStrength)throws RiverCrossingException {
        //int riverDepth = Math.random(0, )
        double riverDepth = getRiverDepth();

        if (wagonWeight <= 0) {
            throw new RiverCrossingException("Wagon weight was zero or lower");
        }
        if (oxenStrength < 0) {
            throw new RiverCrossingException("Oxen Strength was zero or lower");
        }
        if (riverDepth < 0) {
            throw new RiverCrossingException("River Depth was zero or less");
        }
        Boolean success = (oxenStrength / riverDepth) / (wagonWeight / 200) >= 1;
        if (success) {
            return 1;
        } else {
            return 0;
        }
    }

    public double dropSupplies(Wagon wagon, SupplyType supplyType, double amount) {
        if (!supplyType.equals(SupplyType.WAGON_WHEELS) && !supplyType.equals(SupplyType.FOOD)) {
            return -1;
        }

        for (Supply supply : wagon.getSupplies()) {
            if (supply.getType().equals(supplyType)) {
                double currentSupplyAmount = supply.getAmount();
                double adjustedSupplyAmount = currentSupplyAmount - amount;
                if (adjustedSupplyAmount < 0) {
                    return -2;
                }
                double result = weightCheck(wagon.getCarryingWeight(), wagon.getWagonWeight(), supplyType, adjustedSupplyAmount);
                if (result == 1) {
                    supply.setAmount(adjustedSupplyAmount);
                    return adjustedSupplyAmount;
                } else {
                    return -3;
                }
            }
        }

        return -1;
    }

    private double weightCheck(double carryingWeight, double wagonWeight, SupplyType supplyType, double supplyAmountChange) {
        if (supplyType != SupplyType.WAGON_WHEELS && supplyType != SupplyType.FOOD) {
            return -1;
        }
        if (carryingWeight < 0) {
            return -2;
        }
        if (wagonWeight < 0) {
            return -3;
        }
        double weightToAdd = 0;
        if (supplyType.equals(SupplyType.WAGON_WHEELS)) {
            weightToAdd = 10 * supplyAmountChange;
        }
        if (supplyType.equals(SupplyType.FOOD)) {
            weightToAdd = 1 * supplyAmountChange;
        }
        if (weightToAdd + wagonWeight > carryingWeight) {
            return 0;
        } else {
            return 1;
        }
    }
}