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
    FORT("Passing a Fort"),
    TOWN ("Passing a Town"),
    TRAIL ("Daily Trail"),
    RIVER ("Cross a River"),
    OREGON ("You Made It");
        private String type;
    
    private SceneType(String type) {
        this.type = type;
    }
}
