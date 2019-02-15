package model.sprite;

import model.sprite.Entity;
import enums.GameActions;


import java.awt.image.BufferedImage;

import java.util.HashMap;

public abstract class AnimatedEntity extends Entity {

    protected HashMap<GameActions, BufferedImage[]> sprites;

    protected HashMap<GameActions, Integer> indexes;

    public AnimatedEntity(int x, int y) {
        super(x, y);
    }
}