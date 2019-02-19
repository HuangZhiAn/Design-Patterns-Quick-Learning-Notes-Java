package singleton.lazybones;

/**
 * 双重检查锁定
 */
public class LoadBalancer {
    private volatile static LoadBalancer loadBalancer;

    private LoadBalancer(){}

    public static LoadBalancer getInstance(){
        if(loadBalancer==null){
            synchronized (LoadBalancer.class){
                if(loadBalancer==null){
                    loadBalancer = new LoadBalancer();
                }
            }
        }
        return loadBalancer;
    }

    public static void main(String[] args){
        LoadBalancer instance1,instance2;
        instance1 = LoadBalancer.getInstance();
        instance2 = LoadBalancer.getInstance();
        System.out.println(instance1==instance2);
    }
}
