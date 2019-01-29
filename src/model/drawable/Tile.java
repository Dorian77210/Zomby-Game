package model.drawable;

import java.awt.Point;
import java.awt.Polygon;

/**
  * The class <code>Tile</code> reresents a tile in the edit view
  * @version 1.0
  * @author Dorian Terbah 
**/

public class Tile extends Polygon {

    /**
     * Constant used to have the height of a tile
     */
    public static final int HEIGHT = 30;

    /**
     * Constant used to have the width of a tile
     */
    public static final int WIDTH = 30;

    public Tile(Point corner) {
        super();
        
        this.addPoint(corner.x, corner.y);
        this.addPoint(corner.x + WIDTH, corner.y);
        this.addPoint(corner.x + WIDTH, corner.y + HEIGHT);
        this.addPoint(corner.x, corner.y + HEIGHT);
    }
}