package creation.factory.image.reader;

public class GifImageFactory implements ImageFactory {
    @Override
    public Image createImageReader() {
        return new GifImage();
    }
}
