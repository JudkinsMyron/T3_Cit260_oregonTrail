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
public enum PaceSpeed {
    FAST(5),
    MEDIUM(3),
    SLOW(1);
    
    private int pace;
    
    private PaceSpeed(int speed) {
        this.pace = speed;
    }
    
    public int getValue() {
        return pace;
    }
}
