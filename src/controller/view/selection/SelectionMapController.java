package controller.view.selection;

import controller.base.ActionController;

import ui.view.selection.SelectionMapView;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class SelectionMapController extends ActionController {

    private static final String NEXT_ACTION_COMMAND = "NEXT_ACTION_COMMAND";

    private static final String PREVIOUS_ACTION_COMMAND = "PREVIOUS_ACTION_COMMAND";

    private SelectionMapView view;

    public SelectionMapController(SelectionMapView view, JButton next, JButton previous) {
        next.setActionCommand(NEXT_ACTION_COMMAND);
        next.addActionListener(this);

        previous.setActionCommand(PREVIOUS_ACTION_COMMAND);
        previous.addActionListener(this);

        this.view = view;
    }

    @Override 
    public void actionPerformed(ActionEvent event) {
        String actionCommand = event.getActionCommand();
        if(actionCommand.equals(NEXT_ACTION_COMMAND)) {
            this.view.next();
        } else if(actionCommand.equals(PREVIOUS_ACTION_COMMAND)) {
            this.view.previous();
        }

        this.view.repaint();
    }
}