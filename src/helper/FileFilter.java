package helper;

import java.util.Arrays;
import java.util.List;

import java.io.File;

public class FileFilter {

    private static final List<String> validImportExtensions = Arrays.asList(".map");

    private static final List<String> validItemExtensions = Arrays.asList(".png", ".jpg", ".jpeg");

    public static final boolean isValidImportFile(File file) {
        String name = file.getName();
        String extension = name.substring(name.lastIndexOf("."));

        return validImportExtensions.contains(extension);
    }

    public static final boolean isValidItemFile(File file) {
        String name = file.getName();
        String extension = name.substring(name.lastIndexOf("."));

        return validItemExtensions.contains(extension);
    }
}