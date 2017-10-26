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
public enum SupplyType {
    FOOD("Food"),
    WAGON_WHEELS ("Wagon Wheels");
    private String type;
    
    private SupplyType(String type) {
        this.type = type;
    }
}
