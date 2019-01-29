package model.sprite;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Point;

/**
  * The class <code>Surface</code> reresents the surface of an entity
  * @version 1.0
  * @author Dorian Terbah 
**/

public class Surface extends Rectangle {

    /***************************** 
    *********CONSTRUCTORS*********
    *****************************/
    public Surface(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Surface(Point point, int width, int height) {
        super(point.x, point.y, width, height);
    }

    public Surface(Point point, Dimension dimension) {
        super(point.x, point.y, dimension.width, dimension.height);
    }
}