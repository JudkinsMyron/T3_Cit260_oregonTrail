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

    private final String mapString = "Start--------------------Oregon";
    private ArrayList<SceneType> sceneTypeList = new ArrayList<SceneType>();

    public String getMapString() {
        return mapString;
    }

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

    public SceneType getNextSceneType(Party party) {
        fillSceneTypeList();
        return sceneTypeList.get(party.getMapPositions());
    }
}
