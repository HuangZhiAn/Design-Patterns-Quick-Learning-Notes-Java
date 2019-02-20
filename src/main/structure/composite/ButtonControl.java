package structure.composite;

public class ButtonControl implements Control {
    private String name;

    public ButtonControl(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("显示"+name+"按钮控件");
    }
}
