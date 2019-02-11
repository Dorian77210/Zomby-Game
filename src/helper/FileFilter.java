package helper;

import java.util.Arrays;
import java.util.List;

import java.io.File;

public class FileFilter {

    private static final List<String> validExtensions = Arrays.asList(".map");

    public static final boolean isValidImportFile(File file) {
        String name = file.getName();
        String extension = name.substring(name.lastIndexOf("."));

        return validExtensions.contains(extension);
    }
}