package singleton.lazybones;

/**
 * Initialization Demand Holder (IoDH)
 */
public class LoadBalancerInnerClass {


    private LoadBalancerInnerClass(){}

    private static class InstanceHolder{
        private final static LoadBalancerInnerClass loadBalancer = new LoadBalancerInnerClass();
    }

    public static LoadBalancerInnerClass getInstance(){
        return InstanceHolder.loadBalancer;
    }

    public static void main(String[] args){
        LoadBalancerInnerClass instance1,instance2;
        instance1 = LoadBalancerInnerClass.getInstance();
        instance2 = LoadBalancerInnerClass.getInstance();
        System.out.println(instance1==instance2);
    }
}
