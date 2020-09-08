package Recurssion;

public class SubSetSum {
	
	static boolean  binArr [] = new boolean [10];
	
	public static void main(String[] args) {
		int arr [] = {5,10,12,13,15,18};
		
		subSetSum(arr,0,30,0);
	}

	private static boolean subSetSum(int[] arr, int i, int totalWeight, int startWeight) {
		// TODO Auto-generated method stub
		
		if(totalWeight == startWeight) {
			for (int k = 0 ; k < arr.length ; k++) {
				if(binArr[k]) {
					System.out.print(" " + arr[k]);
				}
			}
			System.out.println();
			return false;
		}	
			if(totalWeight < startWeight) {
				return false;
			}
			
			
			if(i >= arr.length) {
				return false;
			}
			
			startWeight += arr[i];
			binArr[i] = true;
			
			boolean canAdd = subSetSum(arr, i+1, totalWeight, startWeight);
			
			if(canAdd) {
				return true;
			}
			
			startWeight -= arr[i];
			binArr[i] = false;
			i++;
			return subSetSum(arr, i+1, totalWeight, startWeight);
	}
	
}
