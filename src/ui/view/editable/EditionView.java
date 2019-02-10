package ui.view.editable;

import ui.view.BaseView;

import java.awt.Graphics2D;
import java.awt.Graphics;

import model.drawable.Tile;
import model.drawable.EditMapModel;
import model.sprite.ItemEntity;
import model.sprite.Entity;
import model.sprite.Surface;
import model.sprite.EntityGroup;

import controller.view.drawable.ItemDragController;
import controller.view.drawable.ItemPoseController;
import controller.view.drawable.DeleteItemController;

import helper.Palette;

import java.awt.Point;
import java.awt.Dimension;

public class EditionView extends BaseView {

    /**
     * Constant used to have the width of this view
     */
    public static final int WIDTH = 600;

    /**
     * Constant used t have the height of this view
     */
    public static final int HEIGHT = 600;

    /**
     * The tiles of the map
     */
    private Tile[][] tiles;

    /**
     * The map model
     */
    private EditMapModel model;

    private ItemDragController dragController;

    private ItemPoseController poseController;

    public EditionView(EditMapModel model) {
        super();
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.model = model;

        this.dragController = new ItemDragController(this.model, this);
        this.poseController = new ItemPoseController(this.model, this);

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

    @Override  
    public void paintComponent(Graphics p) {
        Graphics2D g = (Graphics2D)p.create();
        if(this.isOpaque()) {
            g.setColor(this.getBackground());
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
        }

        if(this.model.hasBackground()) {
            g.drawImage(this.model.background().getImage(), 0, 0, null);
        }

        

        this.displayTiles(g);

        if(this.model.hasSelectedItem()) {
            ItemEntity sprite = this.model.getSelectedItem();
            g.drawImage(sprite.getImage(), sprite.surface().x, sprite.surface().y, null);
        }

        EntityGroup group = this.model.getEntityGroup();

        for(Entity entity : group) {
            g.drawImage(entity.getImage(), entity.surface().x, entity.surface().y, null);
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

    ///////////////////////////////////////////////

    public boolean isOutOfBounds(Surface s) {
        if(s.x < 0 || s.x + s.width > WIDTH) return true;
        if(s.y < 0 || s.y + s.height > HEIGHT) return true;

        return false;
    }
}