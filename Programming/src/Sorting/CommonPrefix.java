package Sorting;

public class CommonPrefix {
	
	public static void main(String[] args) {
		String [] arr = {"abcd"};
		System.out.println(new CommonPrefix().longestCommonPrefix(arr));
	}
	
public String longestCommonPrefix(String[] A) {
        
	
        String answer = "";
        if (A.length >= 2) {
         answer = commonPrefix(A[0],A[1]);
        }
        
        for (int i = 2 ; i < A.length ; i++) {
            answer = commonPrefix(answer, A[i]);
        }
        return answer;
    }
    
    public String commonPrefix(String value1 , String value2) {
        StringBuffer answer = new StringBuffer("");
        for (int i = 0 ; i < value1.length() && i < value2.length() ; i++) {
            if (value1.charAt(i) != value2.charAt(i)) {
                break;
            }
            answer.append(value1.charAt(i));
        }
        return new String(answer);
    }

}
