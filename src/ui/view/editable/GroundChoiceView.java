package ui.view.editable;

import controller.view.drawable.GroundChoiceController;

import helper.Path;

import model.drawable.EditMapModel;

import ui.view.BaseView;

import javax.swing.JList;

import java.awt.BorderLayout;

import java.io.File;

/**
  * The class <code>GroundChoiceView</code> permits to choose a ground for the map
  * @version 1.0
  * @author Dorian Terbah 
**/

public class GroundChoiceView extends BaseView {

    /**
     * Images for the ground selection
     */
    private JList<String> images;

    /**
     * The controller of this view
     */
    private GroundChoiceController controller;

    public GroundChoiceView(EditMapModel model) {
        super();
        this.setLayout(new BorderLayout());

        File groundFolder = new File(Path.GROUND_IMAGES_PATH);

        this.images = new JList<String>(groundFolder.list());
        this.add(this.images, BorderLayout.CENTER);

        this.controller = new GroundChoiceController(model, this, this.images);
    }
}