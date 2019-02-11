package controller.view.drawable;

import controller.base.MouseController;

import model.drawable.EditMapModel;
import model.sprite.EntityGroup;
import model.sprite.ItemEntity;
import model.sprite.Entity;
import model.sprite.Surface;
import model.drawable.Tile;

import ui.view.editable.EditionView;

import java.awt.event.MouseEvent;

public class ItemPoseController extends MouseController {

    private EditMapModel model;

    private EditionView view;

    public ItemPoseController(EditMapModel model, EditionView view) {
        this.model = model;
        this.view = view;

        this.view.addMouseListener(this);
    }

    @Override 
    public void mouseClicked(MouseEvent event) {
        if(this.model.hasSelectedItem()) {
            int button = event.getButton();
            if(button == MouseEvent.BUTTON3) {
                this.model.deleteSelectedItem();
                this.view.repaint();
                return;
            }
            ItemEntity sprite = this.model.getSelectedItem();
            Surface s = sprite.surface();

            sprite.surface(Tile.getFarestDistance(s));

            this.model.addWithVerification(sprite);

            this.view.repaint();

            this.model.deleteSelectedItem(); 
        } else {
            //search if the point collides with an entity
            EntityGroup group = this.model.getEntityGroup();
            for(Entity entity : group) {
                if(entity.surface().contains(event.getPoint())) {
                    group.remove(entity);
                    this.model.setSelectedItem((ItemEntity)entity);
                    break;
                }
            }
        }
    }
}