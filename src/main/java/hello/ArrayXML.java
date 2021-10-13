package hello;

import hello.model.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


public class ArrayXML {
    public static String process() throws JSONException {

        List<User> users= new ArrayList<>();
        users.add( new User("1", "taixingbi","tb@gmail.com"));
        users.add( new User("2", "hunter","h@gmail.com"));

        String xml= ListObjctToXML(users);

        String str = null;
        try {
            str = getPrettyString(xml, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(str);

        return null;
    }

    public static String ListObjctToXML(List<User> users) {
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
        return xml;
    }

    public static String singleJsonToXML(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        String xml = XML.toString(jsonObject) ;
        return xml;
    }

    public static String getPrettyString(String xmlData, int indent) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.setAttribute("indent-number", indent);

        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        StringWriter stringWriter = new StringWriter();
        StreamResult xmlOutput = new StreamResult(stringWriter);

        Source xmlInput = new StreamSource(new StringReader(xmlData));
        transformer.transform(xmlInput, xmlOutput);

        return xmlOutput.getWriter().toString();
    }
}
