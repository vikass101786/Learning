package src.hotel.prj;

public class RoomServiceCharge implements BaseRoomCharge {

	BaseRoomCharge baseRoomCharge;
	
	Double cost;
	
	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		baseRoomCharge.setCost(baseRoomCharge.getCost()+cost);
		return baseRoomCharge.getCost();
	}

	@Override
	public void setCost(double cost) {
		this.cost = cost;
	}
}
