package controller.view;

import controller.base.ActionController;

import enums.WindowViewState;

import ui.Window;
import ui.view.BaseView;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

/**
  * The class <code>HomeController</code> controls the home view
  * @version 1.0
  * @author Dorian Terbah 
**/

public class HomeController extends ActionController {

    /**
     * Constant used to describe the edit map button
     */
    private static final String EDIT_MAP_ACTION_COMMAND = "EDIT_MAP_ACTION_COMMAND";

    /**
     * Constant used to describe the choose map button
     */
    private static final String CHOOSE_MAP_ACTION_COMMAND = "CHOOSE_MAP_ACTION_COMMAND";

    /**
     * Constant used to describe the exit button
     */
    private static final String EXIT_APPLICATION_ACTION_COMMAND = "EXIT_APPLICATION_ACTION_COMMAND";

    private static final String PARAMETERS_ACTION_COMMAND = "PARAMETERS_ACTION_COMMAND";

    /**
     * A reference to the home view
     */
    private BaseView view;

    public HomeController(JButton editMap, JButton chooseMap, JButton exitApplication, 
    JButton parametersButton, BaseView view) 
    {
        //set action command for all buttons
        editMap.setActionCommand(EDIT_MAP_ACTION_COMMAND);
        chooseMap.setActionCommand(CHOOSE_MAP_ACTION_COMMAND);
        exitApplication.setActionCommand(EXIT_APPLICATION_ACTION_COMMAND);
        parametersButton.setActionCommand(PARAMETERS_ACTION_COMMAND);

        editMap.addActionListener(this);
        chooseMap.addActionListener(this);
        exitApplication.addActionListener(this);
        parametersButton.addActionListener(this);

        this.view = view;
    }

    @Override 
    public void actionPerformed(ActionEvent event) {
        String actionCommand = event.getActionCommand();
        Window window = (Window)SwingUtilities.getWindowAncestor(this.view);

        if(actionCommand.equals(EDIT_MAP_ACTION_COMMAND)) {
            window.changeViewTo(WindowViewState.EDIT_MAP_STATE);
        } else if(actionCommand.equals(CHOOSE_MAP_ACTION_COMMAND)) {
            window.changeViewTo(WindowViewState.CHOOSE_MAP_STATE);
        } else if(actionCommand.equals(EXIT_APPLICATION_ACTION_COMMAND)){
            window.closeApplicationWithMessage("Exit application...");
        } else if(actionCommand.equals(PARAMETERS_ACTION_COMMAND)) {
            window.changeViewTo(WindowViewState.PARAMETER_STATE);
        }
    }
}