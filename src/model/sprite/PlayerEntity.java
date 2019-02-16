package model.sprite;

import engine.Engine;

import enums.SpriteType;

import model.sprite.EntityGroup;
import model.sprite.Entity;
import model.sprite.Surface;
import model.sprite.BulletEntity;

import model.drawable.Tile;

import enums.GameActions;

import helper.Path;

import ui.view.editable.EditionView;

import json.JSONParser;
import json.imports.JSONImport;

import java.awt.image.BufferedImage;
import java.awt.Point;
import java.awt.Dimension;

import java.util.HashMap;
import java.util.List;

import java.io.File;

import org.json.JSONObject;

public class PlayerEntity extends AnimatedEntity {

    private static final int PLAYER_SPEED = 5;

    public PlayerEntity(int x, int y) {
        super(x, y);
        //load the images
        JSONObject json = new JSONObject(JSONImport.load(new File(Path.PLAYER_CONFIG_PATH)));
        this.sprites = JSONParser.jsonToCharacter(json);

        this.index = 0;
        this.currentList = this.sprites.get(GameActions.MOVE_DOWN);

        this.surface = new Surface(new Point(x, y), Tile.WIDTH, Tile.HEIGHT);
    }

    @Override
    public void update() {
        //surface update
    }

    @Override 
    public void update(GameActions action) {
        EntityGroup group = Engine.instance().getGameModel().getGroup(SpriteType.ELEMENT);
        EntityGroup bullets = Engine.instance().getGameModel().getGroup(SpriteType.BULLET);

        Surface oldSurface = new Surface(this.surface.x, this.surface.y, this.surface.width, this.surface.height);

        if(action.equals(GameActions.MOVE_DOWN)) {
            if(this.surface.y + this.surface.height <= EditionView.HEIGHT - PLAYER_SPEED) {
                this.surface.y += PLAYER_SPEED;
                this.index++;
                this.updateCurrentList(action);
            }
        } 

        if(action.equals(GameActions.MOVE_UP)) {
            if(this.surface.y >= PLAYER_SPEED) {
                this.surface.y -= PLAYER_SPEED;
                this.index++;
                this.updateCurrentList(action);
            }
        }

        if(action.equals(GameActions.MOVE_LEFT)) {
            if(this.surface.x >= PLAYER_SPEED) {
                this.surface.x -= PLAYER_SPEED;
                this.index++;
                this.updateCurrentList(action);
            }
        }

        if(action.equals(GameActions.MOVE_RIGHT)) {
            if(this.surface.x + this.surface.width <= EditionView.WIDTH - PLAYER_SPEED) {
                this.surface.x += PLAYER_SPEED;
                this.index++;
                this.updateCurrentList(action);
            }
        }

        if(action.equals(GameActions.SHOOT)) {
            int x = (this.surface.x + this.surface.width) / 2;
            int y = (this.surface.y + this.surface.height) / 2;
            Point direction = this.direction();
            bullets.add(new BulletEntity(x, y, direction));
        }

        if(group.collide(this)) {
            this.index--;
            this.surface = oldSurface;
        }
    }

    private void updateCurrentList(GameActions action) {
        List<BufferedImage> list = this.sprites.get(action);
        if(!list.equals(this.currentList)) {
            this.currentList = list;
        }
    }

    private Point direction() {
        List<BufferedImage> list = this.sprites.get(GameActions.MOVE_DOWN);
        if(list.equals(this.currentList)) return new Point(0, BulletEntity.BULLET_SPEED);

        list = this.sprites.get(GameActions.MOVE_UP);
        if(list.equals(this.currentList)) return new Point(0, -BulletEntity.BULLET_SPEED);

        list = this.sprites.get(GameActions.MOVE_LEFT);
        if(list.equals(this.currentList)) return new Point(-BulletEntity.BULLET_SPEED, 0);

        list = this.sprites.get(GameActions.MOVE_RIGHT);
        if(list.equals(this.currentList)) return new Point(BulletEntity.BULLET_SPEED, 0);

        return null;
    }

    @Override 
    public BufferedImage getImage() {
        int size = this.currentList.size();
        return this.currentList.get(this.index % size);
    }

    

    private boolean isOutOfBounds(Surface surface) {
        if((surface.x + PLAYER_SPEED + surface.width < EditionView.WIDTH) || (surface.x - PLAYER_SPEED - surface.width > 0)) return true;
        if((surface.y + surface.height + PLAYER_SPEED < EditionView.HEIGHT) || (surface.y - PLAYER_SPEED - surface.height > 0)) return true;
        return false;
    }
}