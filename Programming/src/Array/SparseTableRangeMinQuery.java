package Array;

public class SparseTableRangeMinQuery {

	
	private final int [][] sparse ;
	private final int n;
	private final int[] input;
	
	public SparseTableRangeMinQuery(int[] input) {
		// TODO Auto-generated constructor stub
		this.input = input;
		this.n = input.length;
		sparse = preprocess(input , this.n);
	}
	
	
	private int[][] preprocess(int[] input, int n) {
        int[][] sparse = new int[n][log2(n) + 1];
        for (int i = 0; i < input.length; i++) {
            sparse[i][0] = input[i];
        }

        for (int j = 1; 1 << j <= n; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                if (sparse[i][j - 1] < sparse[i + (1 << (j - 1))][j - 1]) {
                    sparse[i][j] = sparse[i][j - 1];
                } else {
                    sparse[i][j] = sparse[i + (1 << (j - 1))][j - 1];
                }
            }
        }
        return sparse;
    }

    public int rangeMinimumQuery(int low, int high) {
    	System.out.println("low : " + low + " high : " + high);
        int l = high - low + 1;
        System.out.println("Total Ele : " + l);
        int k = log2(l);
        System.out.println(" K " + k);
        System.out.println(" Compare : Ans => " + sparse[low][k]);
        System.out.println(" low2 : " + (low + l - (1<<k))  + "-------" + (high - (1<<k) + 1));
        System.out.println(" Compare 2 : " + sparse[low + l - (1<<k)][k]);
        if (sparse[low][k] <= sparse[low + l - (1<<k)][k]) {
            return sparse[low][k];
        } else {
        	System.out.println(" Ans 2 => " + sparse[high - (1<<k) + 1][k]);
            return sparse[high - (1<<k) + 1][k];
        }
    }

    private static int log2(int n){
        if(n <= 0) throw new IllegalArgumentException();
        return 31 - Integer.numberOfLeadingZeros(n);
    }

    public static void main(String args[]) {
        int[] input = {5,2,4,7,6,3,1,2};
        SparseTableRangeMinQuery sparseTableRangeMinimumQuery = new SparseTableRangeMinQuery(input);
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
            	System.out.println("==============================================");
            	System.out.println();
                System.out.print(sparseTableRangeMinimumQuery.rangeMinimumQuery(i, j) + " ");
                System.out.println();
                System.out.println("==============================================");
            }
            System.out.println();
        }
    }
}
