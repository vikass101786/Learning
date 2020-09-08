package ObserverDesignPattern;

public class LCDObserver implements Observer {

	@Override
	public void update(Message message) {
		// TODO Auto-generated method stub
		System.out.println(" LCD gets updated   === LCD ===" +message.getMessage() + " ===  LCD === \n ");
	}

}
