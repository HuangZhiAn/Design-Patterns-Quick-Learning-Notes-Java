package creation.factory.simple.graph;

public class GraphFactoryMain {
    public static void main(String[] args){
        Graph circle = null;
        Graph rectangle = null;
        Graph triangle = null;
        try {
            circle = GraphFactory.createGraph("circle");
            rectangle = GraphFactory.createGraph("rectangle");
            triangle = GraphFactory.createGraph("triangle");
        } catch (UnSupportedShapeException e) {
            e.printStackTrace();
        }
        assert circle != null;
        circle.draw();
        assert rectangle != null;
        rectangle.draw();
        assert triangle != null;
        triangle.draw();
        circle.erase();
        rectangle.erase();
        triangle.erase();
    }
}
