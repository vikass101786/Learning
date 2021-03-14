package src.hotel.prj;

import java.util.List;

public class Room {
	
	public Integer roomNo;
	
	private RoomStatus roomStatus;
	
	private RoomType roomType;
	
	private Guest guest;
	
	Double bookingPrice;
	
	List<RoomKey> roomKeys;

	public Room(Integer roomNo , RoomStatus roomStatus, RoomType roomType) {
		this.roomStatus = roomStatus;
		this.roomType = roomType;
		this.roomNo = roomNo;
	}

	public RoomStatus isAvailable() {
		return roomStatus;
	}

	public RoomType getRoomType() {
		return roomType;
	}
	
}
