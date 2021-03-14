package ProblemSolving;

public class ExcelColumnTitle {
	
	public static void main(String[] args) {
		System.out.println(convertToTitle(943566));
	}

    public static String convertToTitle(int A) {
        
        //System.out.println((char)(65));
        String ans = "";
        
        while(A != 0) {
            int mod = A % 26;
            mod = (mod == 0) ? 26 : mod;
            A /= 26;
            A  = (mod == 26) ? A-1 : A;
           
            ans = ((char)(mod+64)) + ans;
            //System.out.println(mod + " " + A);
        }
        
        return ans;
        
    }

}
