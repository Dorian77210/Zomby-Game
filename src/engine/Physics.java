package engine;

import model.sprite.Entity;
import model.sprite.EntityGroup;
import model.game.GameModel;

import enums.SpriteType;

public class Physics {

    private GameModel gameModel;

    private boolean setterSecurity;

    public Physics() {
        this.gameModel = null;
        this.setterSecurity = false;
    }

    public void initializeGameModel(final GameModel gameModel) {
        if(!this.setterSecurity) {
            this.setterSecurity = true;
            this.gameModel = gameModel;
        }
    }

    public void checkCollisions() {
        final EntityGroup bullets = this.gameModel.getGroup(SpriteType.BULLET);
        final EntityGroup elements = this.gameModel.getGroup(SpriteType.ELEMENT);

        //collision betwenn bullets and elements
        bullets.collideAndRemove(elements);
    }
}