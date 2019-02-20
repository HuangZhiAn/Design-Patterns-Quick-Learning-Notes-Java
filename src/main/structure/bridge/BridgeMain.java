package structure.bridge;

public class BridgeMain {
    public static void main(String[] args) {
        Database database = XmlUtil.getDatabase();
        DataFormat format = XmlUtil.getFormat();
        format.setDatabace(database);
        System.out.println(format.format());
    }
}
