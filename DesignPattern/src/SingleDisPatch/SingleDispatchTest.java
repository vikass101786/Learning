package SingleDisPatch;

public class SingleDispatchTest {
	
	public static void main(String[] args) {
		Animal dog = new Dog();
		Animal cat = new Cat();
		dog.speak();
		cat.speak();
		dog.animalSpeaksToEachOther(cat);
		cat.animalSpeaksToEachOther(dog);
		dog.makeSound(cat);
		dog.makeSound(dog);
		cat.makeSound(cat);
		cat.makeSound(dog);
	}

}
