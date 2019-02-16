package controller.view.game;

import controller.base.KeyController;

import model.game.Player;

import ui.view.game.GameView;

import enums.GameActions;

import engine.Engine;
import engine.control.Keyboard;

import java.awt.event.KeyEvent;

public class GameController extends KeyController {

    private GameView gameView;

    public GameController(GameView gameView) {
        this.gameView = gameView;
        this.gameView.addKeyListener(this);

        this.gameView.setFocusable(true);
        this.gameView.requestFocusInWindow();
    }

    @Override 
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        String touch = KeyEvent.getKeyText(keyCode);


        //retrieve GameActions
        final Keyboard keyboard = Engine.instance().getKeyboard();
        GameActions action = keyboard.touchToAction(touch);

        if(action != null) {
            Player player = Engine.instance().getPlayer();
            player.entity().update(action);
        }
    }

    @Override 
    public void keyTyped(KeyEvent event) {
        this.gameView.setFocusable(true);
    }

    @Override 
    public void keyReleased(KeyEvent event) {
        this.gameView.setFocusable(true);
    }
}