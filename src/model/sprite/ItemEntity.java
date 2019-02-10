package model.sprite;

import javax.imageio.ImageIO;

import java.io.IOException;

import java.awt.Point;

public class ItemEntity extends Entity {

    public ItemEntity(int x, int y, String image) {
        super(x, y);
        
        try {
            this.image = ImageIO.read(new java.io.File(image));
        } catch(IOException exception) {
            System.err.println("Error when loading the image " + image);
        }

        this.surface = new Surface(new Point(x, y), this.image.getWidth(), this.image.getHeight());
    }

    @Override 
    public boolean collide(Entity entity) {
        return this.surface.intersects(entity.surface);
    }
}