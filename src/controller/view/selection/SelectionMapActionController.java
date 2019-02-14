package controller.view.selection;

import controller.base.ActionController;

import ui.Window;
import ui.view.selection.SelectionMapActionView;

import enums.WindowViewState;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class SelectionMapActionController extends ActionController {

    private static final String HOME_ACTION_COMMAND = "HOME_ACTION_COMMAND";

    private static final String PLAY_ACTION_COMMAND = "PLAY_ACTION_COMMAND";

    private SelectionMapActionView view;

    public SelectionMapActionController(SelectionMapActionView view, JButton home, JButton play) {
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
            window.changeViewTo(WindowViewState.IN_GAME_STATE);
        }
    }
}