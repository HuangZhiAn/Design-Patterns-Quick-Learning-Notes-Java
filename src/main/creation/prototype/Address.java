package creation.prototype;

import java.io.Serializable;

@SuppressWarnings({"unused", "WeakerAccess"})
public class Address implements Serializable {
    private String province;
    private String city;

    public Address() {}

    public Address(String province, String city) {
        this.province = province;
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
