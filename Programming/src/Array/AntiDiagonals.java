package Array;

public class AntiDiagonals {
	
	public static void main(String[] args) {
			int A [][] = {{1 ,2 ,3},
						 {4 ,5 ,6},
						 {7 ,8 ,9}};
			System.out.println(new AntiDiagonals().diagonal(A));
	}
	
	public int[][] diagonal(int[][] A) {
        int ans [][] = new int [A.length + (A.length-1)][];
        int row = 0 ;
        int X = row , Y = 0;
        int len = 1;
        int main_row = 0;
        for (int col = 0 ; col <= A.length -1 ; col++) {
            int tempArr [] = new int [len];
            int i = 0;
            while(X <= col && Y >= 0) {
                tempArr[i] = A[X][Y];
                X++;
                Y--;
                i++;
            }
            X = 0;
            Y = col+1;
            len++;
            ans[col] = tempArr;
            main_row = col;
        }
        
        
        int col = A.length -1;
        X = 1 ; Y = col;
        len = A.length -1;
        
        for (int row_1 = 1 ; row_1 < A.length ; row_1++) {
            int tempArr [] = new int [len];
            int i = 0;
            while(X <= col && Y >= row_1) {
                tempArr[i] = A[X][Y];
                X++;
                Y--;
                i++;
            }
            X = row_1 + 1;
            Y = col;
            len--;
            main_row++;
            ans[main_row] = tempArr;
        }
        return ans;
    }

}
