package structure.adapter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XmlUtil {

    public static EncryptionAdapter getAdapterBean(){
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read("src/main/structure/adapter/config.xml");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        assert document != null;
        Node node = document.selectSingleNode("//config/adapter");
        EncryptionAdapter encryptionAdapter = null;
        try {
            encryptionAdapter = (EncryptionAdapter) Class.forName("structure.adapter."+node.getText()).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return encryptionAdapter;
    }
}
