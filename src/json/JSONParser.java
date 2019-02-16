package json;

import model.sprite.Entity;
import model.sprite.Surface;
import model.sprite.BackgroundEntity;
import model.sprite.ItemEntity;
import model.sprite.EntityGroup;
import model.sprite.EntityGroup;

import engine.Engine;
import engine.control.Keyboard;

import enums.GameActions;

import org.json.JSONObject;

import model.drawable.EditMapModel;

import helper.Cast;
import helper.Path;
import helper.Loader;

import javax.imageio.ImageIO;

import java.io.IOException;

import java.awt.image.BufferedImage;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class JSONParser {

    public static final String BACKGROUND_JSON_TAG = "background";

    public static final String ENTITY_JSON_TAG = "entity";

    public static final String ENTITIES_JSON_TAG = "entities";

    public static final String SURFACE_JSON_TAG = "surface";

    public static final String X_JSON_TAG = "x";

    public static final String Y_JSON_TAG = "y";

    public static final String PATH_JSON_TAG = "path";
    public static final String PATHS_JSON_TAG = "paths";

    public static final String WIDTH_JSON_TAG = "width";

    public static final String HEIGHT_JSON_TAG = "height";

    public static final int JSON_INDENTATIONS = 4;

    public static final String JSON_BOTTOM_TAG = "bottom";
    public static final String JSON_TOP_TAG = "top";
    public static final String JSON_RIGHT_TAG = "right";
    public static final String JSON_LEFT_TAG = "left";

    public static final JSONObject mapToJSON(EditMapModel model) {
        JSONObject json = new JSONObject();
        JSONObject entitiesJSON = new JSONObject();
        ItemEntity entity;

        EntityGroup group = model.getEntityGroup();
        for(int i = 0; i < group.size(); i++) {
            entity = (ItemEntity)group.get(i);
            entitiesJSON.put(ENTITY_JSON_TAG + i, entity.toJSONFormat());
        }

        json.put(ENTITIES_JSON_TAG, entitiesJSON);

        BackgroundEntity background = model.background();
        json.put(BACKGROUND_JSON_TAG, background.toJSONFormat());

        return json;
    }

    public static final void jsonToMap(EditMapModel model, JSONObject json) {
        model.clear();
        EntityGroup group = model.getEntityGroup();
        JSONObject backgroundJSON = json.getJSONObject(BACKGROUND_JSON_TAG);
        String background = backgroundJSON.getString(PATH_JSON_TAG);
        model.background(background);

        JSONObject surface, entity;
        String path = "";

        int x = 0, y = 0;
        JSONObject entities = json.getJSONObject(ENTITIES_JSON_TAG);

        for(String key : JSONObject.getNames(entities)) {
            entity = entities.getJSONObject(key);
            path = entity.getString(PATH_JSON_TAG);
            surface = entity.getJSONObject(SURFACE_JSON_TAG);
            x = surface.getInt(X_JSON_TAG);
            y = surface.getInt(Y_JSON_TAG);

            group.add(new ItemEntity(x, y, path));
        }
    }

    public static final EditMapModel jsonToMap(JSONObject json) {
        EditMapModel model = new EditMapModel();
        jsonToMap(model, json);

        return model;
    }

    public static final JSONObject keyboardToJSON() {
        return Engine.instance().getKeyboard().toJSONFormat();
    }

    public static final HashMap<GameActions, String> jsonToKeyboard(JSONObject json) {
        HashMap<GameActions, String> keyBinding = new HashMap<GameActions, String>(Keyboard.NUMBER_OF_POSSIBLE_ACTIONS);
        List<GameActions> actions = Arrays.asList(GameActions.MOVE_DOWN, GameActions.MOVE_UP, GameActions.MOVE_RIGHT, GameActions.MOVE_LEFT, GameActions.SHOOT);
        
        String touch = "";
        String[] keys = JSONObject.getNames(json);
        Arrays.sort(keys);

        for(String key : keys) {
            //find the action
            touch = json.getString(key);
            for(GameActions action : actions) {
                if(action.toString().equals(key)) {
                    keyBinding.put(action, touch);
                }
            }
        }

        return keyBinding;
    }

    public static final HashMap<GameActions, List<BufferedImage>> jsonToCharacter(JSONObject json) {
        HashMap<GameActions, List<BufferedImage>> images = new HashMap<GameActions, List<BufferedImage>>();
        List<BufferedImage> list;

        String[] directions = JSONObject.getNames(json);
        JSONObject pathsJSON, directionJSON;

        String imagePath;

        for(String direction : directions) {
            list = new ArrayList<BufferedImage>();
            directionJSON = json.getJSONObject(direction);

            pathsJSON = directionJSON.getJSONObject(PATHS_JSON_TAG);

            for(String path : JSONObject.getNames(pathsJSON)) {
                imagePath = pathsJSON.getString(path);
                list.add(Loader.loadImage(imagePath));
            }

            GameActions actions = Cast.directionToGameActions(direction);
            images.put(actions, list);
        }

        return images;
    }
}