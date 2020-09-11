package JDK8Feature;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ForEachLoop {
	
	
	/*
	 * Whenever we need to traverse through a Collection, we need to create an Iterator whose
	 * whole purpose is to iterate over and then we have business logic in a loop for each 
	 * of the elements in the Collection. We might get ConcurrentModificationException if 
	 * iterator is not used properly.
	 * 
	 * Java 8 has introduced forEach method in java.lang.Iterable interface so that while
	 * writing code we focus on business logic only. forEach method 
	 * takes java.util.function.Consumer object as argument, so it helps in having our 
	 * business logic at a separate location that we can reuse 
	 * */
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i <10; i++ ) {
			list.add(i);
		}
		
		//traversing using Iterator
		Iterator<Integer> myList = list.iterator();
		while(myList.hasNext()) {
			Integer num = myList.next();
			System.out.println("Iterator value " + num);
		}
		
		//traversing through forEach method of Iterable with anonymous class
		
		list.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				// TODO Auto-generated method stub
				System.out.println("for each anonymous class value " + t);
			}
		});
		
		//Consumer implementation that can be reused
		MyConsumer action = new MyConsumer();
		list.forEach(action);
	}
	
}

class MyConsumer implements Consumer<Integer> {

	@Override
	public void accept(Integer t) {
		System.out.println("Consumer impl Value::"+t);
	}
	
}
