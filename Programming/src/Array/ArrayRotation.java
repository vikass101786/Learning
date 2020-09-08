package Array;

public class ArrayRotation {

	public static void leftRotate(int arr[] , int d , int n) {
		
		int i , j , k , temp ;
		int gcd = gcdCompute(d, n);
		
		for(i = 0 ; i < gcd ; i++) {
			temp = arr[i];
			j = i;
			while(true) {
				k = j+d;
				if (k >= n) 
					k = k - n;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp ;
		}
	}
	
	
	static int gcdCompute(int a , int b) {
		if (b ==0)
			return a;
		else 
			return gcdCompute(b,a%b);
	}
	
	static void printArray(int arr[] , int size) {
		int i;
		for(i = 0 ; i < size ; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int arr [] = {1,2,3,4,5,6,7,8,9,10,11,12};
		ArrayRotation.printArray(arr, 12);
		System.out.println();
		ArrayRotation.leftRotate(arr, 3, 12);
		ArrayRotation.printArray(arr, 12);
	}
}
