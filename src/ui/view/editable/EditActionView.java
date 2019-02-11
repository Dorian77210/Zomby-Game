package ui.view.editable;

import model.drawable.EditMapModel;

import controller.view.drawable.EditActionController;

import ui.view.BaseView;

import java.awt.FlowLayout;

import javax.swing.JButton;

public class EditActionView extends BaseView {

    private EditActionController controller;

    private JButton exportJSON;

    private JButton importJSON;

    public EditActionView(EditMapModel model, EditionView view) {
        super();
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.exportJSON = new JButton("Export map");
        this.add(this.exportJSON);

        this.importJSON = new JButton("Import map");
        this.add(this.importJSON);

        this.controller = new EditActionController(model, view, this.exportJSON, this.importJSON);
    }
}