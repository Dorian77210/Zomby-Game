package model.sprite;

import java.awt.Rectangle;
import java.awt.Point;

import enums.GameActions;

import java.awt.image.BufferedImage;
import java.awt.Dimension;

import java.util.ArrayList;
import java.util.List;

/**
  * The class <code>Sprite</code> represents a sprite
  * @version 1.0
  * @author Dorian Terbah 
**/

public abstract class Entity {

    public static final int WIDTH = 30;

    public static final int HEIGHT = 30;

    protected Surface surface;

    protected BufferedImage image;

    /***************************** 
    *********CONSTRUCTORS*********
    *****************************/
    public Entity(int x, int y) {
    }

    public boolean collide(Entity entity) {
        return this.surface.intersects(entity.surface);
    }

    abstract void update();
    abstract void update(GameActions action);

    /***************************** 
    ***********GETTER************
    *****************************/
    
    /**
     * Get the surface of the rectangle
     * * @return The surface of this entity
     */
    public Surface surface() {
        return this.surface;
    }

    /***************************** 
    ***********SETTER************
    *****************************/

    /**
     * Set a new surface for the entity
     * @param surface The new surface
     */
    public void surface(Point p) {
        this.surface = new Surface(p, this.surface.width, this.surface.height);
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public List<Point> positionToTiles() {
        List<Point> range = new ArrayList<Point>();

        int loopX = this.surface.width / PlayerEntity.PLAYER_SPEED;
        int loopY = this.surface.height / PlayerEntity.PLAYER_SPEED;

        int xx = this.surface.x / PlayerEntity.PLAYER_SPEED + loopX;
        int yy = this.surface.y / PlayerEntity.PLAYER_SPEED + loopY;

        for(int y = this.surface.y / PlayerEntity.PLAYER_SPEED; y < yy; y++) {
            for(int x = this.surface.x / PlayerEntity.PLAYER_SPEED; x < xx; x++) {
                range.add(new Point(x, y));
            }
        }

        return range;
    }

    public Point positionToTile() {
        return new Point(this.surface.x / PlayerEntity.PLAYER_SPEED, this.surface.y / PlayerEntity.PLAYER_SPEED);
    }
}