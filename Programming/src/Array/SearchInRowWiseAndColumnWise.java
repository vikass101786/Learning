package Array;

public class SearchInRowWiseAndColumnWise {
	
	public static void main(String[] args) {
		int A [] [] = {{1,2,3},
						{4,5,6},
						{7,8,9}};
		System.out.println(new SearchInRowWiseAndColumnWise().solve(A, 2));
	}
	
	int l = -1 , m = -1;
    public int solve(int[][] A, int B) {
        for (int i = 0 ; i < A.length ; i++) {
            if (B == A[i][0] || B == A[i][A[i].length-1]) {
                m = (B == A[i][0]) ? 0 : A[i].length-1;
                l = i;
                break;
            }
            else if (B > A[i][0] && B < A[i][A[i].length-1]) {
                m = findIndex(A[i] , B);
                l = i;
                break;
            }
        }
        return (m != -1) ? (((l+1)*1009)+(m+1)) : m;
    }
    
    public int findIndex(int [] arr , int ele) {
        int low = 0;
        int high = arr.length -1;
        int index = -1;
        while(low < high) {
              int mid = (low + high) >>> 1;
                if (arr[mid] == ele) {
                    index = mid;
                    break;
                } else if (arr[mid] > ele) {
                    low = mid + 1;
                } else {
                    high = mid -1;
                }
        }
        return index;
    }

}
