package structure.proxy;

public class BusinessImpl implements Business {
    @Override
    public void handle() throws Exception {
        System.out.println("业务处理");
        //throw new Exception("手动异常");
    }
}
