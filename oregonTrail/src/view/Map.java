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
        super();
        _party = party;

        printMap(party);
        waitForEnterKey();
    }

    @Override
    public boolean doAction(String input) {
        return true;
    }

    private void printMap(Party party) {
        MapControl mapControl = new MapControl();
        String currentMap = mapControl.getMapString().substring(0, party.getMapPositions() + 5) + "X" + mapControl.getMapString().substring(party.getMapPositions() + 6, mapControl.getMapString().length());

        this.console.println("\n***************************************************"
                + "\n* This is your aproximate position on the trail   *"
                + "\n***************************************************"
                + "\n" 
                + "\n" + currentMap);

    }
}
