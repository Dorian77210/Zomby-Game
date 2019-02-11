package json.imports;

import java.io.*;

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
}