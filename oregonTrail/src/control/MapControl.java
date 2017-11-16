/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import model.Party;
import model.SceneType;

/**
 *
 * @author Myron Judkins
 */
public class MapControl {

    private String mapString = "Start--------------------Oregon";
    private ArrayList<SceneType> sceneTypeList = new ArrayList<SceneType>();

    public void fillSceneTypeList() {
        sceneTypeList.add(SceneType.FORT);
        sceneTypeList.add(SceneType.TRAIL);
        sceneTypeList.add(SceneType.RIVER);
        sceneTypeList.add(SceneType.TRAIL);
        sceneTypeList.add(SceneType.TOWN);
        sceneTypeList.add(SceneType.TRAIL);
        sceneTypeList.add(SceneType.FORT);
        sceneTypeList.add(SceneType.TRAIL);
        sceneTypeList.add(SceneType.RIVER);
        sceneTypeList.add(SceneType.TRAIL);
        sceneTypeList.add(SceneType.TOWN);
        sceneTypeList.add(SceneType.TRAIL);
        sceneTypeList.add(SceneType.FORT);
        sceneTypeList.add(SceneType.TRAIL);
        sceneTypeList.add(SceneType.RIVER);
        sceneTypeList.add(SceneType.TRAIL);
        sceneTypeList.add(SceneType.TOWN);
        sceneTypeList.add(SceneType.TRAIL);
        sceneTypeList.add(SceneType.TRAIL);
        sceneTypeList.add(SceneType.OREGON);

    }

    public void printMap(Party party) {
        String currentMap = mapString.substring(0, party.getMapPositions() + 5) + "X" + mapString.substring(party.getMapPositions() + 6, mapString.length());
        
        System.out.println("\n***************************************************"
                + "\n* This is your aproximate position on the trail   *"
                + "\n***************************************************"
                + "\n" + "\n" + currentMap);

    }

    public SceneType getNextSceneType(Party party) {
        return sceneTypeList.get(party.getMapPositions());
    }
}
