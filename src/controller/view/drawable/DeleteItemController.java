package controller.view.drawable;

import model.drawable.EditMapModel;

import ui.view.EditMapView;

import controller.base.KeyController;

import java.awt.event.KeyEvent;

public class DeleteItemController extends KeyController {

    private EditMapModel model;

    private EditMapView view;

    public DeleteItemController(EditMapModel model, EditMapView view) {
        this.model = model;
        this.view = view;
    }

    @Override 
    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        if(key == KeyEvent.VK_DELETE) {
            if(this.model.hasSelectedItem()) {
                this.model.deleteSelectedItem();
                this.view.repaint();
            }
        }
    }
}