package structure.adapter;

public class OtherEncryptionImpl implements OtherEncryption {

    @Override
    public String otherEncrypt(String text) {
        return "加密过的"+text;
    }
}
