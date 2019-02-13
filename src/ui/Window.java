package ui;

import ui.view.HomeView;
import ui.view.BaseView;
import ui.view.EditMapView;
import ui.view.binding.BindingTouchView;
import ui.modal.ExitApplicationModal;

import enums.WindowViewState;

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

    /**
     * The current state for the component displayed in the window
     */
    private WindowViewState state;

    public Window() {
        super("Zomby Game");

        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //default view
        this.state = WindowViewState.HOME_STATE;
        this.currentView = new HomeView();
        this.add(this.currentView, BorderLayout.CENTER);

    }

    /**
     * Change the view according to a new state
     * @param state The new state 
     */
    public void changeViewTo(WindowViewState state) {
        this.state = state;
        this.remove(this.currentView);

        this.setSize(WIDTH, HEIGHT);

        if(this.state.equals(WindowViewState.HOME_STATE)) {
            this.currentView = new HomeView();
        } else if(this.state.equals(WindowViewState.IN_GAME_STATE)) {

        } else if(this.state.equals(WindowViewState.EDIT_MAP_STATE)) {
            this.setSize(900, 900);
            this.currentView = new EditMapView();
        } else if(this.state.equals(WindowViewState.CHOOSE_MAP_STATE)) {

        } else if(this.state.equals(WindowViewState.PARAMETER_STATE)) {
            this.currentView = new BindingTouchView();
        }

        this.add(this.currentView);
        this.revalidate();
    }

    public void closeApplicationWithMessage(String message) {
        ExitApplicationModal modal = new ExitApplicationModal(message);
        this.dispose();
    }
}