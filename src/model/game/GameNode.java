package model.game;

import java.awt.Point;

public class GameNode {

    public GameNode parent;

    private Node node;

    public int g;
    public int h;
    public int f;

    public GameNode(Node node, GameNode parent) {
        this.node = node;
        this.parent = parent;

        this.g = 0;
        this.h = 0;
        this.f = 0;
    }

    public Point getPosition() {
        return this.node.getPoint();
    }

    public boolean equals(GameNode n) {
        return (this.node.getX() == n.node.getX() && (this.node.getY() == n.node.getY()));
    }
}