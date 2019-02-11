package json;

import model.sprite.Entity;
import model.sprite.Surface;
import model.sprite.BackgroundEntity;
import model.sprite.ItemEntity;
import model.sprite.EntityGroup;
import model.sprite.EntityGroup;

import org.json.JSONObject;

import model.drawable.EditMapModel;

import helper.Path;

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

        return json;
    }

    public static final void jsonToMap(EditMapModel model, JSONObject json) {
        model.clear();
        EntityGroup group = model.getEntityGroup();
        JSONObject backgroundJSON = json.getJSONObject(BACKGROUND_JSON_TAG);
        String background = backgroundJSON.getString(PATH_JSON_TAG);
        model.background(background);

        JSONObject surface, entity;
        String path = "";

        int x = 0, y = 0;
        JSONObject entities = json.getJSONObject(ENTITIES_JSON_TAG);

        for(String key : JSONObject.getNames(entities)) {
            entity = entities.getJSONObject(key);
            path = entity.getString(PATH_JSON_TAG);
            surface = entity.getJSONObject(SURFACE_JSON_TAG);
            x = surface.getInt(X_JSON_TAG);
            y = surface.getInt(Y_JSON_TAG);

            group.add(new ItemEntity(x, y, path));
        }

    }
}