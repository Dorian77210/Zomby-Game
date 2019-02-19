package algorithm;

import model.game.Node;
import model.game.GameNode;
import model.game.GameMap;

import java.awt.Point;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class AStar {

    private static List<Point> adjacents = Arrays.asList(
        new Point(0, -1), new Point(0, 1), new Point(-1, 0), new Point(1, 0),
        new Point(-1, -1), new Point(-1, 1), new Point(1, -1), new Point(1, 1)
    );

    public static final List<Point> astar(Node[][] map, Node start, Node end) {
        List<Point> path = new ArrayList<Point>();    

        GameNode startNode = new GameNode(start, null);
        GameNode endNode = new GameNode(end, null);

        GameNode currentNode;

        //initialize the open and close list
        List<GameNode> openList = new ArrayList<GameNode>();
        List<GameNode> closedList = new ArrayList<GameNode>();

        openList.add(startNode);

        while(!openList.isEmpty()) {
            currentNode = openList.get(0);
            int currentIndex = 0;

            for(int i = 0; i < openList.size(); i++) {
                GameNode item = openList.get(i);
                if(item.f < currentNode.f) {
                    currentNode = item;
                    currentIndex = i;
                }
            }

            openList.remove(currentIndex);
            closedList.add(currentNode);

            if(currentNode.equals(endNode)) {
                while(currentNode != null) {
                    path.add(currentNode.getPosition());
                    currentNode = currentNode.parent;
                }

                Collections.reverse(path);
                return path;
            }

            List<GameNode> children = new ArrayList<GameNode>();

            for(Point position : adjacents) {
                Point nodePosition = new Point(
                    currentNode.getPosition().x + position.x,
                    currentNode.getPosition().y + position.y
                );  

                if(nodePosition.x > map.length - 1 ||
                   nodePosition.x < 0 ||
                   nodePosition.y > map[0].length - 1 ||
                   nodePosition.y < 0
                ) {
                    continue;
                }

                if(map[nodePosition.x][nodePosition.y].hasEntity()) {
                    continue;
                }

                GameNode newNode = new GameNode(map[nodePosition.x][nodePosition.y], currentNode);

                children.add(newNode);
            }

            for(GameNode child : children) {
                for(GameNode closedChild : closedList) {
                    if(child.equals(closedChild)) continue;
                }

                child.f = currentNode.g + 1;
                child.h = (int)(Math.pow(child.getPosition().x - endNode.getPosition().x, 2) +
                Math.pow(child.getPosition().y - endNode.getPosition().y, 2));
                child.f = child.g + child.h;

                for(GameNode openNode : openList) {
                    if(child.equals(openNode) && child.g > openNode.g) {
                        continue;
                    }
                }

                openList.add(child);
            }
        }

        return path;
    }
}