package String;

public class StringOcc {
	public static void main(String[] args) {
		System.out.println(new StringOcc().solve("bobob"));
	}
	public int solve(String A) {
        String searchString = "bob";
        searchString.charAt(0);
        int index = 0;
        int count = 0;
        while (true) {
			index = A.indexOf(searchString, index);
			if (index != -1) {
				count ++;
				index += 1;
			} else {
				break;
			}
		}
        return count;
    }

	
	public int solve1(String A) {
		return A.split("bob", -1).length-1;
	}
}
