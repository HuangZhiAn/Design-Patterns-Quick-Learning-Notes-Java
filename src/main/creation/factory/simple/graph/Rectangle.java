package creation.factory.simple.graph;

public class Rectangle implements Graph {
    @Override
    public void draw() {
        System.out.println("画矩形");
    }

    @Override
    public void erase() {
        System.out.println("擦矩形");
    }
}
