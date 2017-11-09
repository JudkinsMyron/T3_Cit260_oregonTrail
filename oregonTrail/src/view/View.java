/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Kevin's Account
 */
public abstract class View extends MenuTools implements ViewInterface {
    protected String menu;
    
    public View() {
        
    }
    
    public View(String message) {
        this.menu = message;
    }
    
    @Override
    public void display() {
        boolean done = false;
        do {
            System.out.println(this.menu);
            String input = getMenuFeedback();
            if (input.toLowerCase().equals("q"))
                return;
            
            done = this.doAction(input);
        } while (!done);
    }
}
