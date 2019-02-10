package controller.view.drawable;

import model.drawable.EditMapModel;

import ui.view.editable.ItemChoiceView;
import ui.view.EditMapView;

import controller.base.MouseController;

import helper.Path;

import model.sprite.ItemEntity;

import java.io.File;

import javax.swing.JList;

import java.awt.event.MouseEvent;

/**
  * The class <code>ItemChoiceController</code> controls the selection of items
  * @version 1.0
  * @author Dorian Terbah 
**/

public class ItemChoiceController extends MouseController {

    /**
     * The map model
     */
    private EditMapModel model;

    private ItemChoiceView view;

    public ItemChoiceController(ItemChoiceView view, EditMapModel model, JList<String> list) {
        super();
        this.model = model;

        this.view = view;

        list.addMouseListener(this);
    }

    @Override 
    public void mouseClicked(MouseEvent event) {
        JList<String> list = (JList<String>)event.getSource();
        String element = list.getSelectedValue();

        String path = Path.ITEM_IMAGES_PATH + "/" + element;
        this.model.setSelectedItem(new ItemEntity(0, 0, path));

        //refresh the view
        EditMapView editMapView = (EditMapView)this.view.getParent().getParent().getParent().getParent().getParent(); //ugly code x)
        editMapView.repaint();
    }
}