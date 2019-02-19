package factory.simple.graph;

public class Circle implements Graph {
    @Override
    public void draw() {
        System.out.println("画圆");
    }

    @Override
    public void erase() {
        System.out.println("擦圆");
    }
}
