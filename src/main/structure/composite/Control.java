package structure.composite;

public interface Control {

    default void add(Control control){
        System.out.println("不支持该方法");
    }
    default void remove(Control control){
        System.out.println("不支持该方法");
    }
    default Control getControl(int i) {
        System.out.println("不支持该方法");
        return null;
    }
    void display();
}
