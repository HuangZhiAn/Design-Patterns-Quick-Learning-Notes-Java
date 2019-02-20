package structure.bridge;

public class MongoDbDatabase implements Database {
    @Override
    public String selectData() {
        return "MongoDb数据库数据";
    }
}
