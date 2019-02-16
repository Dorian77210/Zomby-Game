package model.game;

import model.sprite.PlayerEntity;

public class Player {

    private PlayerEntity entity;

    public Player() {
        this.entity = new PlayerEntity(0, 0);
    }

    public PlayerEntity entity() {
        return this.entity;
    }
}