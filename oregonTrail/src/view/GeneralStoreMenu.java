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
public class GeneralStoreMenu extends View {

    private Party _party = null;

    public GeneralStoreMenu(Party party) {
        super("\n********************************"
                + "\n*                              *"
                + "\n*     You enter a small store  *"
                + "\n*     that has everything      *"
                + "\n*     you could want on your   *"
                + "\n*     way to Oregon.           *"
                + "\n*                              *"
                + "\n********************************"
                + "\n*                              *"
                + "\n* Enter B to buy supplies      *"
                + "\n* Enter S to sell supplies     *"
                + "\n* Enter Q to leave the Store   *"
                + "\n"
                + "\n");
        _party = party;
    }

    @Override
    public boolean doAction(String input) {
        if (input.toLowerCase().equals("b")) {
            BuySuppliesMenu bsm = new BuySuppliesMenu(_party);
            bsm.display();
        } else if (input.toLowerCase().equals("s")) {
            SellSuppliesMenu ssm = new SellSuppliesMenu(_party);
            ssm.display();
        }
        return false;
    }

    

}
