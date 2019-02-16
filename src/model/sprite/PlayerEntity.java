package model.sprite;

import model.sprite.Entity;
import model.sprite.Surface;

import enums.GameActions;

import helper.Path;

import json.JSONParser;
import json.imports.JSONImport;

import java.awt.image.BufferedImage;
import java.awt.Point;

import java.util.HashMap;
import java.util.List;

import java.io.File;

import org.json.JSONObject;

public class PlayerEntity extends AnimatedEntity {

    public PlayerEntity(int x, int y) {
        super(x, y);
        //load the images
        JSONObject json = new JSONObject(JSONImport.load(new File(Path.PLAYER_CONFIG_PATH)));
        this.sprites = JSONParser.jsonToCharacter(json);

        this.index = 0;
        this.currentList = this.sprites.get(GameActions.MOVE_DOWN);

        BufferedImage tmp = this.currentList.get(this.index);

        this.surface = new Surface(new Point(x, y), tmp.getWidth(), tmp.getHeight());
    }

    @Override
    public void update() {
        //surface update
    }

    @Override 
    public void update(GameActions action) {

    }

    @Override 
    public BufferedImage getImage() {
        return this.currentList.get(this.index);
    }
}