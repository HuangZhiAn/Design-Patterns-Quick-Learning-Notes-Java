package creation.factory.simple.graph;

class GraphFactory {
    static Graph createGraph(String type) throws UnSupportedShapeException {
        Graph g;
        switch (type) {
            case "circle":
                g = new Circle();
                break;
            case "rectangle":
                g = new Rectangle();
                break;
            case "triangle":
                g = new Triangle();
                break;
            default:
                throw new UnSupportedShapeException("不支持的几何图形");
        }
        return g;
    }
}
