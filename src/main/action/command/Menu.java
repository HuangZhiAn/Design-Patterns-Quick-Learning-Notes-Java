package action.command;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> menuItems = new ArrayList();

    public boolean addMenuItem(MenuItem menuItem) {
        return menuItems.add(menuItem);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void display(){
        System.out.println("显示菜单：");
        for (MenuItem m:menuItems) {
            System.out.println(m.getName());
        }
    }
}
