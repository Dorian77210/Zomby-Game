package helper;

/**
  * The class <code>Path</code> contains constants for path
  * @version 1.0
  * @author Dorian Terbah 
**/

public class Path {

    public static final String BASE_PATH = ".";
    public static final String RESSOURCE_PATH = BASE_PATH + "/rsc";
    public static final String MAP_PATH = RESSOURCE_PATH + "/maps";
    public static final String IMAGE_PATH = RESSOURCE_PATH + "/images";
    public static final String GROUND_IMAGES_PATH = IMAGE_PATH + "/grounds";
    public static final String ITEM_IMAGES_PATH = IMAGE_PATH + "/items";
    public static final String PLAYER_IMAGES_PATH = IMAGE_PATH + "/player";

    public static final String CONFIG_PATH = BASE_PATH + "/config";
    public static final String KEY_CONFIG_PATH = CONFIG_PATH + "/keys.json";
    public static final String PLAYER_CONFIG_PATH = CONFIG_PATH + "/player.json";
}