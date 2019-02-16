package engine;

import model.game.GameModel;

import model.game.Player;

import engine.control.Keyboard;

public class Engine {

    private static Engine engine;

    private Keyboard keyboard;

    private GameModel model;

    private boolean isAlreadyInit;

    private Player player;

    private Engine() {
        this.keyboard = new Keyboard();
        this.model = null;
        this.isAlreadyInit = false;
        this.player = new Player();
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

    public Player getPlayer() {
        return this.player;
    }

    public void initializeGame(GameModel model) {
        if(!this.isAlreadyInit) {
            this.isAlreadyInit = true;
            this.model = model;
        }
    }
}