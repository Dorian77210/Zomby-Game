package engine.control;

import helper.Path;

import json.JSONParser;
import json.imports.JSONImport;

import enums.GameActions;

import java.awt.event.KeyEvent;

import java.util.HashMap;
import java.util.Map;

import java.io.File;

import org.json.JSONObject;

public class Keyboard {

    private HashMap<GameActions, String> keyBinding;

    public static final int NUMBER_OF_POSSIBLE_ACTIONS = 5;

    public Keyboard() {
        File file = new File(Path.KEY_CONFIG_PATH);
        if(file.exists()) {
            this.keyBinding = JSONParser.jsonToKeyboard(new JSONObject(JSONImport.load(file)));
        } else {
            this.keyBinding = new HashMap<GameActions, String>(NUMBER_OF_POSSIBLE_ACTIONS);
            this.setDefaultKeyBinding();
        }
    }

    private void setDefaultKeyBinding() {
        this.keyBinding.put(GameActions.SHOOT, KeyEvent.getKeyText(KeyEvent.VK_A));
        this.keyBinding.put(GameActions.MOVE_DOWN, KeyEvent.getKeyText(KeyEvent.VK_S));
        this.keyBinding.put(GameActions.MOVE_UP, KeyEvent.getKeyText(KeyEvent.VK_Z));
        this.keyBinding.put(GameActions.MOVE_LEFT, KeyEvent.getKeyText(KeyEvent.VK_Q));
        this.keyBinding.put(GameActions.MOVE_RIGHT, KeyEvent.getKeyText(KeyEvent.VK_D));
    }

    public void bind(GameActions action, String key) {
        this.keyBinding.put(action, key);
    }

    public String actionToText(GameActions action) {
        return this.keyBinding.get(action);
    }

    public HashMap<GameActions, String> getKeyBinding() {
        return this.keyBinding;
    }

    public GameActions touchToAction(String touch) {
        for(Map.Entry<GameActions, String> entry : this.keyBinding.entrySet()) {
            GameActions key = entry.getKey();
            String value = entry.getValue();
            if(value.equals(touch)) return key;
        }

        return null;
    }

    public boolean isValidTouch(String touch) {
        return !this.keyBinding.containsValue(touch);
    }

    public JSONObject toJSONFormat() {
        JSONObject json = new JSONObject();
        for(Map.Entry<GameActions, String> entry : this.keyBinding.entrySet()) {
            GameActions action = entry.getKey();
            String value = entry.getValue();
            json.put(action.toString(), value);
        }

        return json;
    }
}