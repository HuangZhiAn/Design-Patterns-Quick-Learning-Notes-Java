package init;

public class ClassInitOrder {
    //private static String s1 = staticFunction();
    private static Person person = new Person("静态");
    private Person person1 = new Person("普通");
    private String s = function();

    public ClassInitOrder() {
        System.out.println("构造函数");
    }

    public static String staticFunction(){
        System.out.println("静态方法");
        return "";
    }

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("普通代码块");
    }

    public String function(){
        System.out.println("普通成员");
        return "";
    }

    public static void main(String[] args){
        new ClassInitOrder();
    }
}
