package ExceptionHandling;

public class NullCheck {

	/*public static void callInteger(Integer data) {
		System.out.println(data);
	}*/

	public static void callInteger(String data) {
		System.out.println(data);
	}

	public static void callInteger(Object data) {
		System.out.println(data + "  Object ");
	}

	/*public static void callInteger(StringBuffer data) {
		System.out.println(data);
	}*/

	public static void main(String[] args) {
		callInteger(null);
	}

}
