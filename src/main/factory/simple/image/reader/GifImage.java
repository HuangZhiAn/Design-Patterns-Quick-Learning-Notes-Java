package factory.simple.image.reader;

public class GifImage implements Image {
    @Override
    public void display() {
        System.out.println("显示 GIF 图片");
    }
}
