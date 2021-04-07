package BinarySearch;

public class PainterPartition {
	
	public static void main(String[] args) {
		int A = 10;
		int B = 1;
		int arr [] = {1, 8, 11, 3};
		System.out.println(new PainterPartition().paint(A, B, arr));
	}

    public int paint(int A, int B, int[] C) {
        
        int left = 0;
        int right = 0;
        long ans = Long.MAX_VALUE;
        int MODULAR = 10000003;
        Long duration = Long.valueOf(B);
        
        for (int i = 0 ; i < C.length ; i++) {
            left = Math.max(left, C[i]);
            right += C[i];
        }
        
        while (left <= right) {
            int value = (right - left)/2 + left;
            Pair p = isPainitingPossible(A,C,value);
            ans = Math.min(p.maxValue,ans);
            if (p.isPossible) {
                right = value -1;
            } else {
                left = value +1;
            }
        }
        return (int)(ans%MODULAR * duration %MODULAR)%MODULAR;
    }
    
    public Pair isPainitingPossible(int numOfPainter, int [] A , int maxTime) {
        
        int i = 0;
        int totalTime = A[i];
        int maxValue = Integer.MIN_VALUE;
        boolean isPossible = true;
        i++;
        while (i < A.length && numOfPainter > 0) {
            if (totalTime < maxTime) {
                totalTime += A[i];
                i++;
            } else if (totalTime > maxTime){
                totalTime -= A[i-1];
                maxValue = Math.max(totalTime,maxValue);
                totalTime = 0;
                numOfPainter--;
            } else {
                maxValue = Math.max(totalTime,maxValue);
                totalTime = 0;
                numOfPainter--;
            }
        }
        
     
        	maxValue = Math.max(totalTime,maxValue);
        	numOfPainter--;
    
        if (numOfPainter != 0) {
          isPossible = false;  
        }
    return new Pair(isPossible, maxValue);
    }
    
    static class Pair {
        boolean isPossible ;
        int maxValue ;
        Pair(boolean isPossible, int maxValue) {
            this.isPossible = isPossible;
            this.maxValue = maxValue;
        }
    }
    

}
