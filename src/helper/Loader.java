package helper;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.IOException;
import java.io.File;

public class Loader {

    public static final BufferedImage loadImage(String file) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(file));
        } catch(IOException exception) {
            System.err.println("Error when loading the image");
            return null;
        }

        return image;
    }
}