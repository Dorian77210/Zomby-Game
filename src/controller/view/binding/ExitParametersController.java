package controller.view.binding;

import controller.base.ActionController;

import ui.Window;
import ui.view.binding.ExitParametersView;
import ui.modal.SuccessModal;

import enums.WindowViewState;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class ExitParametersController extends ActionController {

    private static final String EXIT_PARAMETERS_ACTION_COMMAND = "EXIT_PARAMETERS_ACTION_COMMAND";

    private ExitParametersView view;

    public ExitParametersController(JButton back, ExitParametersView view) {
        back.setActionCommand(EXIT_PARAMETERS_ACTION_COMMAND);
        back.addActionListener(this);

        this.view = view;
    }

    @Override 
    public void actionPerformed(ActionEvent event) {
        String actionCommand = event.getActionCommand();
        if(actionCommand.equals(EXIT_PARAMETERS_ACTION_COMMAND)) {
            Window window = (Window)SwingUtilities.getWindowAncestor(this.view);
            SuccessModal modal = new SuccessModal("Your touches have been saved");
            window.changeViewTo(WindowViewState.HOME_STATE);
        }
    }
}