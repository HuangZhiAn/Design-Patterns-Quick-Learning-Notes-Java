package structure.decorator;

public class DisplacementEncrytion implements Encryption {
    public String encrytion(String data){
        return "用位移加密过的"+data;
    }
}
