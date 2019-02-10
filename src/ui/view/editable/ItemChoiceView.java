package ui.view.editable;

import ui.view.BaseView;

import controller.view.drawable.ItemChoiceController;

import model.drawable.EditMapModel;

import helper.Path;

import javax.swing.JList;

import java.io.File;

import java.awt.BorderLayout;

/**
  * The class <code>ItemChoiceView</code> permits to choose item for the creation of maps
  * @version 1.0
  * @author Dorian Terbah 
**/

public class ItemChoiceView extends BaseView {

    /**
     * List with the item images
     */
    private JList<String> images;

    private ItemChoiceController controller;

    public ItemChoiceView(EditMapModel model) {
        super();
        this.setLayout(new BorderLayout());

        File itemFolder = new File(Path.ITEM_IMAGES_PATH);

        this.images = new JList<String>(itemFolder.list());
        this.add(this.images, BorderLayout.CENTER);

        this.controller = new ItemChoiceController(this, model, this.images);
    }   
}