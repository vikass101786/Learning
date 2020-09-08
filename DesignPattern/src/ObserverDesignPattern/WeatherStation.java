package ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Observable {
	
	List<Observer> observerList = new ArrayList<Observer>();

	@Override
	public void add(Observer observer) {
		// TODO Auto-generated method stub
		observerList.add(observer);
	}

	@Override
	public void remove(Observer observer) {
		// TODO Auto-generated method stub
		observerList.remove(observer);
	}

	@Override
	public void notify(Message message) {
		// TODO Auto-generated method stub
		for (Observer obsever : observerList) {
			obsever.update(message);
		}
	}

}
