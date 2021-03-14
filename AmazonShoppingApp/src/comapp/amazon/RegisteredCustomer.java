package comapp.amazon;

import java.util.List;

public class RegisteredCustomer extends GuestUser{

    public List<Address> addressList;

    public RegisteredCustomer(String customerName, Integer customerId) {
        super(customerName, customerId);
    }
}
