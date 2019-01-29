package ui;

import ui.view.HomeView;
import ui.view.BaseView;

import javax.swing.JFrame;

import java.awt.BorderLayout;

/**
  * The class <code>Window</code> is the graphics interface of the application
  * @version 1.0
  * @author Dorian Terbah 
**/

public class Window extends JFrame {

    /**
     * Constant used to have an initial width for the window
     */
    private static final int WIDTH = 500;

    /**
     * Constant used to have an initial height for the window
     */
    private static final int HEIGHT = 500;

    /**
     * The current view displayed on the window
     */
    private BaseView currentView;

    public Window() {
        super("Zomby Game");

        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //default view
        this.currentView = new HomeView();
    }
}