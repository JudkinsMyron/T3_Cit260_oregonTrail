/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Party;

/**
 *
 * @author Myron Judkins
 */
public class FortMenu extends View {

    private Party _party = null;

    FortMenu(Party party) {

        super("\n********************************"
                + "\n*                              *"
                + "\n*     As you move away from    *"
                + "\n*     the River you notice a   *"
                + "\n*     FORT with a sign that    *"
                + "\n*     reads GENERAL STORE       *"
                + "\n*                              *"
                + "\n********************************"
                + "\n*                                        *"
                + "\n* Enter G to enter the General Store     *"
                + "\n* Enter Q to continue on past the FORT   *"
                + "\n"
                + "\n");
        _party = party;
    }

    @Override
    public boolean doAction(String input) {
        if (input.toLowerCase().equals("g")) {
            //       GeneralStore generalStore = new GeneralStore();
            // Havent greated General Store class yet (MJ)
        }
        return false;
    }

}
