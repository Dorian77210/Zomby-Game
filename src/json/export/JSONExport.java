package json.export;

import java.io.FileWriter;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JSONExport {

    public static final void exportJSON(String json, File file) {
        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter(file));

            try {
                writer.write(json);
            } catch(IOException writerException) {
                System.err.println("Error when writing line in the file " + file);
                System.exit(1);
            }

            try {
                writer.close();
            } catch(IOException closeException) {
                System.err.println("Error when closing the file " + file);
                System.exit(1);
            }

        } catch(IOException createWriter) {
            System.err.println("Error when creating the file writer for the file " + file);
            System.exit(1);
        }
    }
}