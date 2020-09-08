package Recurssion;

public class MikeAndExam {
	
	public static int count = 0;
	
	//https://ideone.com/tDwv9k
	
	public static void main(String[] args) {
		int arr [] = {1,3,2,6};
		int k = 2;
		findTotalCount(arr,0,k,0,"");
		System.out.println(count);
	}

	private static void findTotalCount(int[] arr, int i,int k ,int ans,String str) {
		// TODO Auto-generated method stub
		
		if(ans == k) {
			System.out.println(str);
			count++;
			return;
		}
		
		if(arr.length <= i) {
			return;
		}
		
		findTotalCount(arr, i+1,k, ans+arr[i] ,str+arr[i]+" ");
		
		findTotalCount(arr, i+1,k, ans-arr[i] , str+ (-arr[i])+" ");
		
		findTotalCount(arr, i+1,k, ans , str+" ");
		
		
	}
	
}
