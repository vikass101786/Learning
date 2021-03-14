package Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ValidateSudoku {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("53..7....", "6..195...",".98....6.", 
										  "8...6...3", "4..8.3..1", "7...2...6", 
											".6....28.", "...419..5", "....8..79");
		System.out.println(new ValidateSudoku().isValidSudoku(list));
	}
	
	public int isValidSudoku(final List<String> A) {
        Map<Integer, HashSet<String>> verticalMap = new HashMap<Integer, HashSet<String>>();
        Map<Integer, HashSet<String>> horizontalMap = new HashMap<Integer, HashSet<String>>();
        Map<Integer, HashSet<String>> boxMap = new HashMap<Integer, HashSet<String>>();
        
        for (int i = 0 ; i < A.size() ; i++) {
            String elementPositiion = A.get(i);
            for (int j = 0 ; j < elementPositiion.length() ; j++) {
                String currentEle = elementPositiion.charAt(j)+"";
                    if (! currentEle.equals(".")) {
                    	
                    verticalMap.putIfAbsent(j , new HashSet<String>());
                    boolean ifAlreadyExistVertically = verticalMap.get(j).add(currentEle);
                    
                    if (!ifAlreadyExistVertically) return 0;
                    
                    horizontalMap.putIfAbsent(i , new HashSet<String>());
                    boolean ifAlreadyExistHorizontally = horizontalMap.get(i).add(currentEle);
                    
                    if (!ifAlreadyExistHorizontally) return 0;
                    
                    int boxNum = getBoxNum(i, j);
                    boxMap.putIfAbsent(boxNum, new HashSet<String>());
                    boolean isAlreadyExistInBox = boxMap.get(boxNum).add(currentEle);
                    
                    if (!isAlreadyExistInBox) return 0;
                }
            }
        }
        return 1;
    }
	
	private int getBoxNum(int row , int col) {
		int startRow = (row / 3)*3;
		int startCol = (col / 3)*3;
		return ((startRow) + (startCol/3));
	}
	
}
