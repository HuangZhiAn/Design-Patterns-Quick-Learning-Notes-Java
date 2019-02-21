package structure.facade;

import java.io.FileNotFoundException;

public class EncryptFacade extends AbstractEncryptFacade{
    private FileReader fileReader;
    private FileWriter fileWriter;
    private Encryption encryption;

    public EncryptFacade() {
        this.fileReader = new FileReader();
        this.fileWriter = new FileWriter();
        this.encryption = new Encryption();
    }

    public void encryptFacade(String src,String dest){
        try {
            String strData = fileReader.read(src);
            String encryptionData = this.encryption.encrypt(strData);
            fileWriter.write(encryptionData,dest);
            String destData = fileReader.read(dest);
            System.out.println("解密数据："+encryption.decrypt(destData));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
