package src.hotel.prj;

public class RoomCharge implements BaseRoomCharge {
	
	Double cost;

	@Override
	public Double getCost() {
		return cost;
	}
	
	void setCost(double cost) {
		this.cost = cost;
	}

}
