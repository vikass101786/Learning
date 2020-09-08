package Array;

public class KthSmallestEle {
	
    public static void main(String[] args) {
    	int element = -1;
		int arr [] = {12,3,5,7,19};
		Heap hp = new Heap(true);
		for(int i = 0 ; i < arr.length ; i++) {
			hp.add(arr[i]);
		}
		int k = 2;
		
		for(int i = 0 ; i < k ; i++) {
			element = hp.extractMin();
		}
		System.out.println(element);
	}
}
