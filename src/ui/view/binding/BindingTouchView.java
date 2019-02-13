package ui.view.binding;

import enums.GameActions;

import ui.view.BaseView;
import ui.view.binding.ActionToTouchView;

import engine.Engine;
import engine.control.Keyboard;

import java.awt.GridLayout;

import java.util.HashMap;
import java.util.Map;

public class BindingTouchView extends BaseView {

    public BindingTouchView() {
        super();
        this.setLayout(new GridLayout(Keyboard.NUMBER_OF_POSSIBLE_ACTIONS + 1, 1));

        //generate the views
        Keyboard keyboard = Engine.instance().getKeyboard();
        HashMap<GameActions, String> keyBinding = keyboard.getKeyBinding();

        for(Map.Entry<GameActions, String> entry : keyBinding.entrySet()) {
            GameActions action = entry.getKey();
            this.add(new ActionToTouchView(action));
        }

        this.add(new ExitParametersView());
    }
}