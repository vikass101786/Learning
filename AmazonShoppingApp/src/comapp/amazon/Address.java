package comapp.amazon;

public class Address {
    public String streetName;
    public String cityName;
    public Integer pinCode;

    public Address(String streetName, String cityName, Integer pinCode) {
        this.streetName = streetName;
        this.cityName = cityName;
        this.pinCode = pinCode;
    }

    public String toString() {
        return "Address{streetName='" + this.streetName + '\'' + ", cityName='" + this.cityName + '\'' + ", pinCode=" + this.pinCode + '}';
    }
}