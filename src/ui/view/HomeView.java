package ui.view;

import controller.view.HomeController;

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
    private JButton editMap;

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

     private JButton parametersButton;

    private HomeController controller;

    public HomeView() {
        super();
        
        this.editMap = new JButton("Edit maps");
        this.chooseMap = new JButton("Choose map");
        this.exitApplication = new JButton("Exit application");
        this.parametersButton = new JButton("Parameters");

        //add the buttons to the view
        this.add(this.editMap);
        this.add(this.chooseMap);
        this.add(this.exitApplication);
        this.add(this.parametersButton);

        this.controller = new HomeController(this.editMap, this.chooseMap, this.exitApplication, this.parametersButton, this);
    }
}