package controller.view.drawable;

import controller.base.MouseMotionController;

import model.drawable.EditMapModel;
import model.sprite.ItemEntity;
import model.sprite.EntityGroup;
import model.sprite.Surface;

import ui.view.editable.EditionView;

import java.awt.Point;
import java.awt.event.MouseEvent;

public class ItemDragController extends MouseMotionController {

    private EditMapModel model;

    private EditionView view;

    public ItemDragController(EditMapModel model, EditionView view) {
        this.model = model;
        this.view = view;
        this.view.addMouseMotionListener(this);
    }

    @Override 
    public void mouseMoved(MouseEvent event) {
        Point p = event.getPoint();
        if(this.model.hasSelectedItem()) {
            ItemEntity sprite = this.model.getSelectedItem();
            EntityGroup group = this.model.getEntityGroup();
            Surface surface = sprite.surface();

            surface.x = p.x;
            surface.y = p.y;

            if(!this.view.isOutOfBounds(surface)) {
                if(!group.collide(sprite)) {
                    sprite.surface(p);
                    this.view.repaint();
                }
            }
        }
    }
}