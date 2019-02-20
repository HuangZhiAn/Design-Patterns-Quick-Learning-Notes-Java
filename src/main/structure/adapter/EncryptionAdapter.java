package structure.adapter;

public class EncryptionAdapter implements Encryption {

    private OtherEncryption otherEncryption = new OtherEncryptionImpl();

    @Override
    public String encrypt(String text) {
        return otherEncryption.otherEncrypt(text);
    }
}
