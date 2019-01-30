package ui.view.editable;

import ui.view.BaseView;
import ui.view.editable.SelectionView;

import model.drawable.EditMapModel;

import java.awt.BorderLayout;
import java.awt.Dimension;

/**
  * The class <code>ChoiceItemView</code> permits to choose item for the creation of map
  * @version 1.0
  * @author Dorian Terbah 
**/

public class ChoiceItemView extends BaseView {

    /**
     * Constant used to toggle to the ground choice view
     */
    public static final String GROUND_CHOICE_VIEW = "GROUND_CHOICE_VIEW";

    /**
     * Constant used to toggle to the item choice view
     */
    public static final String ITEM_CHOICE_VIEW = "ITEM_CHOICE_VIEW";

    /**
     * Constant used too set the preferred size of this view
     */
    private static final int WIDTH = 275;

    public ChoiceItemView(EditMapModel model) {
        super();
        this.setLayout(new BorderLayout());

        this.setPreferredSize(new Dimension(WIDTH, this.getHeight()));

        ListView listView = new ListView(model);

        this.add(new SelectionView(listView), BorderLayout.NORTH);
        this.add(listView, BorderLayout.CENTER);
    }
}