/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.MapControl;
import model.Party;

/**
 *
 * @author Myron Judkins
 */
public class Map extends View {

    private Party _party = null;

    Map(Party party) {
        super(
        );
        _party = party;
        MapControl mapControl = new MapControl();
        
        mapControl.printMap(party);
        waitForEnterKey();
    }

    @Override
    public boolean doAction(String input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
