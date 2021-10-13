package hello;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class SimpleXML {
    public static void process() {
        String json = "{\"name\":\"taixingbi\",\"email\":\"tb@gmail.com\",\"age\":38,\"isDeveloper\":true}\n";
        String xml = convertXML(json, "root"); // This method converts json object to xml string
        System.out.println(xml);
    }

    public static String convertXML(String json, String root) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        String xml = XML.toString(jsonObject);
        return xml;
    }
}
