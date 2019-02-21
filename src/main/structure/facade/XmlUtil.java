package structure.facade;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import structure.adapter.EncryptionAdapter;

public class XmlUtil {

    public static AbstractEncryptFacade getEncryptFacade(){
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read("src/main/structure/facade/config.xml");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        assert document != null;
        Node node = document.selectSingleNode("//config/encryptFacade");
        AbstractEncryptFacade encryptFacade = null;
        try {
            encryptFacade = (AbstractEncryptFacade) Class.forName("structure.facade."+node.getText()).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return encryptFacade;
    }
}
