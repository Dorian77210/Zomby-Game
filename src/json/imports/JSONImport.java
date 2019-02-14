package json.imports;

import helper.Path;

import model.drawable.EditMapModel;

import json.JSONParser;

import java.io.*;

import java.util.ArrayList;

import org.json.JSONObject;

/**
  * The class <code>JSONImport</code> imports the game from a file
  * @version 1.0
  * @author Dorian Terbah 
**/

public class JSONImport {

    /**
      * Import the game from the file 
    **/
    public static final String load(File file) {
        String json = "";
        BufferedReader reader;
        StringBuffer buffer = new StringBuffer();

        try {
            reader = new BufferedReader(new FileReader(file));

            try {
                while((json = reader.readLine()) != null) {
                    buffer.append(json);
                }
            } catch(IOException readException) {
                System.err.println("Error when reading the file " + file);
                System.exit(1);
            }

        } catch(IOException readerException) {
            System.err.println("Error during searching the file " + file);
            System.exit(1);
        }

        return buffer.toString();
    }

    public static final ArrayList<EditMapModel> loadAllFiles() {
        File[] maps = new File(Path.MAP_PATH).listFiles();

        String content;
        JSONObject json;

        ArrayList<EditMapModel> list = new ArrayList<EditMapModel>(maps.length);

        for(File map : maps) {
            content = load(map);
            json = new JSONObject(content);
            list.add(JSONParser.jsonToMap(json));
        }

        return list;
    }
}