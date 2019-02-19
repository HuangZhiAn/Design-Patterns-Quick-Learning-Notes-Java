package factory.simple.image.reader;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XmlUtil {

    public static ImageFactory getImageBean(){
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read("src/main/factory/simple/image/reader/config.xml");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        assert document != null;
        Node node = document.selectSingleNode("//config/imageType");
        ImageFactory imageFactory = null;
        try {
            imageFactory = (ImageFactory) Class.forName("factory.simple.image.reader."+node.getText()).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return imageFactory;
    }
}
