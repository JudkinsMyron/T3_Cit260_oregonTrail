/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Supply;
import model.Wagon;

/**
 *
 * @author Kevin's Account
 */
public class GeneralStore {
    
    public double adjustSupplies(Wagon wagon, String supplyType, double supplyAmount) {
        
        if (checkForBadSupplyType(supplyType)) {
            return -1;
        }
        
        for (Supply supply : wagon.getSupplies()) {
            if (supply.getType().equals(supplyType)) {
                double currentSupplyAmount = supply.getAmount();
                double adjustedSupplyAmount = currentSupplyAmount + supplyAmount;
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
    
    public double weightCheck(double carryingWeight, double wagonWeight, String supplyType, double supplyAmountChange) {
        if (checkForBadSupplyType(supplyType)) {
            return -1;
        }
        if (carryingWeight < 0) {
            return -2;
        }
        if (wagonWeight < 0) {
            return -3;
        }
        double weightToAdd = 0;
        if (supplyType.equals("Wagon Wheels")) {
            weightToAdd = 10 * supplyAmountChange;
        }
        if (supplyType.equals("Food")) {
            weightToAdd = 1 * supplyAmountChange;
        }
        if (weightToAdd + wagonWeight > carryingWeight) {
            return 0;
        } else {
            return 1;
        }
    }
    
    private boolean checkForBadSupplyType(String supplyType) {
        return (!supplyType.equals("Wagon Wheels") && !supplyType.equals("Food"));
    }
    
    public double purchaseSupply(String supplyType,double unitPriceSupply,double amountToPurchase,double moneyBalance){
        double newMoneyBalance;
        
        if (checkForBadSupplyType(supplyType)) {
            return -1;
        }
        
        if (unitPriceSupply<=0 || amountToPurchase<=0 ||moneyBalance<=0){
            return -1;
        }else{
            newMoneyBalance= moneyBalance-unitPriceSupply*amountToPurchase;
        }
        
        return newMoneyBalance;
    }
}
