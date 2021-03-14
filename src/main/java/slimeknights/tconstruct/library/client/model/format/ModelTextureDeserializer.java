package slimeknights.tconstruct.library.client.model.format;

import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

/**
 * Deseralizes a json in the format of { "textures": { "foo": "texture",... }}
 * Ignores all invalid json
 */
public class ModelTextureDeserializer implements JsonDeserializer<Map<String, String>>
{

    public static final ModelTextureDeserializer INSTANCE = new ModelTextureDeserializer();
    public static final Type TYPE = new TypeToken<Map<String, String>>() {}.getType();

    private static final Gson GSON = new Gson();

    @Override
    public Map<String, String> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
        throws JsonParseException
    {

        JsonObject obj = json.getAsJsonObject();
        JsonElement texElem = obj.get("textures");

        if (texElem == null)
        {
            throw new JsonParseException("Missing textures entry in json");
        }

        return GSON.fromJson(texElem, TYPE);
    }
}
