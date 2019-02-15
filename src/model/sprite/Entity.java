package model.sprite;

import java.awt.Rectangle;
import java.awt.Point;

import enums.GameActions;

import java.awt.image.BufferedImage;
import java.awt.Dimension;

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

    abstract boolean collide(Entity entity);    
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
}