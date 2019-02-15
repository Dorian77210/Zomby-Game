package engine;

import model.game.GameModel;

import engine.control.Keyboard;

public class Engine {

    private static Engine engine;

    private Keyboard keyboard;

    private GameModel model;

    private boolean isAlreadyInit;

    private Engine() {
        this.keyboard = new Keyboard();
        this.model = null;
        this.isAlreadyInit = false;
    }

    public static Engine instance() {
        if(engine == null) {
            engine = new Engine();
        }

        return engine;
    }

    public Keyboard getKeyboard() {
        return this.keyboard;
    }

    public GameModel getGameModel() {
        return this.model;
    }

    public void initializeGame(GameModel model) {
        if(!this.isAlreadyInit) {
            this.isAlreadyInit = true;
            this.model = model;
        }
    }
}