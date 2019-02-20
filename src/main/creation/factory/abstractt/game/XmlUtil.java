package factory.abstractt.game;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XmlUtil {

    public static ControllerFactory getControllerBean(){
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read("src/main/factory/abstractt/game/config.xml");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        assert document != null;
        Node node = document.selectSingleNode("//config/systemControllerFactory");
        ControllerFactory ControllerFactory = null;
        try {
            ControllerFactory = (ControllerFactory) Class.forName("factory.abstractt.game."+node.getText()).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return ControllerFactory;
    }
}
