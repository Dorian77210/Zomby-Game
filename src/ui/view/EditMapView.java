package ui.view;

import model.drawable.Tile;
import model.drawable.EditMapModel;

import ui.view.editable.ChoiceItemView;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Point;

import helper.Palette;

/**
  * The class <code>EditMapView</code> permits to create and modify map
  * @version 1.0
  * @author Dorian Terbah 
**/

public class EditMapView extends BaseView {

    /**
     * The tiles of the view
     */
    private Tile[][] tiles;

    /**
     * Constant used to have the width of this view
     */
    public static final int WIDTH = 600;

    /**
     * Constant used t have the height of this view
     */
    public static final int HEIGHT = 600;

    /**
     * The model that contains all sprites of the map
     */
    private EditMapModel model;    

    public EditMapView() {
        super();
        this.setLayout(new BorderLayout());

        this.model = new EditMapModel();

        this.add(new ChoiceItemView(this.model), BorderLayout.EAST);

        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.generateTiles();
    }

    /**
     * Generate the tiles of the view
     */
    private void generateTiles() {
        this.tiles = new Tile[HEIGHT / Tile.HEIGHT][WIDTH / Tile.HEIGHT];
        for(int y = 0; y < (HEIGHT / Tile.HEIGHT); y++) {
            for(int x = 0; x < (WIDTH / Tile.WIDTH); x++) {
                this.tiles[y][x] = new Tile(new Point(x * Tile.WIDTH, y * Tile.HEIGHT));
            }
        }
    }

    /***************************** 
    ***********DISPLAY************
    *****************************/
    @Override 
    public void paintComponent(Graphics p) {
        Graphics2D g = (Graphics2D)p.create();
        if(this.isOpaque()) {
            g.setColor(this.getBackground());
            g.fillRect(0, 0, this.getWidth(),  this.getHeight());
        }

        if(this.model.hasBackground()) {
            g.drawImage(this.model.background(), 0, 0, null);
        }

        if(this.model.canDisplayTiles()) {
            this.displayTiles(g);
        }
    }

    /**
     * Display the tiles on the view
     * @param p The brush for drawing
     */
    private void displayTiles(Graphics2D p) {
        p.setColor(Palette.TILE_BORDER_COLOR);
        Tile tile;

        for(int y = 0; y < (HEIGHT / Tile.HEIGHT); y++) {
            for(int x = 0; x < (WIDTH / Tile.WIDTH); x++) {
                tile = this.tiles[y][x];
                p.drawPolygon(tile);
            }
        }
    }
}