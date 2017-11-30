/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import model.Actor;
import model.Oxen;
import model.PaceSpeed;
import model.Party;
import model.Player;
import model.Supply;
import model.SupplyType;
import model.Wagon;
import view.DailyActivity;
import view.FortMenu;

import view.RiverCrossingMenu;

/**
 *
 * @author Myron Judkins
 */
public class StartController {

   

    public void buySupplies(Party party) {
//        shortening for developing sakes
        ArrayList<Supply> supplies = new ArrayList<>();
        Supply food = new Supply();
        food.setType(SupplyType.FOOD);
        food.setAmount(60);
        supplies.add(food);
        Supply wagonWheels = new Supply();
        wagonWheels.setType(SupplyType.WAGON_WHEELS);
        wagonWheels.setAmount(2);
        supplies.add(wagonWheels);
        party.getWagon().setSupplies(supplies);
    }
}
