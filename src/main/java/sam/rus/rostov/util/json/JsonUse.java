package sam.rus.rostov.util.json;

public interface JsonUse<T> {
    String convertToJson(T obj);

    JsonConvert convertToObject(String json, JsonConvert type);
}
