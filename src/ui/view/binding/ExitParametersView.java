package ui.view.binding;

import controller.view.binding.ExitParametersController;

import ui.view.BaseView;

import javax.swing.JButton;

import java.awt.FlowLayout;

public class ExitParametersView extends BaseView {

    private JButton saveAndBack;

    private ExitParametersController controller;

    public ExitParametersView() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.saveAndBack = new JButton("Save and back");
        this.add(this.saveAndBack);

        this.controller = new ExitParametersController(this.saveAndBack, this);
    }
}