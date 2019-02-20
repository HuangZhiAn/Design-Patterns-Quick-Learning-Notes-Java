package structure.adapter;

public class AdapterMain {
    public static void main(String[] args){
        Encryption encryption = XmlUtil.getAdapterBean();
        String enpPwd = encryption.encrypt("密码");
        System.out.println(enpPwd);
    }
}
