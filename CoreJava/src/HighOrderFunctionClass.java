
public class HighOrderFunctionClass<T> {
	
	
	public T executeCode(ImplemenetIt<T> it, T defaultAnswer) {
		
		T answer = defaultAnswer;
		
		return () -> {
			try {
				return it.provideYourImpl();
			} catch (Exception ex) {
				
			}
			finally {
				 return it.provideYourImpl();
			}
		};
	}
	
	 public static void main(String[] args) {
	        HighOrderFunctionClass<String> hofc = new HighOrderFunctionClass<>();
	        String someDefault = "I am the default value.";
	        ImplemenetIt<String> it = () -> return "Hello world.";
	        String result = hofc.executeCode(it, someDefault);
	    }
	
}
