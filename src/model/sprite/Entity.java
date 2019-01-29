package model.sprite;

import java.awt.Rectangle;
import java.awt.Point;

/**
  * The class <code>Sprite</code> reresents a sprite
  * @version 1.0
  * @author Dorian Terbah 
**/

public abstract class Entity {

    public static final int WIDTH = 30;

    public static final int HEIGHT = 30;

    protected Surface surface;

    /***************************** 
    *********CONSTRUCTORS*********
    *****************************/
    public Entity(int x, int y) {
    }

    public Entity(Point point) {
    }

    abstract void collide(Entity entity);    

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
    public void surface(Surface surface) {
        this.surface = surface;
    }
}