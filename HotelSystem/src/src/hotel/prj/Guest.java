package src.hotel.prj;

import java.util.List;

public class Guest extends Person {
	
	String name;
	
	Integer guestId;
	
	private Search roomSearch;
	
	private Booking bookingService;
	
	public List<RoomBooking> getAllBookedRoom() {
		return roomSearch.getAllBookedRoomByGuest(guestId);
	}
	
	public RoomBooking createBooking() {
		return bookingService.createBooking(null);
	}
	
	public RoomBooking cancelBooking(int bookingId) {
		return bookingService.cancelBooking(null);
	}
	
	public List<Room> searchRoom()  {
		return roomSearch.searchRoom(null);
	}
}
