package controller.view.binding;

import controller.base.MouseController;

import engine.Engine;
import engine.control.Keyboard;

import enums.GameActions;

import model.binding.ActionToTouchModel;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class SelectionTouchController extends MouseController {

    private GameActions action;

    private ActionToTouchModel model;

    private JLabel touch;

    public SelectionTouchController(JLabel touch, GameActions action, ActionToTouchModel model) {
        this.touch = touch;
        this.touch.addMouseListener(this);
        this.action = action;

        this.model = model;
    }

    @Override 
    public void mouseClicked(MouseEvent event) {
        this.touch.setText("TOUCH WAITING");
        this.model.setIsSelected(true);
        this.touch.setFocusable(true);
        this.touch.requestFocusInWindow();
    }

    @Override 
    public void mouseExited(MouseEvent event) {
        this.model.setIsSelected(false);
        Keyboard keyboard = Engine.instance().getKeyboard();
        this.touch.setText(keyboard.actionToText(this.action));
    }

    @Override 
    public void mouseEntered(MouseEvent event) {
        this.touch.setFocusable(true);
    }

    @Override 
    public void mousePressed(MouseEvent event) {
        this.touch.setFocusable(true);
    }

    @Override 
    public void mouseReleased(MouseEvent event) {
        this.touch.setFocusable(true);        
    }
}