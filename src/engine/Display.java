package engine;

import model.sprite.Entity;
import model.sprite.EntityGroup;
import model.game.GameModel;

import enums.SpriteType;

public class Display {

    private GameModel gameModel;

    private boolean setterSecurity;

    public Display() {
        this.gameModel = null;
        this.setterSecurity = false;
    }

    public void initializeGameModel(final GameModel gameModel) {
        if(!this.setterSecurity) {
            this.setterSecurity = true;
            this.gameModel = gameModel;
        }
    }

    public void updateEntities() {
        final EntityGroup bullets = this.gameModel.getGroup(SpriteType.BULLET);
        final EntityGroup zombies = this.gameModel.getGroup(SpriteType.ZOMBY);

        //updates the bullets, then the zombies
        bullets.update();
        zombies.update();
    }


}