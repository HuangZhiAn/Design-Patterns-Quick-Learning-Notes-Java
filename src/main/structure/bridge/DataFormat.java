package structure.bridge;

public abstract class DataFormat {
    protected Database databace;

    public abstract String format();

    public void setDatabace(Database databace) {
        this.databace = databace;
    }
}
