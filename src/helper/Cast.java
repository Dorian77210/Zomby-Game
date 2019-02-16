package helper;

import enums.GameActions;

import json.JSONParser;

public class Cast {

    public static final GameActions directionToGameActions(String direction) {
        if(direction.equals(JSONParser.JSON_BOTTOM_TAG)) {
            return GameActions.MOVE_DOWN;
        } else if(direction.equals(JSONParser.JSON_TOP_TAG)) {
            return GameActions.MOVE_UP;
        } else if(direction.equals(JSONParser.JSON_LEFT_TAG)) {
            return GameActions.MOVE_LEFT;
        } else if(direction.equals(JSONParser.JSON_RIGHT_TAG)) {
            return GameActions.MOVE_RIGHT;
        }

        return null;
    }
}