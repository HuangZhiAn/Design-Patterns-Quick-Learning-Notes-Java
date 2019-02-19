package factory.simple.image.reader;

public class GifImageFactory implements ImageFactory {
    @Override
    public Image createImageReader() {
        return new GifImage();
    }
}
