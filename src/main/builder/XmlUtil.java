package builder;

import factory.abstractt.game.ControllerFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XmlUtil {

    public static AbstractVideoPlayerBuilder getControllerBean(){
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read("src/main/builder/config.xml");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        assert document != null;
        Node node = document.selectSingleNode("//config/videoPlayerBuilder");
        AbstractVideoPlayerBuilder videoPlayerBuilder = null;
        try {
            videoPlayerBuilder = (AbstractVideoPlayerBuilder) Class.forName("builder."+node.getText()).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return videoPlayerBuilder;
    }
}
