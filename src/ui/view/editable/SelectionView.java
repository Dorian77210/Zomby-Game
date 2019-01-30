package ui.view.editable;

import controller.base.ActionController;
import controller.view.editable.SelectionController;

import ui.view.BaseView;
import ui.view.editable.ChoiceItemView;

import helper.Palette;

import javax.swing.JButton;

import java.awt.GridLayout;

/**
  * The class <code>SelectionView</code> permits to toggle the selection of items
  * @version 1.0
  * @author Dorian Terbah 
**/

public class SelectionView extends BaseView {

    /**
     * Button to toggle to the selection of ground menu
     */
    private JButton groundSelectionButton;

    /**
     * Button to toggle to the selection of item menu
     */
    private JButton itemSelectionButton;

    /**
     * The controller of selection
     */
    private ActionController controller;

    public SelectionView(ListView listView) {
        super();

        this.setLayout(new GridLayout(1, 2));

        this.groundSelectionButton = new JButton("Grounds");
        this.itemSelectionButton = new JButton("Items");

        this.groundSelectionButton.setBackground(Palette.SELECTED_BUTTON_COLOR);
        this.itemSelectionButton.setBackground(Palette.NO_SELECTED_BUTTON_COLOR);

        this.add(this.groundSelectionButton);
        this.add(this.itemSelectionButton);

        this.controller = new SelectionController(listView, this.groundSelectionButton, this.itemSelectionButton);

    }
}