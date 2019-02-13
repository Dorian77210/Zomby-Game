package ui.view.binding;

import controller.view.binding.ExitParametersController;

import ui.view.BaseView;

import javax.swing.JButton;

import java.awt.FlowLayout;

public class ExitParametersView extends BaseView {

    private JButton back;

    private ExitParametersController controller;

    public ExitParametersView() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.back = new JButton("Back");
        this.add(this.back);

        this.controller = new ExitParametersController(this.back, this);
    }
}