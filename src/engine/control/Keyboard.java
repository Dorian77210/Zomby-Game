package engine.control;

import enums.GameActions;

import java.awt.event.KeyEvent;

import java.util.HashMap;
import java.util.Map;

public class Keyboard {

    private HashMap<GameActions, String> keyBinding;

    public static final int NUMBER_OF_POSSIBLE_ACTIONS = 5;

    public Keyboard() {
        this.keyBinding = new HashMap<GameActions, String>(NUMBER_OF_POSSIBLE_ACTIONS);
        this.setDefaultKeyBinding();
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
}