package model.game;

import model.sprite.Entity;
import model.sprite.EntityGroup;
import model.sprite.PlayerEntity;

import ui.view.editable.EditionView;

import algorithm.AStar;

import java.awt.Point;

public class GameMap {

    private Node[][] nodes;

    public static final int WIDTH = EditionView.WIDTH / PlayerEntity.PLAYER_SPEED;
    public static final int HEIGHT = EditionView.HEIGHT / PlayerEntity.PLAYER_SPEED;

    public GameMap(EntityGroup items) {  
        this.nodes = new Node[HEIGHT][WIDTH];
        this.generateMap(items);


        for(Point p : AStar.astar(this.nodes, new Node(new Point(0,0), false), new Node(new Point(2, 30), false))) {
            System.out.println(p);
        }
    }

    private void generateMap(EntityGroup group) {
        //begin to
        Point p; 
        for(Entity entity : group) {
            for(Point point : entity.positionToTiles()) {
                this.nodes[point.y][point.x] = new Node(point, true);
            }
        }

        //fill the rest
        for(int y = 0; y < EditionView.HEIGHT / PlayerEntity.PLAYER_SPEED; y++) {
            for(int x = 0; x < EditionView.WIDTH / PlayerEntity.PLAYER_SPEED; x++) {
                p = new Point(x, y);
                if(this.nodes[p.y][p.x] == null) {
                    this.nodes[p.y][p.x] = new Node(p, false);
                }
            }
        }
    }

    @Override 
    public String toString() {
        String str = "";
        Node node;

        for(int y = 0; y < EditionView.HEIGHT / PlayerEntity.PLAYER_SPEED; y++) {
            for(int x = 0; x < EditionView.WIDTH / PlayerEntity.PLAYER_SPEED; x++) {
                node = this.nodes[y][x];
                str += node.toString();
            }

            str += "\n";
        }

        return str;
    }
}