package hello;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class App {
    public static void main(String[] args) {
        System.out.println("----------app----------");

        String json = "{\"name\":\"taixingbi\",\"email\":\"tb@gmail.com\",\"age\":38,\"isDeveloper\":true}\n";
        //Convert JSON to XML
        String xml = convert(json, "root"); // This method converts json object to xml string
        System.out.println(xml);

        System.out.println("----------app end----------");
    }

    public static String convert(String json, String root) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<"+root+">" + XML.toString(jsonObject) + "</"+root+">";
        return xml;
    }

}
