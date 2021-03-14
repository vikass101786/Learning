package Hashing;

public class IsDistinonary {
	
	public static void main(String[] args) {
		String A [] = {"hello", "scaler", "interviewbit"};
		String B = "adhbcfegskjlponmirqtxwuvzy";
		System.out.println(new IsDistinonary().solve(A, B));
	}
	
	int map [] = new int [26];
	private  int solve(String[] words, String dictinoary) {
		// TODO Auto-generated method stub
		for (int i = 0 ; i < dictinoary.length() ; i++ )
			map[dictinoary.charAt(i) - 'a']  = i;
		for (int i = 1 ; i < words.length ; i++)
			if (isSorted(words[i-1],words[i]))
				return 0;
		return 1;
	}

	private boolean isSorted(String string, String string2) {
		// TODO Auto-generated method stub
		int n = string.length();
		int m = string2.length();
		for (int i = 0 ; i < n && i < m ; i++) 
			if(string.charAt(i) != string2.charAt(i))
				return map[string.charAt(i) - 'a'] > map[string2.charAt(i) - 'a'];
		return n > m;
	}

}
