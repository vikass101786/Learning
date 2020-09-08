package ObserverDesignPattern;

public class MobileObserver implements Observer {

	@Override
	public void update(Message message) {
		// TODO Auto-generated method stub
		System.out.println(" Moblile gets updated === MOBILE === " + message.getMessage() +" === MOBILE === \n");
	}

}
