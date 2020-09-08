package SingleDisPatch;

public class Dog implements Animal {

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("Dog speaks bark");
	}

	@Override
	public void animalSpeaksToEachOther(Animal animal) {
		// TODO Auto-generated method stub
		System.out.println("Dog speaks to cat " + animal);
	}

	@Override
	public void makeSound(Dog dog) {
		// TODO Auto-generated method stub
		System.out.println("Dog speaks to Dog " + dog);
	}

	@Override
	public void makeSound(Cat cat) {
		// TODO Auto-generated method stub
		System.out.println("Dog speaks to Cat " + cat);
	}
	
	@Override
	public void makeSound(Animal animal) {
		// TODO Auto-generated method stub
		System.out.println("Dog talks to " + animal);
	}


}
