package structure.bridge;

public class XmlDataFormat extends DataFormat {
    @Override
    public String format() {
        return "将"+databace.selectData()+"转换成XML格式";
    }
}
