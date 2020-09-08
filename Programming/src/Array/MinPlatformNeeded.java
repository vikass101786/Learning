package Array;

public class MinPlatformNeeded {
	
	public static void main(String[] args) {
		 int arr[] = {900, 940, 950, 1100, 1500, 1800}; 
		 int dep[] = {910, 1200, 1120, 1130, 1900, 2000}; 
		 
		 int n = arr.length;
		 System.out.println(mimPlatReq(arr,dep,n));
	}

	public static int mimPlatReq(int[] arr, int[] dep, int n) {
		// TODO Auto-generated method stub
		int plat_needed = 0 , result = 1;
		int l = 0 , r = 0 ;
		
		while(l < n && r < n) {
			if(arr[l] < dep[r]) {
			   plat_needed++;	
			   
			   if(result < plat_needed) 
					result = plat_needed;
			   
			   l++;
			} else {
			   
				plat_needed--;
				r++;
			}
		} 
		return result;
	}
	
}
