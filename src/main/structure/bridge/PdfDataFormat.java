package structure.bridge;

public class PdfDataFormat extends DataFormat {
    @Override
    public String format() {
        return "将"+databace.selectData()+"转换成PDF格式";
    }
}
