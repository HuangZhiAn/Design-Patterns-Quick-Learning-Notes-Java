package creation.prototype;

import java.io.*;

@SuppressWarnings({"WeakerAccess", "unused"})
public class Customer implements Cloneable, Serializable {
    private String name;

    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *浅拷贝
     */
    public Customer clone(){
        try {
            return (Customer)super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("对象类型不支持复制");
            return null;
        }
    }

    /**
     * 深拷贝
     */
    public Customer deepClone() throws IOException, ClassNotFoundException {
        //将对象写入流中
        ByteArrayOutputStream bao=new  ByteArrayOutputStream();
        ObjectOutputStream oos=new  ObjectOutputStream(bao);
        oos.writeObject(this);

        //将对象从流中取出
        ByteArrayInputStream bis=new  ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois=new  ObjectInputStream(bis);
        return  (Customer)ois.readObject();
    }

    public static void main(String[] args){
        Customer customer,customer1,customer2 = null;
        customer = new Customer();
        customer.setAddress(new Address("广西壮族自治区","梧州"));
        //浅拷贝
        customer1 = customer.clone();
        print(customer,customer1);
        //深拷贝
        try {
            customer2 = customer.deepClone();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        assert customer2 != null;
        print(customer,customer2);
    }

    private static void print(Customer customer, Customer customer1){
        System.out.println(customer==customer1);
        System.out.println(customer.getAddress()==customer1.getAddress());
        System.out.println(customer1.getAddress().getProvince()+customer1.getAddress().getCity());
    }
}
