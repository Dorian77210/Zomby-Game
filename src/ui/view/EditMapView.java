package ui.view;

import model.drawable.EditMapModel;

import ui.view.editable.ChoiceItemView;
import ui.view.editable.EditionView;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Point;

import helper.Palette;

/**
  * The class <code>EditMapView</code> permits to create and modify map
  * @version 1.0
  * @author Dorian Terbah 
**/

public class EditMapView extends BaseView {

    /**
     * Constant used to have the width of this view
     */
    public static final int WIDTH = 600;

    /**
     * Constant used t have the height of this view
     */
    public static final int HEIGHT = 600;

    /**
     * The model that contains all sprites of the map
     */
    private EditMapModel model;    

    /**
     * The display of the map
     */
    private EditionView editionView;    

    public EditMapView() {
        super();
        this.setLayout(new BorderLayout());

        this.model = new EditMapModel();
        this.editionView = new EditionView(this.model);

        this.add(new ChoiceItemView(this.model), BorderLayout.EAST);

        this.add(this.editionView, BorderLayout.CENTER);
    }
}