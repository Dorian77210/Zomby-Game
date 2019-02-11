package controller.view.drawable;

import controller.base.ActionController;

import json.JSONParser;
import json.export.JSONExport;
import json.imports.JSONImport;

import model.drawable.EditMapModel;

import ui.modal.ErrorModal;
import ui.modal.SuccessModal;
import ui.view.editable.EditionView;

import helper.Path;
import helper.FileFilter;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

import org.json.JSONObject;

public class EditActionController extends ActionController {

    private static final String EXPORT_JSON_ACTION_COMMAND = "EXPORT_JSON_ACTION_COMMAND";

    private static final String IMPORT_JSON_ACTION_COMMAND = "IMPORT_JSON_ACTION_COMMAND";

    private EditMapModel model; 

    private EditionView view;

    public EditActionController(EditMapModel model, EditionView view, JButton exportJSON, JButton importJSON) {
        super();
        this.model = model;
        this.view = view;

        exportJSON.setActionCommand(EXPORT_JSON_ACTION_COMMAND);
        exportJSON.addActionListener(this);

        importJSON.setActionCommand(IMPORT_JSON_ACTION_COMMAND);
        importJSON.addActionListener(this);
    }

    @Override 
    public void actionPerformed(ActionEvent event) {
        String actionCommand = event.getActionCommand();
        if(actionCommand.equals(EXPORT_JSON_ACTION_COMMAND)) {
            if(this.model.canExportMap()) {
                JSONObject json = JSONParser.mapToJSON(this.model);
                String file = JOptionPane.showInputDialog("Enter a file name");
                if(!JSONExport.exportJSON(json.toString(), new File(Path.MAP_PATH + "/" + file + ".map"))) {
                    ErrorModal modal = new ErrorModal("Error when creating your file");
                } else {
                    SuccessModal modal = new SuccessModal("Your map has been saved with success");
                }
            } else {
                ErrorModal modal = new ErrorModal("Please selected at least one item and a background");
            }
        } else if(actionCommand.equals(IMPORT_JSON_ACTION_COMMAND)) {
            JFileChooser chooser = new JFileChooser();
            int choice = chooser.showOpenDialog(null);
            if(choice == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                if(!FileFilter.isValidImportFile(file)) {
                    ErrorModal modal = new ErrorModal("Please choose a valid file with an extension .map and not empty");
                } else {
                    String content = JSONImport.load(file);
                    JSONParser.jsonToMap(this.model, new JSONObject(content));
                    this.view.repaint();
                }
            }
        }
    }
}