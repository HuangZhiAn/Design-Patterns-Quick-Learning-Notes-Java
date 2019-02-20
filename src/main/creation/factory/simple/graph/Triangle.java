package creation.factory.simple.graph;

public class Triangle implements Graph {
    @Override
    public void draw() {
        System.out.println("画三角");
    }

    @Override
    public void erase() {
        System.out.println("擦三角");
    }
}
