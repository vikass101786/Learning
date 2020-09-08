package SingleDisPatch;

public class Cat implements Animal {

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("Cats Speaking meow");
	}

	@Override
	public void animalSpeaksToEachOther(Animal animal) {
		// TODO Auto-generated method stub
		System.out.println("Cat speaks to Dog " + animal);
	}

	@Override
	public void makeSound(Dog dog) {
		// TODO Auto-generated method stub
		System.out.println("Cat Speaks to Dog " + dog);
	}

	@Override
	public void makeSound(Cat cat) {
		// TODO Auto-generated method stub
		System.out.println("Cat Speaks to Cat " + cat);
	}

	@Override
	public void makeSound(Animal animal) {
		// TODO Auto-generated method stub
		System.out.println("Cat talks to " + animal);
	}

}
