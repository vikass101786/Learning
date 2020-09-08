
public class PrimeMultiply implements HashFunction {

	@Override
	public Integer hash(Object code) {
		return /* (( */code.toString().hashCode()/*/11) * (code.toString().hashCode()/3)) / 11*/;
	}

}
