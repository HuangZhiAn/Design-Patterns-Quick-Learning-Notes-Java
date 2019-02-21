package structure.facade;

public class FacadeMain {
    public static void main(String[] args){
        AbstractEncryptFacade encryptFacade = XmlUtil.getEncryptFacade();
        encryptFacade.encryptFacade("src/main/structure/facade/src.txt","src/main/structure/facade/dest.txt");
    }
}
