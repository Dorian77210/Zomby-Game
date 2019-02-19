package model.game;

import java.awt.Point;

public class Node {

    private Point point;

    private boolean hasEntity;

    public Node(Point point, boolean hasEntity) {
        this.point = point;
        this.hasEntity = hasEntity;
    }

    public Point getPoint() {
        return this.point;
    }

    public int getX() {
        return this.point.x;
    }

    public int getY() {
        return this.point.y;
    }

    public boolean hasEntity() {
        return this.hasEntity;
    }

    @Override 
    public String toString() {
        String str = "";
        str += this.hasEntity ? 1 : 0;
        return str;
    }
}