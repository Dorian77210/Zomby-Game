package controller.view.drawable;

import controller.base.MouseController;

import helper.Path;

import ui.view.EditMapView;
import ui.view.editable.GroundChoiceView;

import model.drawable.EditMapModel;

import java.awt.event.MouseEvent;
import java.awt.Point;

import java.io.File;

import javax.swing.JList;

/**
  * The class <code>SelectionController</code> controls the selection of the ground
  * @version 1.0
  * @author Dorian Terbah 
**/

public class GroundChoiceController extends MouseController {

    /**
     * The model of the map
     */
    private EditMapModel model;

    /**
     * The view of the selection of map
     */
    private GroundChoiceView view;

    public GroundChoiceController(EditMapModel model, GroundChoiceView view, JList<String> list) {
        this.model = model;

        this.view = view;

        list.addMouseListener(this);
    }

    @Override 
    public void mouseClicked(MouseEvent event) {
        JList<String> list = (JList<String>)event.getSource();
        String element = list.getSelectedValue();

        this.model.background(new File(Path.GROUND_IMAGES_PATH + "/" + element));

        //refresh the view
        EditMapView editMapView = (EditMapView)this.view.getParent().getParent().getParent().getParent().getParent(); //ugly code x)
        editMapView.repaint();
    }
}