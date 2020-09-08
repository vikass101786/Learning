package SingleDisPatch;

public interface Animal {
	
	public void speak();
	public void animalSpeaksToEachOther(Animal animal);
	public void makeSound(Dog dog);
	public void makeSound(Cat cat);
	public void makeSound(Animal animal);

}
