package structure.composite;

import java.util.ArrayList;
import java.util.List;

public class TextboxControl implements Control {

    private String name;
    private List<Control> controlList = new ArrayList();

    public TextboxControl(String name) {
        this.name = name;
    }

    @Override
    public void add(Control control) {
        controlList.add(control);
    }

    @Override
    public void remove(Control control) {
        controlList.remove(control);
    }

    @Override
    public Control getControl(int i) {
        return controlList.get(i);
    }

    @Override
    public void display() {
        System.out.println("显示"+name+"面板容器控件");
        //容器控件调用其内部的其它控件
        for (Control c : controlList) {
            c.display();
        }
    }
}
