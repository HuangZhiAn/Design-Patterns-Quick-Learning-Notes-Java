package structure.composite;

public class PanelControl implements Control {
    private String name;

    public PanelControl(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("显示"+name+"文本框控件");
    }
}
