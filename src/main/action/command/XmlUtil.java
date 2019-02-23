package action.command;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import structure.proxy.Business;

import java.util.ArrayList;
import java.util.List;

public class XmlUtil {

    public static List<MenuItem> getMenuItems(){
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read("src/main/action/command/config.xml");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        assert document != null;
        List<Node> nodes = document.selectNodes("//menu/item");
        List<MenuItem> menuItems = new ArrayList<>();
        MenuItem menuItem;
        try {
            for (Node node: nodes) {
                menuItem = new MenuItem();
                menuItem.setCommand((Command) Class.forName("action.command."+node.getText()).newInstance());
                menuItem.setName(node.valueOf("@name"));
                menuItems.add(menuItem);
            }

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return menuItems;
    }
}
