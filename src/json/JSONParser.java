package json;

import model.sprite.Entity;
import model.sprite.Surface;
import model.sprite.BackgroundEntity;
import model.sprite.ItemEntity;
import model.sprite.EntityGroup;

import org.json.JSONObject;

import model.drawable.EditMapModel;

public class JSONParser {

    public static final String BACKGROUND_JSON_TAG = "background";

    public static final String ENTITY_JSON_TAG = "entity";

    public static final String ENTITIES_JSON_TAG = "entities";

    public static final String SURFACE_JSON_TAG = "surface";

    public static final String X_JSON_TAG = "x";

    public static final String Y_JSON_TAG = "y";

    public static final String PATH_JSON_TAG = "path";

    public static final String WIDTH_JSON_TAG = "width";

    public static final String HEIGHT_JSON_TAG = "height";

    public static final JSONObject mapToJSON(EditMapModel model) {
        JSONObject json = new JSONObject();
        JSONObject entitiesJSON = new JSONObject();
        ItemEntity entity;

        EntityGroup group = model.getEntityGroup();
        for(int i = 0; i < group.size(); i++) {
            entity = (ItemEntity)group.get(i);
            entitiesJSON.put(ENTITY_JSON_TAG + i, entity.toJSONFormat());
        }

        json.put(ENTITIES_JSON_TAG, entitiesJSON);

        BackgroundEntity background = model.background();
        json.put(BACKGROUND_JSON_TAG, background.toJSONFormat());

        System.out.println(json);

        return json;
    }
}