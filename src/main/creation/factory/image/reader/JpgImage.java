package factory.image.reader;

public class JpgImage implements Image {
    @Override
    public void display() {
        System.out.println("显示 JPG 图片");
    }
}
