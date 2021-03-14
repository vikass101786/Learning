package src.hotel.prj;

public class InRoomPurchaseCharge implements BaseRoomCharge {

	Double cost;
	
	BaseRoomCharge baseRoomCharge;
	
	@Override
	public Double getCost() {
		baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
		return baseRoomCharge.getCost();
	}

	@Override
	public void setCost(double cost) {
		this.cost = cost;
	}

}
