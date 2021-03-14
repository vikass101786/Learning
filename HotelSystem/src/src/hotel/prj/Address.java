package src.hotel.prj;

public class Address {
	
	private Integer pincode;
	
	private String streetName;

	public Address(Integer pincode, String streetName) {
		this.pincode = pincode;
		this.streetName = streetName;
	}

	public Integer getPincode() {
		return pincode;
	}

	public String getStreetName() {
		return streetName;
	}
	
	

}
