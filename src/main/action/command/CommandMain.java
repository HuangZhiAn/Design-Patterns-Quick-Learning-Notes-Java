package action.command;

import java.util.List;

public class CommandMain {
    public static void main(String[] args){
        Menu menu = new Menu();

        menu.setMenuItems(XmlUtil.getMenuItems());

        menu.display();

        System.out.println("点击：");
        List<MenuItem> menuItemList = menu.getMenuItems();
        for (MenuItem m:menuItemList) {
            m.click();
        }
    }
}
