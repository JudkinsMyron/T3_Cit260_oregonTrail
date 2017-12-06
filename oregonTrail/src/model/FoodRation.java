/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Kevin's Account
 */
public enum FoodRation {
    LARGE(5),
    MEDIUM(3),
    SMALL(1);
    
    private double ration;
    
    private FoodRation(double portion) {
        this.ration = portion;
    }
    
    public double getValue() {
        return ration;
    }
}
