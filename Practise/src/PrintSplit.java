import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintSplit {
	public static void main(String args[]) {
		// Your Code Here
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int arr[] = new int[len];
		int sum = 0;
		for (int i = 0; i < len; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}

		int target_value = sum / 2;

		List<String[]> listArr = new ArrayList<String[]>();
		for (int i = 0; i < len; i++) {
			printSplitArray(arr, target_value, arr[i], i, i + " ", listArr);
		}

		for (String[] li : listArr) {
			Integer[] answer_arr = new Integer[len + 1];
			int count = 0;
			int nextpart_index = Integer.valueOf(li[li.length - 1]);
			answer_arr[answer_arr.length - 1] = nextpart_index;
			for (int i = 0; i < li.length-1; i++) {
				if (li[count] == null || i != Integer.valueOf(li[count])) {
					answer_arr[nextpart_index] = i;
					nextpart_index++;
				} else {
					answer_arr[count] = Integer.valueOf(li[count]);
					count++;
				}
			}
			
			for (int i = 0 ; i < answer_arr[answer_arr.length - 1] ; i++) {
				System.out.print(arr[answer_arr[i]] + " ");
			}
			System.out.print("and ");
			
			for (int i = answer_arr[answer_arr.length - 1] ; i < answer_arr.length -1 ; i++) {
				System.out.print(arr[answer_arr[i]] +" ");
			}
			System.out.println();
		}
		System.out.println(listArr.size());

	}

	public static void printSplitArray(int[] arr, int target_value, int current_sum, int start_index, String answer,
			List<String[]> listArr) {

		if (target_value == current_sum) {
			String arrSplit[] = answer.split(" ");
			String[] newArr = new String[arr.length + 1];
			for (int i = 0; i < arrSplit.length; i++) {
				newArr[i] = arrSplit[i];
			}
			newArr[newArr.length - 1] = String.valueOf(arrSplit.length);
			listArr.add(newArr);
			return;
		}

		for (int i = 1; i < arr.length; i++) {
			int current_index = start_index + i;
			if ((current_index) < arr.length) {
				int sum = current_sum + arr[current_index];
				if (sum <= target_value) {
					String current_answer = answer + current_index + " ";
					printSplitArray(arr, target_value, sum, current_index, current_answer, listArr);
				}
			}
		}
	}
}
