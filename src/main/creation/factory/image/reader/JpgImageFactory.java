package creation.factory.image.reader;

public class JpgImageFactory implements ImageFactory {
    @Override
    public Image createImageReader() {
        return new JpgImage();
    }
}
