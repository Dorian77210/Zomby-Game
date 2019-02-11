package ui.modal;

import javax.swing.JOptionPane;

/**
  * The class <code>ExitApplicationModal</code> is a modal which appear during closig the application
  * @version 1.0
  * @author Dorian Terbah 
**/

public class SuccessModal extends JOptionPane {

    public SuccessModal(String message) {
        super();
        showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}