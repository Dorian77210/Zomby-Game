package model.sprite;

import enums.GameActions;

import json.JSONParser;

import javax.imageio.ImageIO;

import java.io.IOException;

import java.awt.Point;

import org.json.JSONObject;

public class ItemEntity extends Entity {

    private String file;

    public ItemEntity(int x, int y, String image) {
        super(x, y);
        this.file = image;

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

    public JSONObject toJSONFormat() {
        JSONObject json = new JSONObject();

        json.put(JSONParser.SURFACE_JSON_TAG, this.surface.toJSONFormat());
        json.put(JSONParser.PATH_JSON_TAG, this.file);

        return json;
    }

    @Override 
    public void update() {

    }

    @Override 
    public void update(GameActions action) {

    }
}