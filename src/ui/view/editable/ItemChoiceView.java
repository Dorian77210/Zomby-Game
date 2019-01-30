package ui.view.editable;

import ui.view.BaseView;

import helper.Path;

import javax.swing.JList;

import java.io.File;

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

    public ItemChoiceView() {
        super();

        File itemFolder = new File(Path.ITEM_IMAGES_PATH);

        this.images = new JList<String>();
    }
}