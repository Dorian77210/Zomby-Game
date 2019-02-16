package model.sprite;

import enums.GameActions;

import helper.Loader;

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

        this.image = Loader.loadImage(image);

        this.surface = new Surface(new Point(x, y), this.image.getWidth(), this.image.getHeight());
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