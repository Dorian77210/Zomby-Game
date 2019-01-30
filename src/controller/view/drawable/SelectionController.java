package controller.view.drawable;

import controller.base.ActionController;

import ui.view.editable.ChoiceItemView;
import ui.view.editable.ListView;

import helper.Palette;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

/**
  * The class <code>SelectionController</code> controls the selection of item 
  * @version 1.0
  * @author Dorian Terbah 
**/

public class SelectionController extends ActionController {

    /**
     * View of the selection of item
     */
    private ListView listView;

    /**
     * Constant used to describe the choice ground button
     */
    private static final String CHOICE_GROUND_ACTION_COMMAND = "CHOICE_GROUND_ACTION_COMMAND";

    /**
     * Constant used to describe the choice item button
     */
    private static final String CHOICE_ITEM_ACTION_COMMAND = "CHOICE_ITEM_ACTION_COMMAND";

    /**
     * Button to choice the ground of the map
     */
    private JButton groundSelectionButton;

    /**
     * Button to choice items for the map
     */
    private JButton itemSelectionButton;

    public SelectionController(ListView listView, JButton groundSelectionButton, JButton itemSelectionButton) { 
        this.listView = listView;
        this.groundSelectionButton = groundSelectionButton;
        this.itemSelectionButton = itemSelectionButton;

        //add the listener of the buttons
        this.groundSelectionButton.setActionCommand(CHOICE_GROUND_ACTION_COMMAND);
        this.itemSelectionButton.setActionCommand(CHOICE_ITEM_ACTION_COMMAND);

        this.groundSelectionButton.addActionListener(this);
        this.itemSelectionButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String actionCommand = event.getActionCommand();
        String tag = actionCommand.equals(CHOICE_GROUND_ACTION_COMMAND)
                     ? ChoiceItemView.GROUND_CHOICE_VIEW
                     : ChoiceItemView.ITEM_CHOICE_VIEW;

        //change colors for the buttons
        if(tag.equals(ChoiceItemView.GROUND_CHOICE_VIEW)) {
            this.groundSelectionButton.setBackground(Palette.SELECTED_BUTTON_COLOR);
            this.itemSelectionButton.setBackground(Palette.NO_SELECTED_BUTTON_COLOR);
        } else {
            this.groundSelectionButton.setBackground(Palette.NO_SELECTED_BUTTON_COLOR);
            this.itemSelectionButton.setBackground(Palette.SELECTED_BUTTON_COLOR);
        }

        this.listView.show(tag);
        
    }
}