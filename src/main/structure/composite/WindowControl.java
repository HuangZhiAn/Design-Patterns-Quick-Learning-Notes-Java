package structure.composite;

import java.util.ArrayList;
import java.util.List;

public class WindowControl implements Control{

    private String name;
    private List<Control> controlList = new ArrayList();

    public WindowControl(String name) {
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
        System.out.println("显示"+name+"窗体容器控件");
        //容器控件调用其内部的其它控件
        for (Control c : controlList) {
            c.display();
        }
    }
}
