package model.drawable;

import model.sprite.Surface;

import ui.view.editable.EditionView;

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

    public static final Point getFarestDistance(Surface s) {
        int xx = 0, yy = 0;

        for(int x = 0; x < (EditionView.WIDTH / WIDTH); x++) {
            if((x * WIDTH) <= s.x && (WIDTH * (x + 1)) >= s.x) {
                xx = x * WIDTH;
                break;
            }
        }

        for(int y = 0; y < (EditionView.HEIGHT / HEIGHT); y++) {
            if((y * WIDTH) <= s.y && (WIDTH * (y + 1)) >= s.y) {
                yy = y * WIDTH;
                break;
            }
        }

        return new Point(xx, yy);
    }
}