package BuilderDesignPattern;

public class Computer {

	private String HDD;
	private String RAM;
	

	private boolean isGraphicCardEabled;
	private boolean isBluetoothEabled;
	
	public String getHDD() {
		return HDD;
	}

	public String getRAM() {
		return RAM;
	}

	public boolean isGraphicCardEabled() {
		return isGraphicCardEabled;
	}

	public boolean isBluetoothEabled() {
		return isBluetoothEabled;
	}

	private Computer(ComputerBuilder computerBuilder) {
		this.HDD = computerBuilder.HDD;
		this.RAM = computerBuilder.RAM;
		this.isBluetoothEabled = computerBuilder.isBluetoothEabled;
		this.isGraphicCardEabled = computerBuilder.isGraphicCardEabled;
	}

	public static class ComputerBuilder {

		private String HDD;
		private String RAM;

		private boolean isGraphicCardEabled;
		private boolean isBluetoothEabled;

		public ComputerBuilder(String HDD, String RAM) {
			this.HDD = HDD;
			this.RAM = RAM;
		}

		public ComputerBuilder setGraphicCardEabled(boolean isGraphicCardEabled) {
			this.isGraphicCardEabled = isGraphicCardEabled;
			return this;
		}

		public ComputerBuilder setBluetoothEabled(boolean isBluetoothEabled) {
			this.isBluetoothEabled = isBluetoothEabled;
			return this;
		}

		public Computer build() {
			return new Computer(this);
		}
	}

}
