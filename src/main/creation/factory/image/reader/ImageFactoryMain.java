package factory.image.reader;

public class ImageFactoryMain {

    public static void main(String[] args){
        ImageFactory imageBean = XmlUtil.getImageBean();
        Image imageReader = imageBean.createImageReader();
        imageReader.display();
    }
}
