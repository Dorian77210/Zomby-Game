package model.sprite;

import enums.GameActions;

import helper.Loader;

import json.JSONParser;

import javax.imageio.ImageIO;

import java.io.IOException;

import java.awt.Point;

import org.json.JSONObject;

public class BackgroundEntity extends Entity {

    public String file;

    public BackgroundEntity(String image) {
        super(0, 0);
        this.file = image;

        this.image = Loader.loadImage(image);

        this.surface = new Surface(new Point(0, 0), this.image.getWidth(), this.image.getHeight());
    }

    @Override 
    public boolean collide(Entity entity) {
        return false;
    }

    public JSONObject toJSONFormat() {
        JSONObject json = new JSONObject();

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