package controller.view.game;

import model.game.GameModel;

import ui.view.game.GameView;

import controller.base.KeyController;

import java.awt.event.KeyEvent;

public class GameController extends KeyController {

    private GameView view;

    public GameController(GameView view) {
        this.view = view;
        this.view.addKeyListener(this);
    }

    
}