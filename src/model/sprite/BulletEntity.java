package model.sprite;

import enums.GameActions;

import helper.Loader;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class BulletEntity extends Entity {

    protected Point direction;

    public static int BULLET_SPEED = 10;

    public BulletEntity(int x, int y, Point direction, String file) {
        super(x, y);
        this.direction = direction;
        this.image = Loader.loadImage(file);
    }

    @Override 
    public void update() {

    }

    @Override 
    public void update(GameActions action) {

    }
}