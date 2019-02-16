package engine;

import model.game.GameModel;
import model.sprite.BulletEntity;
import model.game.Player;

import helper.Path;

import engine.control.Keyboard;

import java.awt.Point;
import java.util.HashMap;

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

        this.initializeBulletMap();
    }

    private void initializeBulletMap() {
        int speed = BulletEntity.BULLET_SPEED;
        HashMap<Point, String> map = new HashMap<Point, String>(4);

        map.put(new Point(speed, 0), Path.BULLET_IMAGES_PATH + "/bullet-right.png");
        map.put(new Point(-speed, 0), Path.BULLET_IMAGES_PATH + "/bullet-left.png");
        map.put(new Point(0, speed), Path.BULLET_IMAGES_PATH + "/bullet-bottom.png");
        map.put(new Point(0, -speed), Path.BULLET_IMAGES_PATH + "/bullet-top.png");

        BulletEntity.directionToFile = map;
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