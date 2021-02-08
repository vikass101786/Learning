package BackTracking;

//Letter Tile Possibilities -> https://leetcode.com/problems/letter-tile-possibilities/

public class LetterTiles {
	
	int count = 0;

	public static void main(String[] args) {
		System.out.println(new LetterTiles().numTilePossibilities("AAB"));
		System.out.println(new LetterTiles().numTilePossibilities("AAABBC"));
		System.out.println(new LetterTiles().numTilePossibilities("V"));
	}

	public int numTilePossibilities(String tiles) {
		int[] charArr = new int[26];
		for (int i = 0; i < tiles.length(); i++) {
			charArr[tiles.charAt(i) - 'A']++;
		}

		 numTilePossibilitiesUtility(charArr, "", 0);
		 return count-1;
	}

	private void numTilePossibilitiesUtility(int[] charArr, String answer, int vIdx) {
		// TODO Auto-generated method stub

		//System.out.println(answer);
		count++;

		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] > 0) {
				charArr[i]--;
				numTilePossibilitiesUtility(charArr, answer + (char) (i + 'A'), vIdx);
				charArr[i]++;
			}
		}
	}

}
