package Hashing;

public class AnagramSubStringSearch {
	
	static final int MAX = 27; 
	
	static boolean compare(int arr1[], int arr2[]) 
    { 
        for (int i = 0; i < MAX; i++) 
            if (arr1[i] != arr2[i]) 
                return false; 
        return true; 
    } 
	
	static void search(String A, String B) 
    { 
		int count = 0;
        int M = A.length(); 
        int N = B.length(); 
        int[] countP = new int[MAX]; 
        int[] countTW = new int[MAX]; 
        for (int i = 0; i < M; i++) 
        { 
            (countP[(int)A.charAt(i) - 'a'])++; 
            (countTW[(int)B.charAt(i) - 'a'])++; 
        } 
        for (int i = M; i < N; i++) 
        { 
            if (compare(countP, countTW)) 
                count++; 
            (countTW[(int)B.charAt(i) - 'a'])++; 
            countTW[(int)B.charAt(i-M) - 'a']--; 
        } 
        if (compare(countP, countTW)) 
            count++;
        System.out.println(count);
    } 
  
    public static void main(String args[]) 
    { 
        String txt = "abcbacabc"; 
        String pat = "abc"; 
        search(pat, txt); 
    } 
} 
	

