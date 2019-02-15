package ui.view.selection;

import controller.view.selection.SelectionMapActionController;

import ui.view.BaseView;

import java.awt.FlowLayout;

import javax.swing.JButton;

public class SelectionMapActionView extends BaseView {

    private JButton home;
    private JButton play;

    private SelectionMapActionController controller;

    public SelectionMapActionView(SelectionMapView view) {
        super();
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.home = new JButton("Home");
        this.add(this.home);

        this.play = new JButton("Play");
        this.add(this.play);

        this.controller = new SelectionMapActionController(view, this.home, this.play);
    }
}