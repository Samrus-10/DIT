package sam.rus.rostov.util.json.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import sam.rus.rostov.util.json.JsonConvert;
import sam.rus.rostov.util.json.JsonUse;

import java.io.IOException;
import java.io.StringWriter;

@Component
public class JsonUseImp<T> implements JsonUse<T> {
    private  ObjectMapper objectMapper;

    public JsonUseImp() {
        objectMapper = new ObjectMapper();
    }

    public  String convertToJson(T obj) {
        String result = "";
        try (
                StringWriter resultJsonString = new StringWriter();
        ) {
            objectMapper.writeValue(resultJsonString, obj);
            result = resultJsonString.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public JsonConvert convertToObject(String json, JsonConvert type) {
        JsonConvert result = null;
        try {
            result = objectMapper.readValue(json, type.getClass());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return result;
    }

}

