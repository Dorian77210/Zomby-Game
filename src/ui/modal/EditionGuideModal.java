package ui.modal;

import javax.swing.JOptionPane;

public class EditionGuideModal extends JOptionPane {

    public EditionGuideModal() {
        super();
        String message = new StringBuilder()
                            .append("Welcome to the guide. You can select item and background to custom your map. \n")
                            .append("When you have a selected item, you can put it where you want and click on your left button of your mouse to put it. \n")
                            .append("If you click on the right click, it deletes the selected item of your hand. \n")
                            .append("You can save your map clicking on \"Export\" and update an existing map clicking on \"Import\". \n")
                            .append("You can import your own items clicking on \"Import item\". \n")
                            .toString();

        showMessageDialog(null, message, "Guide", JOptionPane.INFORMATION_MESSAGE);
    }
}
