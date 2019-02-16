package model.game;

import model.drawable.EditMapModel;

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

    public GameModel(EditMapModel map) {
        this.model = map;

        this.background = this.model.background();

        this.mapElements = map.getEntityGroup();

        this.zombies = new EntityGroup();
    }

    public BufferedImage background() {
        return this.model.background().getImage();
    }

    public EntityGroup toBlit() {
        EntityGroup group = this.zombies.merge(this.mapElements);

        return group;
    }
}