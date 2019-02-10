package model.drawable;

import ui.view.EditMapView;

import model.sprite.Entity;
import model.sprite.ItemEntity;
import model.sprite.EntityGroup;

import java.awt.image.BufferedImage;

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
    private BufferedImage backgroundImage;

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
    public BufferedImage background() {
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
    public void background(File background) {
        try {
            this.backgroundImage = ImageIO.read(background);
        } catch(IOException exception) {
            System.err.println("Error when loading background image");
        }

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
}