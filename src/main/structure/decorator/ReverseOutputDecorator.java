package structure.decorator;

public class ReverseOutputDecorator implements Encryption {

    private Encryption encryption;//被装饰的类

    public ReverseOutputDecorator(Encryption encryption) {
        this.encryption = encryption;
    }

    @Override
    public String encrytion(String data) {
        return "逆向输出加密过的"+encryption.encrytion(data);
    }
}
