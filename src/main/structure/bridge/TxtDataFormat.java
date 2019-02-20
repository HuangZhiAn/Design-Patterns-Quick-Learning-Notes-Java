package structure.bridge;

public class TxtDataFormat extends DataFormat{
    @Override
    public String format() {
        return "将"+databace.selectData()+"转换成txt格式";
    }
}
