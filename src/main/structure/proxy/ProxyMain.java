package structure.proxy;

public class ProxyMain {
    public  static void main(String[] args){
        Business businessProxy = XmlUtil.getBusinessProxy();
        try {
            businessProxy.handle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
