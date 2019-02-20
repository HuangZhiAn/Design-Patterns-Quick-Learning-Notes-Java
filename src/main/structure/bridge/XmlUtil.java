package structure.bridge;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XmlUtil {

    public static Database getDatabase(){
        Document document = InitXml();
        Node node = document.selectSingleNode("//config/database");
        Database database = null;
        try {
            database = (Database) Class.forName("structure.bridge."+node.getText()).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return database;
    }

    public static DataFormat getFormat(){
        Document document = InitXml();
        Node node = document.selectSingleNode("//config/format");
        DataFormat dataFormat = null;
        try {
            dataFormat = (DataFormat) Class.forName("structure.bridge."+node.getText()).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return dataFormat;
    }

    private static Document InitXml() {
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read("src/main/structure/bridge/config.xml");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        assert document != null;
        return document;
    }
}
