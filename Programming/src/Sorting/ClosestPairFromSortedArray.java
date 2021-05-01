package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ClosestPairFromSortedArray {

	public static void main(String[] args) {
		ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(5, 10, 20));
		ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 2, 30));
		ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(6, 7, 9, 13, 21, 29, 56, 74, 77, 83, 84, 88, 93, 96,
				101, 104, 114, 115, 122, 125, 144, 147, 151, 152, 154, 161, 165, 167, 174, 179, 185, 189, 192, 194, 198,
				201, 203, 208, 224, 229, 230, 238, 252, 253, 257, 264, 266, 275, 278, 279, 282, 284, 291, 312, 316, 322,
				332, 335, 336, 339, 364, 380, 381, 384, 387, 388, 390, 392, 394, 395, 401, 403, 431, 432, 440, 442, 443,
				444, 446, 451, 454, 461, 470, 483, 492));
		ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(2, 8, 13, 16, 19, 21, 22, 23, 37, 48, 63, 66, 68, 71,
				72, 95, 102, 116, 123, 127, 131, 132, 146, 148, 153, 171, 173, 179, 187, 194, 215, 220, 227, 229, 240,
				245, 254, 255, 257, 259, 271, 276, 277, 286, 296, 312, 314, 318, 321, 333, 339, 341, 343, 355, 356, 359,
				363, 364, 380, 390, 393, 398, 401, 409, 413, 417, 427, 442, 444, 446, 454, 455, 459, 460, 468, 471, 473,
				475, 476, 478, 479, 482, 483, 488, 489));
		System.out.println(new ClosestPairFromSortedArray().solve(arr3, arr4, 409));
	}

	/*public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
		int l = 0;
		int r = B.size() - 1;
		int diff = Integer.MAX_VALUE;
		ArrayList<ArrayList<Integer>> list = null;

		while (l < A.size() && r >= 0) {
			int currentDiff = Math.abs((A.get(l) + B.get(r)) - C);
			if (currentDiff < diff) {
				diff = currentDiff;
				list = new ArrayList<>();
				ArrayList<Integer> aux = new ArrayList<>();
				aux.add(A.get(l));
				aux.add(B.get(r));
				list.add(aux);
				l++;
				System.out.println(list);
			} else if (currentDiff == diff) {
				ArrayList<Integer> aux = new ArrayList<>();
				aux.add(A.get(l));
				aux.add(B.get(r));
				list.add(aux);
				
				
				if (l+1 >= A.size() && r-1 >= 0) {
					r--;
					continue;
				}
				
				if (r-1 < 0 && l+1 < A.size()) {
					l++;
					continue;
				}
				
				int nextLeft = A.get(l+1);
				int prevRight = B.get(r-1);
				
				if (Math.abs((nextLeft + B.get(r)-C)) < Math.abs((A.get(l) + prevRight)-C)) {
					l++;
				} else {
					r--;
				}
				System.out.println(list);
			} else if (A.get(l) + B.get(r) > C) {
				r--;
			} else {
				l++;
			}
			
		}

		Comparator<ArrayList<Integer>> arrayListSorter = new Comparator<ArrayList<Integer>>() {

			public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
				if (list1.get(0) == list2.get(0)) {
					if (list1.get(1) > list2.get(1)) {
						return 1;
					} else {
						return -1;
					}
				} else if (list1.get(0) > list2.get(0)) {
					return 1;
				} else {
					return -1;
				}
			}

		};

		Collections.sort(list, arrayListSorter);

		return list.get(0);
	}*/
	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
		int l = 0;
		int r = B.size() - 1;
		int diff = Integer.MAX_VALUE;
		ArrayList<ArrayList<Integer>> list = null;
		
		while (l < A.size() && r >= 0) {
			int currentDiff = Math.abs((A.get(l) + B.get(r)) - C);
			if (currentDiff < diff) {
				diff = currentDiff;
				list = new ArrayList<>();
				ArrayList<Integer> aux = new ArrayList<>();
				aux.add(A.get(l));
				aux.add(B.get(r));
				list.add(aux);
			} else if (currentDiff == diff) {
				ArrayList<Integer> aux = new ArrayList<>();
				aux.add(A.get(l));
				aux.add(B.get(r));
				list.add(aux);
			} 
			
			if (A.get(l) + B.get(r) > C) {
				r--;
			} else {
				l++;
			}
			
		}

		Comparator<ArrayList<Integer>> arrayListSorter = new Comparator<ArrayList<Integer>>() {
			
			public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
				if (list1.get(0) == list2.get(0)) {
					if (list1.get(1) > list2.get(1)) {
						return 1;
					} else {
						return -1;
					}
				} else if (list1.get(0) > list2.get(0)) {
					return 1;
				} else {
					return -1;
				}
			}
			
		};
		Collections.sort(list, arrayListSorter);
		
		return list.get(0);
	}

}
