/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import model.Supply;
import model.Wagon;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kevin's Account
 */
public class GeneralStoreTest {
    
    public GeneralStoreTest() {
    }

    // adjustSupplies
    @Test
    public void adjustSuppliesAddFood() {
        Wagon wagon = new Wagon();
        wagon.setCarryingWeight(2000);
        wagon.setWagonWeight(1000);
        ArrayList<Supply> supplies = new ArrayList<>();
        Supply food = new Supply();
        food.setType("Food");
        food.setAmount(60);
        supplies.add(food);
        wagon.setSupplies(supplies);
        
        String supplyType = "Food";
        double supplyAmount = 20.0;
        GeneralStore instance = new GeneralStore();
        double expResult = 80.0;
        double result = instance.adjustSupplies(wagon, supplyType, supplyAmount);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void adjustSuppliesSubtractFood() {
        Wagon wagon = new Wagon();
        wagon.setCarryingWeight(2000);
        wagon.setWagonWeight(1000);
        ArrayList<Supply> supplies = new ArrayList<>();
        Supply food = new Supply();
        food.setType("Food");
        food.setAmount(60);
        supplies.add(food);
        wagon.setSupplies(supplies);
        
        String supplyType = "Food";
        double supplyAmount = -20.0;
        GeneralStore instance = new GeneralStore();
        double expResult = 40.0;
        double result = instance.adjustSupplies(wagon, supplyType, supplyAmount);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void adjustSuppliesAddWagonWheels() {
        Wagon wagon = new Wagon();
        wagon.setCarryingWeight(2000);
        wagon.setWagonWeight(1000);
        ArrayList<Supply> supplies = new ArrayList<>();
        Supply wagonWheels = new Supply();
        wagonWheels.setType("Wagon Wheels");
        wagonWheels.setAmount(2);
        supplies.add(wagonWheels);
        wagon.setSupplies(supplies);
        
        String supplyType = "Wagon Wheels";
        double supplyAmount = 3.0;
        GeneralStore instance = new GeneralStore();
        double expResult = 5.0;
        double result = instance.adjustSupplies(wagon, supplyType, supplyAmount);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void adjustSuppliesInvalidSupplyType() {
        Wagon wagon = new Wagon();
        wagon.setCarryingWeight(2000);
        wagon.setWagonWeight(1000);
        ArrayList<Supply> supplies = new ArrayList<>();
        Supply food = new Supply();
        food.setType("Food");
        food.setAmount(80);
        supplies.add(food);
        wagon.setSupplies(supplies);
        
        String supplyType = "";
        double supplyAmount = 20.0;
        GeneralStore instance = new GeneralStore();
        double expResult = -1.0;
        double result = instance.adjustSupplies(wagon, supplyType, supplyAmount);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void adjustSuppliesBelowZeroSupplyResult() {
        Wagon wagon = new Wagon();
        wagon.setCarryingWeight(2000);
        wagon.setWagonWeight(1000);
        ArrayList<Supply> supplies = new ArrayList<>();
        Supply food = new Supply();
        food.setType("Food");
        food.setAmount(0);
        supplies.add(food);
        wagon.setSupplies(supplies);
        
        String supplyType = "Food";
        double supplyAmount = -60.0;
        GeneralStore instance = new GeneralStore();
        double expResult = -2.0;
        double result = instance.adjustSupplies(wagon, supplyType, supplyAmount);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void adjustSuppliesNegativeWagonWeight() {
        Wagon wagon = new Wagon();
        wagon.setCarryingWeight(2000);
        wagon.setWagonWeight(1800);
        ArrayList<Supply> supplies = new ArrayList<>();
        Supply food = new Supply();
        food.setType("Food");
        food.setAmount(80);
        supplies.add(food);
        wagon.setSupplies(supplies);
        
        String supplyType = "Food";
        double supplyAmount = 800.0;
        GeneralStore instance = new GeneralStore();
        double expResult = -3.0;
        double result = instance.adjustSupplies(wagon, supplyType, supplyAmount);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void adjustSuppliesAddingAlotOfFoodWhenZero() {
        Wagon wagon = new Wagon();
        wagon.setCarryingWeight(2000);
        wagon.setWagonWeight(1000);
        ArrayList<Supply> supplies = new ArrayList<>();
        Supply food = new Supply();
        food.setType("Food");
        food.setAmount(0);
        supplies.add(food);
        wagon.setSupplies(supplies);
        
        String supplyType = "Food";
        double supplyAmount = 100.0;
        GeneralStore instance = new GeneralStore();
        double expResult = 100.0;
        double result = instance.adjustSupplies(wagon, supplyType, supplyAmount);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void adjustSuppliesAddingZeroFood() {
        Wagon wagon = new Wagon();
        wagon.setCarryingWeight(2000);
        wagon.setWagonWeight(1000);
        ArrayList<Supply> supplies = new ArrayList<>();
        Supply food = new Supply();
        food.setType("Food");
        food.setAmount(100);
        supplies.add(food);
        wagon.setSupplies(supplies);
        
        String supplyType = "Food";
        double supplyAmount = 0.0;
        GeneralStore instance = new GeneralStore();
        double expResult = 100.0;
        double result = instance.adjustSupplies(wagon, supplyType, supplyAmount);
        assertEquals(expResult, result, 0.0);
    }
    
    
    // weightCheck
    @Test
    public void weightCheckSuccess() {
        double carryingWeight = 2000.0;
        double wagonWeight = 0.0;
        String supplyType = "Food";
        double supplyAmountChange = 20.0;
        GeneralStore instance = new GeneralStore();
        double expResult = 1.0;
        double result = instance.weightCheck(carryingWeight, wagonWeight, supplyType, supplyAmountChange);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void weightCheckFailure() {
        double carryingWeight = 2000.0;
        double wagonWeight = 1995;
        String supplyType = "Wagon Wheels";
        double supplyAmountChange = 1.0;
        GeneralStore instance = new GeneralStore();
        double expResult = 0.0;
        double result = instance.weightCheck(carryingWeight, wagonWeight, supplyType, supplyAmountChange);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void weightCheckInvalidSupplyType() {
        double carryingWeight = 2000.0;
        double wagonWeight = 0.0;
        String supplyType = "";
        double supplyAmountChange = 20.0;
        GeneralStore instance = new GeneralStore();
        double expResult = -1.0;
        double result = instance.weightCheck(carryingWeight, wagonWeight, supplyType, supplyAmountChange);
        assertEquals(expResult, result, 0.0);
    }
    @Test
    public void weightCheckNegativeCarryingWeight() {
        double carryingWeight = -1.0;
        double wagonWeight = 0.0;
        String supplyType = "Food";
        double supplyAmountChange = 20.0;
        GeneralStore instance = new GeneralStore();
        double expResult = -2.0;
        double result = instance.weightCheck(carryingWeight, wagonWeight, supplyType, supplyAmountChange);
        assertEquals(expResult, result, 0.0);
    }
    @Test
    public void weightCheckNegativeWagonWeight() {
        double carryingWeight = 2000.0;
        double wagonWeight = -1.0;
        String supplyType = "Food";
        double supplyAmountChange = 20.0;
        GeneralStore instance = new GeneralStore();
        double expResult = -3.0;
        double result = instance.weightCheck(carryingWeight, wagonWeight, supplyType, supplyAmountChange);
        assertEquals(expResult, result, 0.0);
    }
    @Test
    public void weightCheckNothingToAdd() {
        double carryingWeight = 2000.0;
        double wagonWeight = 0.0;
        String supplyType = "Food";
        double supplyAmountChange = 0.0;
        GeneralStore instance = new GeneralStore();
        double expResult = 1.0;
        double result = instance.weightCheck(carryingWeight, wagonWeight, supplyType, supplyAmountChange);
        assertEquals(expResult, result, 0.0);
    }
    @Test
    public void weightCheckNothingCarried() {
        double carryingWeight = 0.0;
        double wagonWeight = 0.0;
        String supplyType = "Food";
        double supplyAmountChange = 20.0;
        GeneralStore instance = new GeneralStore();
        double expResult = 0.0;
        double result = instance.weightCheck(carryingWeight, wagonWeight, supplyType, supplyAmountChange);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void purchaseSupply() {
        String supplyType = "Food";
        double unitPriceSupply = 7;
        double amountToPurchase=100;
        double moneyBalance=1200;
        GeneralStore instance = new GeneralStore();
        double expResult = 500.0;
        double result = instance.purchaseSupply(supplyType, unitPriceSupply, amountToPurchase,moneyBalance);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void purchaseSupplyInvalidSupplyType() {
        String supplyType = "";
        double unitPriceSupply = 7;
        double amountToPurchase=100;
        double moneyBalance=1200;
        GeneralStore instance = new GeneralStore();
        double expResult = -1;
        double result = instance.purchaseSupply(supplyType, unitPriceSupply, amountToPurchase,moneyBalance);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void purchaseSupplyZeroUnitPriceSupply() {
        String supplyType = "Food";
        double unitPriceSupply = 0;
        double amountToPurchase=100;
        double moneyBalance=1200;
        GeneralStore instance = new GeneralStore();
        double expResult = -1;
        double result = instance.purchaseSupply(supplyType, unitPriceSupply, amountToPurchase,moneyBalance);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void purchaseSupplyZeroAmountToPurchase() {
        String supplyType = "Food";
        double unitPriceSupply = 7;
        double amountToPurchase=0;
        double moneyBalance=1200;
        GeneralStore instance = new GeneralStore();
        double expResult = -1;
        double result = instance.purchaseSupply(supplyType, unitPriceSupply, amountToPurchase,moneyBalance);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void purchaseSupplyZeroMoneyBalance() {
        String supplyType = "Food";
        double unitPriceSupply = 7;
        double amountToPurchase=100;
        double moneyBalance=0;
        GeneralStore instance = new GeneralStore();
        double expResult = -1;
        double result = instance.purchaseSupply(supplyType, unitPriceSupply, amountToPurchase,moneyBalance);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void purchaseSupplyZeroNegativeUnitPriceSupply() {
        String supplyType = "Food";
        double unitPriceSupply = -7;
        double amountToPurchase=100;
        double moneyBalance=1200;
        GeneralStore instance = new GeneralStore();
        double expResult = -1;
        double result = instance.purchaseSupply(supplyType, unitPriceSupply, amountToPurchase,moneyBalance);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void purchaseSupplyNegativeAmountToPurchase() {
        String supplyType = "Food";
        double unitPriceSupply = 7;
        double amountToPurchase=-100;
        double moneyBalance=1200;
        GeneralStore instance = new GeneralStore();
        double expResult = -1;
        double result = instance.purchaseSupply(supplyType, unitPriceSupply, amountToPurchase,moneyBalance);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void purchaseSupplyNegativeMoneyBalance() {
        String supplyType = "Food";
        double unitPriceSupply = 7;
        double amountToPurchase=100;
        double moneyBalance=-1200;
        GeneralStore instance = new GeneralStore();
        double expResult = -1;
        double result = instance.purchaseSupply(supplyType, unitPriceSupply, amountToPurchase,moneyBalance);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void purchaseSupplyZeroBoundaryUnitPriceSupply() {
        String supplyType = "Food";
        double unitPriceSupply = 0.001;
        double amountToPurchase=100;
        double moneyBalance=1200;
        GeneralStore instance = new GeneralStore();
        double expResult = 1199.9;
        double result = instance.purchaseSupply(supplyType, unitPriceSupply, amountToPurchase,moneyBalance);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void purchaseSupplyBoundaryAmountToPurchase() {
        String supplyType = "Food";
        double unitPriceSupply = 7;
        double amountToPurchase=0.001;
        double moneyBalance=1200;
        GeneralStore instance = new GeneralStore();
        double expResult = 1199.993;
        double result = instance.purchaseSupply(supplyType, unitPriceSupply, amountToPurchase,moneyBalance);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void purchaseSupplyBoundaryMoneyBalance() {
        String supplyType = "Food";
        double unitPriceSupply = 7;
        double amountToPurchase=100;
        double moneyBalance=-0.001;
        GeneralStore instance = new GeneralStore();
        double expResult = -1;
        double result = instance.purchaseSupply(supplyType, unitPriceSupply, amountToPurchase,moneyBalance);
        assertEquals(expResult, result, 0.0);
    }
}
