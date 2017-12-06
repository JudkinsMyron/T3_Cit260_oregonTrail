/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Party;

/**
 *
 * @author Kevin's Account
 */
public class BuySuppliesMenu extends View{
    private Party _party = null;

    public BuySuppliesMenu(Party party) {
        super("\n********************************"
                + "\n* What would you like to buy?  *"
                + "\n********************************"
                + "\n*                              *"
                + "\n* Enter F to buy food          *"
                + "\n* Enter W to buy wagon wheels  *"
                + "\n* Enter Q to go back           *"
                + "\n"
                + "\n");
        _party = party;
    }

    @Override
    public boolean doAction(String input) {
        if (input.toLowerCase().equals("f")) {
            BuySuppliesMenu bsm = new BuySuppliesMenu(_party);
            bsm.display();
        } else if (input.toLowerCase().equals("w")) {
            SellSuppliesMenu ssm = new SellSuppliesMenu(_party);
            ssm.display();
        }
        return false;
    }
}
