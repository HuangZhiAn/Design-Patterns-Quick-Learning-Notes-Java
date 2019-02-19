package singleton.hungrier;

public class LoadBalancer {
    private static LoadBalancer loadBalancer = new LoadBalancer();

    private LoadBalancer(){}

    public static LoadBalancer getInstance(){
        return loadBalancer;
    }

    public static void main(String[] args){
        LoadBalancer instance1,instance2;
        instance1 = LoadBalancer.getInstance();
        instance2 = LoadBalancer.getInstance();
        System.out.println(instance1==instance2);

    }
}
