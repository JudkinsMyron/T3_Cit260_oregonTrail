/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Party;
import model.SupplyType;

/**
 *
 * @author Kevin's Account
 */
public class SellSuppliesMenu extends View{
    private Party _party = null;

    public SellSuppliesMenu(Party party) {
        super("\n********************************"
                + "\n* What would you like to sell? *"
                + "\n********************************"
                + "\n*                              *"
                + "\n* Enter F to sell food         *"
                + "\n* Enter W to sell wagon wheels *"
                + "\n* Enter Q to go back           *"
                + "\n"
                + "\n");
        _party = party;
    }
    
    @Override
    public boolean doAction(String input) {
        SupplyType type = null;
        if (input.toLowerCase().equals("f")) {
            type = SupplyType.FOOD;
        } else if (input.toLowerCase().equals("w")) {
            type = SupplyType.WAGON_WHEELS;
        }
        getAmount();
        return false;
    }

    private void getAmount() {
        this.console.println("How much would you like to sell");
        getPlayerFeedback();
    }
}
