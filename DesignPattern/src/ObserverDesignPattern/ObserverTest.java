package ObserverDesignPattern;

public class ObserverTest {
	
	public static void main(String[] args) {
		
		Observer mobile = new MobileObserver();
		Observer lcd 	= new LCDObserver();
		Observer alert 	= new AlarmObserver();
		
		Observable weatherSystem = new WeatherStation();
		
		weatherSystem.add(mobile);
		weatherSystem.add(lcd);
		
		Message message = new Message(" <<< Its about to rain at 5:30 >>>");
		
		weatherSystem.notify(message);
		
		weatherSystem.remove(lcd);
		
		weatherSystem.add(alert);
		
		Message message2 = new Message(" <<< Its Tsunami time >>> ");
		
		System.out.println(" =========================================================================== \n");
		
		weatherSystem.notify(message2);
		
		System.out.println(" =========================================================================== \n");
		
	}
	
}	
