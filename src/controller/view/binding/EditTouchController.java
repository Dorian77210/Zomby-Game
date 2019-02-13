package controller.view.binding;

import controller.base.KeyController;

import engine.Engine;
import engine.control.Keyboard;

import enums.GameActions;

import model.binding.ActionToTouchModel;

import java.awt.event.KeyEvent;

import javax.swing.JLabel;

public class EditTouchController extends KeyController {

    private ActionToTouchModel model;

    private GameActions action;

    private JLabel touch;

    public EditTouchController(JLabel touch, ActionToTouchModel model, GameActions action) {
        this.touch = touch;
        this.touch.addKeyListener(this);
        this.model = model;
        this.action = action;
    }

    @Override 
    public void keyPressed(KeyEvent event) {
        if(this.model.isSelected()) {
            Keyboard keyboard = Engine.instance().getKeyboard();
            int keyCode = event.getKeyCode();
            String keyText = KeyEvent.getKeyText(keyCode);

            if(keyboard.isValidTouch(keyText)) {
                keyboard.bind(this.action, keyText);
                this.model.setIsSelected(false);
                this.touch.setText(keyText);
            }
        }
    }

    @Override 
    public void keyTyped(KeyEvent event) {

    }

    @Override 
    public void keyReleased(KeyEvent event) {

    }

}