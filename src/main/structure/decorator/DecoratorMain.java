package structure.decorator;

public class DecoratorMain {
    public static void main(String[] args){

        Encryption encryption,encryption1,encryption2;
        encryption = new DisplacementEncrytion();
        encryption1 = new ModularDecorator(encryption);
        encryption2 = new ReverseOutputDecorator(encryption1);
        System.out.println(encryption2.encrytion("password"));
    }
}
