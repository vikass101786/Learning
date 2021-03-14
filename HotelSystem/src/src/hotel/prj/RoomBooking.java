package src.hotel.prj;

import java.util.Date;
import java.util.List;

public class RoomBooking {
	
	private Integer bookingId;
	Date startDate;
	Integer durationInDays;
	List<Guest> guestList;
	List<Room> roomInfo;
	BookingStatus bookingStatus;
	BaseRoomCharge roomCharges;
	

}
