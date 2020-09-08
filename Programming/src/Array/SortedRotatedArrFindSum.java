package Array;

public class SortedRotatedArrFindSum {
	
  public static void main(String[] args) {
	int arr [] = {11, 15, 6, 8, 9, 10}; 
	int sum = 16;
	pairinSortedRotArr(arr,sum);
  }

   private static void pairinSortedRotArr(int[] arr, int sum) {
	// TODO Auto-generated method stub
	// find the highest and lowest element to identify the boundary
	   
	   int i ;
	   for(i=0 ; i < arr.length ; i++) {
		   if(arr[i] > arr[i+1]) break;
	   }
	   
	   int h = i;
	   int l = (i+1)%arr.length; 
	   
	   while(l != h) {
		   if(sum == arr[l] + arr[h]) {
			   System.out.println(arr[l] +" : " + arr[h]);
		   }
		  
		   if(arr[l] + arr[h] < sum) {
			   l = (l+1) % arr.length;
		   } else {
			   System.out.println( "Before" + h + ":" + arr.length);
			   h = 	(arr.length + h - 1) % arr.length;
			   System.out.println( "After" + h + ":" + arr.length);
		   }
	   }
  }
  
}
