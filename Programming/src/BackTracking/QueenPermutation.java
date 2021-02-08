package BackTracking;

public class QueenPermutation {
	
	
	public static void main(String[] args) {
		
		queenPermutation(new boolean [4], 1, 3, "");
	}
	
	
	public static void queenPermutation(boolean [] board, int currentState , int totalState , String answer) {
		
		if(currentState == totalState) {
			System.out.println(answer);
			return;
		} else {
			System.out.println(answer);
		}
		
		for (int i = 0 ; i <board.length ; i++) {
			if(!board[i]) {
				board[i] = true;
				queenPermutation(board, currentState+1, totalState, answer+"q"+currentState+"b"+i+" ");
				board[i] = false;
			}
		}
	}
	
}
