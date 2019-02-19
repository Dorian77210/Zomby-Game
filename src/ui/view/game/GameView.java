package ui.view.game;

import engine.Engine;

import ui.view.editable.EditionView;

import controller.view.game.GameController;

import model.game.GameModel;
import model.drawable.EditMapModel;
import model.sprite.Entity;
import model.sprite.BackgroundEntity;
import model.sprite.Surface;
import model.sprite.EntityGroup;
import model.sprite.PlayerEntity;
import model.sprite.AnimatedEntity;

import model.game.Player;
import model.drawable.Tile;

import ui.view.editable.EditionView;
import ui.view.BaseView;

import javax.swing.JComponent;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;

import java.util.Timer;
import java.util.TimerTask;

public class GameView extends BaseView {

    private GameController controller;

    private Timer renderClock;

    public GameView(EditMapModel map) { 
        super();

        this.setPreferredSize(new Dimension(EditionView.WIDTH, EditionView.HEIGHT));

        this.controller = new GameController(this);

        GameModel model = new GameModel(map);

        Engine.instance().initializeGame(model);

        this.renderClock = new Timer();

        this.start();
    }

    private class Updater extends TimerTask {

        public static final int INTERVAL_IN_MILLISECONDS = 1000 / 60;

        private GameView view;

        public Updater(GameView view) {
            this.view = view;
        }

        @Override 
        public void run() {
            //update the sprites
            Engine.display.updateEntities();
            Engine.physics.checkCollisions();

            this.view.repaint();
        }
    }
    
    private void start() {
        this.renderClock.scheduleAtFixedRate(new Updater(this), 0, Updater.INTERVAL_IN_MILLISECONDS);
    }

    @Override 
    public void paintComponent(Graphics p) {
        Graphics2D g = (Graphics2D)p.create();

        GameModel model = Engine.instance().getGameModel();

        if(this.isOpaque()) {
            g.setColor(this.getBackground());
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
        }

        g.drawImage(model.background(), 0, 0, EditionView.WIDTH, EditionView.HEIGHT, null);

        //draw the player
        Player player = Engine.instance().getPlayer();
        final AnimatedEntity entity = player.entity();
        g.drawImage(entity.getImage(), entity.surface().x, entity.surface().y, Tile.WIDTH, Tile.HEIGHT, null);
        
        this.blit(g, model.toBlit());
    }

    private void blit(Graphics2D p, EntityGroup group) {
        for(Entity entity : group) {
            p.drawImage(entity.getImage(), entity.surface().x, entity.surface().y, null);
        }
    }   
}