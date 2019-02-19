package model.sprite;

import enums.GameActions;

import helper.Loader;

import java.awt.Point;
import java.awt.image.BufferedImage;

import java.util.HashMap;

public class BulletEntity extends Entity {

    protected Point direction;
    
    public static HashMap<Point, String> directionToFile;

    public static int BULLET_SPEED = 10;

    public BulletEntity(int x, int y, Point direction) {
        super(x, y);
        this.direction = direction;

        this.image = Loader.loadImage(directionToFile.get(this.direction));

        this.surface = new Surface(x, y, this.image.getWidth(), this.image.getHeight());
    }

    @Override 
    public void update() {
        this.surface.x += this.direction.x;
        this.surface.y += this.direction.y;
    }

    @Override 
    public void update(GameActions action) {

    }
}