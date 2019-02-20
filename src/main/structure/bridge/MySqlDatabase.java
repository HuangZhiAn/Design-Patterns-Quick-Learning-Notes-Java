package structure.bridge;

public class MySqlDatabase implements Database {
    @Override
    public String selectData() {
        return "MySql数据库数据";
    }
}
