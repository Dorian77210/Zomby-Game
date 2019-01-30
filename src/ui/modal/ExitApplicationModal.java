package ui.modal;

import javax.swing.JOptionPane;

/**
  * The class <code>ExitApplicationModal</code> is a modal which appear during closig the application
  * @version 1.0
  * @author Dorian Terbah 
**/

public class ExitApplicationModal extends JOptionPane {

    public ExitApplicationModal(String message) {
        super();
        showMessageDialog(null, message, "Closing application" JOptionPane.INFORMATION_MESSAGE);
    }
}