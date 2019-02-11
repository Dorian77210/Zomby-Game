package controller.base;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
/**
  * The class <code>KeyController</code> is the base of key controller
  * @version 1.0
  * @author Dorian Terbah 
**/

public class KeyController extends KeyAdapter {

    //default constructor
    public KeyController() {
        //void
    }

    @Override 
    public void keyPressed(KeyEvent event) {
        super.keyPressed(event);
    }

    @Override 
    public void keyReleased(KeyEvent event) {
        super.keyTyped(event);

    }

    @Override 
    public void keyTyped(KeyEvent event) {
        super.keyTyped(event);        
    }
}