package ui.view.binding;

import controller.view.binding.SelectionTouchController;
import controller.view.binding.EditTouchController;

import ui.view.BaseView;

import engine.Engine;
import engine.control.Keyboard;

import enums.GameActions;

import helper.Palette;

import model.binding.ActionToTouchModel;

import javax.swing.BorderFactory;

import java.awt.GridLayout;

import javax.swing.JLabel;

public class ActionToTouchView extends BaseView {

    private JLabel actionDisplay;

    private JLabel touch;

    private GameActions action;

    private ActionToTouchModel model;

    private EditTouchController editTouchController;

    private SelectionTouchController selectionTouchController;

    public ActionToTouchView(GameActions action) {
        super();
        this.model = new ActionToTouchModel();

        this.setLayout(new GridLayout(1, 2));
        this.action = action;

        Keyboard keyboard = Engine.instance().getKeyboard();

        this.actionDisplay = new JLabel(this.action.toString());
        this.actionDisplay.setHorizontalTextPosition(JLabel.LEADING);

        this.touch = new JLabel(keyboard.actionToText(this.action));


        //adding
        this.add(this.actionDisplay);
        this.add(this.touch);

        //add border
        this.setBorder(BorderFactory.createLineBorder(Palette.PARAMETER_BORDER_COLOR));

        //controllers
        this.selectionTouchController = new SelectionTouchController(this.touch, this.action, this.model);
        this.editTouchController = new EditTouchController(this.touch, this.model, this.action);
    }   
}