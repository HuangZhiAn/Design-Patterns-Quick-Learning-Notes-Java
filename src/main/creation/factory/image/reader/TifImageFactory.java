package creation.factory.image.reader;

public class TifImageFactory implements ImageFactory {
    @Override
    public Image createImageReader() {
        return new TifImage();
    }
}
