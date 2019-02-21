package structure.proxy;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import structure.facade.AbstractEncryptFacade;

public class XmlUtil {

    public static Business getBusinessProxy(){
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read("src/main/structure/proxy/config.xml");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        assert document != null;
        Node node = document.selectSingleNode("//config/proxy");
        Business business = null;
        try {
            business = (Business) Class.forName("structure.proxy."+node.getText()).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return business;
    }
}
