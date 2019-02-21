package structure.decorator;

public class ModularDecorator implements Encryption {

    private Encryption encryption;

    public ModularDecorator(Encryption encryption) {
        this.encryption = encryption;
    }

    @Override
    public String encrytion(String data) {
        return "求模加密过的"+encryption.encrytion(data);
    }
}
