package ObserverDesignPattern;

public class AlarmObserver implements Observer {

	@Override
	public void update(Message message) {
		// TODO Auto-generated method stub
		System.out.println(" Alarm updated ( ***** )" + message.getMessage() + " (*****) /n ");
	}

}
