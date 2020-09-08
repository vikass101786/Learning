package Array;

public class MergeTwoSortedArray {

	public static void main(String[] args) {
		int arr1 []= {1,3,5,7};
		int arr2 [] = {0,2,6,8,9};
		int arr3 [] = new int [arr1.length + arr2.length];
		printArray(mergeArray(arr1,arr2,arr3));
		
	}

	private static void printArray(int[] mergeArray) {
		// TODO Auto-generated method stub
		System.out.print("Merged Array = {");
		for(int i = 0 ; i < mergeArray.length ; i++) {
			System.out.print(mergeArray[i]);
			if( i != mergeArray.length -1) {
				System.out.print(" ,");
			}
		}
		System.out.print("}");
	}

	private static int [] mergeArray(int[] arr1, int[] arr2, int[] arr3) {
		// TODO Auto-generated method stub
		
		int ap1 = 0;
		int ap2 = 0;
		int ap3 = 0;
		
		while (ap1 < arr1.length && ap2 < arr2.length) {
			if(arr1[ap1] < arr2[ap2]) {
				arr3[ap3] = arr1[ap1];
				ap1++;
			} else {
				arr3[ap3] = arr2[ap2];
				ap2++;
			}
			ap3++;
		}
		
		while(ap1 < arr1.length) {
			arr3[ap3] = arr1[ap1];
			ap1++;
			ap3++;
		}
		
		while(ap2 < arr2.length) {
			arr3[ap3] = arr2[ap2];
			ap2++;
			ap3++;
		}
		
		return arr3;
	}
	
}
