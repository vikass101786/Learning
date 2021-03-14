
public class Toss {
 
	
	public static void main(String[] args) {
		tossFlip("", 3 , true);
	}
	
	public static void tossFlip(String answer , int length, boolean flag) {
		
		if(answer.length() == length) {
		  System.out.print(answer + " ");
		}
		
		if(answer.length() < length && flag )  {
		tossFlip(answer+"H" , length , false);
		}
		if(answer.length() < length) {
		tossFlip(answer+"T" , length, true);
		
		}
			
	}
}


