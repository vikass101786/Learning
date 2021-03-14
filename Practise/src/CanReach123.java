
public class CanReach123 {
	
	
	public static void main(String[] args) {
		int arr [] = {4,2,3,0,3,1,2};
		int start = 5;
		System.out.println(canReach(arr,start));
	}
	
	public static boolean canReach(int[] arr, int start) {
        if(start < 0 || start >= arr.length || arr[start] < 0)
            return false;
        arr[start] = -arr[start];
        return arr[start] == 0 || canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
    }
}

