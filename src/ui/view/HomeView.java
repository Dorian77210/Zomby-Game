package ui.view;

import ui.view.BaseView;

import javax.swing.JButton;

import java.awt.FlowLayout;


/**
  * The class <code>HomeView</code> represents the first view displayed on the window
  * @version 1.0
  * @author Dorian Terbah 
**/

public class HomeView extends BaseView {

    /**
     * A button to access to the editable menu
     */
    private JButton editableMap;

    /**
     * A button to access to the coos menu of map
     */
    private JButton chooseMap;

    /**
     * Button to go out of the app
     */
    private JButton exitApplication;

    /**
     * The input controller for the home
     */
    private HomeController controller;

    public HomeView() {
        super();
        
    }
}