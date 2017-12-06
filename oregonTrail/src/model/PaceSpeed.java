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
    FAST(12),
    MEDIUM(8),
    SLOW(4),
    REST(0);
    
    private double pace;
    
    private PaceSpeed(double speed) {
        this.pace = speed;
    }
    
    public double getValue() {
        return pace;
    }
}
