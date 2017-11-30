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
public enum SceneType {
    FORT("Fort"),
    TOWN ("Town"),
    TRAIL ("Trail"),
    RIVER ("River"),
    OREGON ("Oregon");
        public String type;
    
    private SceneType(String type) {
        this.type = type;
    }
}
