package structure.proxy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BusinessProxy implements Business {

    @Override
    public void handle() throws Exception {

        System.out.println("方法Method()被调用，调用时间为"+new SimpleDateFormat("YYYY-MM-DD HH:mm:ss").format(new Date()));
        try {
            Business business = new BusinessImpl();
            business.handle();
        } catch (Exception e) {
            System.out.println("方法handle()调用失败");
            throw e;
        }
        System.out.println("方法handle()调用成功");
    }
}
