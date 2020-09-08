package Recurssion;

public class StringSubString {
	
	public static int count = 0;
	
	public static void main(String[] args) {
		System.out.println(2%3);
		String str = "101010";
		printAllSubString(str,0,"" , true);
		System.out.println(count +"  ====");
	}

	private static void printAllSubString(String str, int i, String ans , boolean flag) {
		// TODO Auto-generated method stub
		count++;
		if(i == str.length()) {
			//if(flag) {
			System.out.println(ans);
			//}
			return;
		}
	
		printAllSubString(str, i+1, ans+str.charAt(i),flag);
		printAllSubString(str, i+1, ans,true);
		
	}

}
