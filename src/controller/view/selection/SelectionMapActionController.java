package controller.view.selection;

import controller.base.ActionController;

import ui.Window;
import ui.view.selection.SelectionMapActionView;
import ui.view.selection.SelectionMapView;

import enums.WindowViewState;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class SelectionMapActionController extends ActionController {

    private static final String HOME_ACTION_COMMAND = "HOME_ACTION_COMMAND";

    private static final String PLAY_ACTION_COMMAND = "PLAY_ACTION_COMMAND";

    private SelectionMapView view;



    public SelectionMapActionController(SelectionMapView view, JButton home, JButton play) {
        this.view = view;

        home.setActionCommand(HOME_ACTION_COMMAND);
        home.addActionListener(this);

        play.setActionCommand(PLAY_ACTION_COMMAND);
        play.addActionListener(this);
    }

    @Override 
    public void actionPerformed(ActionEvent event) {
        String actionCommand = event.getActionCommand();
        Window window = (Window)SwingUtilities.getWindowAncestor(this.view);
        if(actionCommand.equals(HOME_ACTION_COMMAND)) {
            window.changeViewTo(WindowViewState.HOME_STATE);
        } else if(actionCommand.equals(PLAY_ACTION_COMMAND)) {
            window.changeViewToGame(this.view.currentMap());
        }
    }
}