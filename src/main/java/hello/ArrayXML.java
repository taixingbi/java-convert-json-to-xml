package hello;

import hello.model.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ArrayXML {
    public static String process() throws JSONException {

        List<User> users= new ArrayList<>();
        users.add( new User("1", "taixingbi","tb@gmail.com"));
        users.add( new User("2", "hunter","h@gmail.com"));

        ListObjctToXML(users);

        return null;
    }

    public static void ListObjctToXML(List<User> users) {
        String xml= "";
        String xmlDeclaration ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        String rootElement= "MarketplaceInventoryImportData";
        String arrayElement= "Item";

        for(User user: users){
            Gson gson = new Gson();
            String singleJson= gson.toJson( user );
            String singleXML= singleJsonToXML(singleJson);
            xml += "<" + arrayElement + ">" + singleXML + "</" + arrayElement + ">";
        }
        xml= xmlDeclaration + "<" + rootElement + ">" + xml + "</" + rootElement + ">";
        System.out.println("xml: "+ xml);
    }

    public static String singleJsonToXML(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        String xml = XML.toString(jsonObject) ;
        return xml;
    }

}
