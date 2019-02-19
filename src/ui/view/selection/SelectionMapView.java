package ui.view.selection;

import controller.view.selection.SelectionMapController;

import json.imports.JSONImport;

import model.drawable.EditMapModel;

import ui.view.BaseView;

import java.util.ArrayList;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;

import javax.swing.JButton;

public class SelectionMapView extends BaseView {

    private static final int NEW_WIDTH = 300;

    private static final int NEW_HEIGHT = 300;

    private BufferedImage currentImage;

    private int index;

    private ArrayList<EditMapModel> maps;

    private JButton next;
    private JButton previous;
    private JButton home;

    private SelectionMapController controller;

    public SelectionMapView() {
        super();
        this.setLayout(new BorderLayout());

        this.maps = JSONImport.loadAllFiles();
        this.index = 0;
        this.currentImage = this.maps.get(this.index).toBufferedImage(); //default value

        this.next = new JButton(">");
        this.add(this.next, BorderLayout.EAST);

        this.previous = new JButton("<");
        this.add(this.previous, BorderLayout.WEST);

        this.add(new SelectionMapActionView(this), BorderLayout.SOUTH);

        this.controller = new SelectionMapController(this, this.next, this.previous);
    }

    @Override 
    public void paintComponent(Graphics p) {
        Graphics2D g = (Graphics2D)p.create();
        if(this.isOpaque()) {
            g.setColor(this.getBackground());
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
        }   

        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(this.currentImage, (this.getWidth() - NEW_WIDTH) / 2, (this.getHeight() - NEW_HEIGHT) / 2, NEW_WIDTH, NEW_HEIGHT, null);
    }

    public void next() {
        this.index = (this.index + 1) % this.maps.size();
        this.currentImage = this.maps.get(this.index).toBufferedImage();
    }

    public void previous() {
        this.index = (this.index - 1 + this.maps.size()) % this.maps.size();
        this.currentImage = this.maps.get(this.index).toBufferedImage();
    }

    public EditMapModel currentMap() {
        return this.maps.get(this.index);
    }
}