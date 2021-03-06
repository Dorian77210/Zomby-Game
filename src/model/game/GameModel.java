package model.game;

import model.drawable.EditMapModel;

import enums.SpriteType;

import model.sprite.AnimatedEntity;
import model.sprite.Entity;
import model.sprite.EntityGroup;
import model.sprite.BackgroundEntity;
import model.sprite.Surface;

import java.awt.image.BufferedImage;

public class GameModel {

    private EditMapModel model;

    private BackgroundEntity background;

    private EntityGroup  mapElements;

    private EntityGroup zombies;

    private EntityGroup bullets;

    private GameMap gameMap;

    public GameModel(EditMapModel map) {
        this.model = map;

        this.background = this.model.background();

        this.mapElements = map.getEntityGroup();

        this.zombies = new EntityGroup();

        this.bullets = new EntityGroup();

        this.gameMap = new GameMap(this.mapElements);
    }

    public EntityGroup getGroup(SpriteType type) {
        if(type.equals(SpriteType.ELEMENT)) {
            return this.mapElements;
        }

        if(type.equals(SpriteType.ZOMBY)) {
            return this.zombies;
        }

        if(type.equals(SpriteType.BULLET)) {
            return this.bullets;
        }

        return null;
    }

    public BufferedImage background() {
        return this.model.background().getImage();
    }

    public EntityGroup toBlit() {
        EntityGroup group = this.zombies.merge(this.mapElements);
        group = group.merge(this.bullets);

        return group;
    }
}