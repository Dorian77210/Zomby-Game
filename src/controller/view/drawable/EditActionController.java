package controller.view.drawable;

import controller.base.ActionController;

import json.JSONParser;

import model.drawable.EditMapModel;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import org.json.JSONObject;

public class EditActionController extends ActionController {

    private static final String EXPORT_JSON_ACTION_COMMAND = "EXPORT_JSON_ACTION_COMMAND";

    private EditMapModel model;

    public EditActionController(EditMapModel model, JButton exportJSON) {
        super();
        this.model = model;

        exportJSON.setActionCommand(EXPORT_JSON_ACTION_COMMAND);
        exportJSON.addActionListener(this);
    }

    @Override 
    public void actionPerformed(ActionEvent event) {
        String actionCommand = event.getActionCommand();
        if(actionCommand.equals(EXPORT_JSON_ACTION_COMMAND)) {
            JSONObject json = JSONParser.mapToJSON(this.model);
        }
    }
}