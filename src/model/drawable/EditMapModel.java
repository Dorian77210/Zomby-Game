package model.drawable;

import ui.view.EditMapView;
import ui.view.editable.EditionView;

import model.sprite.Entity;
import model.sprite.ItemEntity;
import model.sprite.EntityGroup;
import model.sprite.BackgroundEntity;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
  * The class <code>EditMapModel</code> represents the model of the edit map
  * @version 1.0
  * @author Dorian Terbah 
**/

public class EditMapModel {

    /**
     * Boolean to know if the view must to display the tiles or not
     */
    private boolean canDisplayTiles;

    /**
     * Background image of the map
     */
    private BackgroundEntity backgroundImage;

    private ItemEntity selectedSprite;

    private EntityGroup group;

    public EditMapModel() { 
        this.canDisplayTiles = true; //default value
        this.backgroundImage = null;
        this.group = new EntityGroup();
    }

    public void addWithVerification(Entity entity) {
        if(!this.group.contains(entity)) {
            this.group.add(entity);
        }
    }

    /***************************** 
    ************GETTER************
    *****************************/

    public EntityGroup getEntityGroup() {
        return this.group;
    }

    /**
     * Get if the view can display the tiles
     * @return True if it is, else false
     */
    public boolean canDisplayTiles() {
        return this.canDisplayTiles;
    }

    /**
     * Get the background of the map
     * @return The background of the map
     */
    public BackgroundEntity background() {
        return this.backgroundImage;
    }
    
    /**
     * Get if the map has background image
     * @return true if it is, else false
     */
    public boolean hasBackground() {
        return this.backgroundImage != null;
    }

    /***************************** 
    ************SETTER************
    *****************************/

    /**
     * Set the canDisplay state
     * *@param canDisplayTiles The new state
     */
    public void canDisplayTiles(boolean canDisplayTiles) {
        this.canDisplayTiles = canDisplayTiles;
    }

    /**
     * Set the background of the map
     * @param background The new background
     */
    public void background(String background) {
        this.backgroundImage = new BackgroundEntity(background);

    }

    public void setSelectedItem(ItemEntity item) {
        this.selectedSprite = item;
    }

    public boolean hasSelectedItem() {
        return this.selectedSprite != null;
    }

    public ItemEntity getSelectedItem() {
        return this.selectedSprite;
    }

    public void deleteSelectedItem() {
        this.selectedSprite = null;
    }

    public boolean canExportMap() {
        return (this.backgroundImage != null && !this.group.isEmpty());
    }

    public void clear() {
        this.selectedSprite = null;
        this.group.clear();
    }

    public BufferedImage toBufferedImage() {
        BufferedImage image = new BufferedImage(EditionView.WIDTH, EditionView.HEIGHT, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = image.createGraphics();
        g.drawImage(this.backgroundImage.getImage(), this.backgroundImage.surface().x, this.backgroundImage.surface().y, null);

        for(Entity entity : this.group) {
            g.drawImage(entity.getImage(), entity.surface().x, entity.surface().y, null);
        }

        g.dispose();

        return image;
    }
}