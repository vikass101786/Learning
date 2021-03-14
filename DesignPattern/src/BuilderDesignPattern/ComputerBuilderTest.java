package BuilderDesignPattern;

public class ComputerBuilderTest {
	
	public static void main(String[] args) {
		Computer comp = new Computer.ComputerBuilder("", "").setBluetoothEabled(false).setGraphicCardEabled(true).build();
	}
	
}
