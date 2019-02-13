package controller.view.binding;

import controller.base.ActionController;

import ui.Window;
import ui.view.binding.ExitParametersView;
import ui.modal.SuccessModal;
import ui.modal.ErrorModal;

import enums.WindowViewState;

import helper.Path;

import json.JSONParser;
import json.export.JSONExport;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class ExitParametersController extends ActionController {

    private static final String EXIT_PARAMETERS_ACTION_COMMAND = "EXIT_PARAMETERS_ACTION_COMMAND";

    private ExitParametersView view;

    public ExitParametersController(JButton saveAndBack, ExitParametersView view) {
        saveAndBack.setActionCommand(EXIT_PARAMETERS_ACTION_COMMAND);
        saveAndBack.addActionListener(this);

        this.view = view;
    }

    @Override 
    public void actionPerformed(ActionEvent event) {
        String actionCommand = event.getActionCommand();
        if(actionCommand.equals(EXIT_PARAMETERS_ACTION_COMMAND)) {
            Window window = (Window)SwingUtilities.getWindowAncestor(this.view);
            if(JSONExport.exportJSON(JSONParser.keyboardToJSON().toString(JSONParser.JSON_INDENTATIONS), new File(Path.KEY_CONFIG_PATH))) {
                SuccessModal modal = new SuccessModal("Your touches have been saved");
            } else {
                ErrorModal modal = new ErrorModal("Error when saving your touches configuration");
            }

            window.changeViewTo(WindowViewState.HOME_STATE);
        }
    }
}