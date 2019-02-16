package model.sprite;

import model.sprite.Entity;
import enums.GameActions;

import java.awt.image.BufferedImage;

import java.util.HashMap;
import java.util.List;

public abstract class AnimatedEntity extends Entity {

    protected HashMap<GameActions, List<BufferedImage>> sprites;

    protected List<BufferedImage> currentList;

    protected int index;

    public AnimatedEntity(int x, int y) {
        super(x, y);
    }
}