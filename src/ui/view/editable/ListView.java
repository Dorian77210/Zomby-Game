package ui.view.editable;

import model.drawable.EditMapModel;

import ui.view.BaseView;
import ui.view.editable.ChoiceItemView;

import javax.swing.JScrollPane;

import java.awt.CardLayout;

/**
  * The class <code>ListView</code> represents the differents item for the selection
  * @version 1.0
  * @author Dorian Terbah 
**/

public class ListView extends BaseView {

    /**
     * Layout of this view
     */
    private CardLayout layout;

    private BaseView groundChoiceView;

    private BaseView itemChoiceView;

    public ListView(EditMapModel model) {
        super();
        this.layout = new CardLayout();
        this.setLayout(this.layout);
        //creations and adding of the views

        this.groundChoiceView = new GroundChoiceView(model);
        this.itemChoiceView = new ItemChoiceView(model);

        JScrollPane groundPane = new JScrollPane(this.groundChoiceView);
        groundPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JScrollPane itemPane = new JScrollPane(this.itemChoiceView);
        itemPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.add(groundPane, ChoiceItemView.GROUND_CHOICE_VIEW);
        this.add(itemPane, ChoiceItemView.ITEM_CHOICE_VIEW);
        
        //default view
        this.show(ChoiceItemView.GROUND_CHOICE_VIEW);
    }

    /**
     * Show a specific view according to the tag
     * @param tag The tag that describes the wanted view
     */
    public void show(String tag) {
        this.layout.show(this, tag);
    }
}