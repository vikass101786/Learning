package Recurssion;

import java.util.Arrays;

public class IncNumber {
	
	static String arr [] = {"Zero ","One ","Two ", "Three ","Four ","Five ","Six ","Seven ","Eight ","Nine "};
	
	public static void dec(int n) {
		if (n == -1) return;
		System.out.print(n +" ");
		dec(n-1);
		System.out.println();
		System.out.print(n +" ");
	}
	
	public static boolean isSortedArr(int [] arr , int start , int end) {
		if(start == 0 && end == 0) {
			return true;
		}
		if(start == 0 && end == 1) {
			return true;
		}
		
		if(isSortedArr(arr, start -=1, end-=1) && (arr[start] < arr[end])) {
			return true;
		}
		return false;
	}
	
	public static boolean isSortedArr1(int [] arr , int start , int len) {
		if(len == 1) {
			return true;
		}
		
		if(arr[start] < arr[start + 1] && isSortedArr1(arr, start +=1, len-1)) {
			return true;
		}
		
		return false;
	}
	
	public static int powerFn(int num , int pow) {
		if(pow == 0) {
			return 1;
		}
		return num * powerFn(num, pow -1);
	}
	
	public static int fastPower(int num , int pow) {
		if(pow == 0) return 1;
		int smallAns = fastPower(num, pow/2);
		smallAns *= smallAns;
		if((pow&1)==1) {
			return num * fastPower(num, pow/2);
		}
		return smallAns;
	}
	
	static int mulWithoutMulSymbol(int num1 , int num2) {
		if(num2 == 1) {
			return num1;
		}
		
		return num1 + mulWithoutMulSymbol(num1, num2-1);
	}
	
	public static String printNum(int number) {
		if(number / 10 == 0) {
			return arr[number];
		}
		
		return printNum(number/10) + arr[number%10] ;
	}
	
	public static int stringToint(char [] arr , int start , int len) {
		if(len == 1) {
			return Integer.valueOf(String.valueOf(arr[start]));
		}
		
		int n1 = Integer.valueOf(String.valueOf(arr[start])) ;
		Double n2 = Math.pow(10, len-1);
		
		return (n1 * n2.intValue()) + stringToint(arr, start+1, len-1);
	}
	
	public static int linearSearch(int arr [] , int start , int len , int key) {
		if(start == len) {
			return -1;
		}
		
		if(arr[start] == key) {
			return start;
		}
		
		return linearSearch(arr, start+1, len, key);
	}
	
	public static int binarySearch(int arr [] , int key , int start , int end) {
		if(start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if(arr[mid] == key) 
			return mid;
		if(arr[mid] > key)
			return binarySearch(arr, key, start, mid-1);
		else
			return binarySearch(arr, key, mid+1, end);
	}

	
	public static int [] bubbleSort(int arr [] , int start , int end) {
		if(end == 0) {
			return arr ;
		}
		if(start == end) {
			return bubbleSort(arr, 0, end-1);
		}		
		if(arr[start] > arr[start+1]) {
			int temp = arr[start];
			arr[start] = arr[start+1];
			arr[start+1] = temp;
		} 
		return bubbleSort(arr, start+1, end);
	}
	
	static void towerOfHanoi(int n , char source , char destination , char helper) {
		if(n == 0) return;
		towerOfHanoi(n-1, source, helper, destination);
		System.out.println("Move disk " + n +" From " + source + " to " + destination);
		towerOfHanoi(n-1, helper, destination, source);
	}
	
	public static void mergeSort(int [] arr ,  int start , int end) {
		if(start>=end) {
			return;
		}
		int mid = (start+end)/2;
		
		int leftArr [] = new int [mid];
		int rightArr [] = new int [end - mid];
		
		for (int i = 0 ; i < leftArr.length ; i++) {
			leftArr[i] = arr[i];
		}
		
		for(int j = 0 ; j< rightArr.length ; j++) {
			rightArr[j] = arr[mid+j];
		}
		
		mergeSort(leftArr, start, mid);
		mergeSort(rightArr, mid+1, end);
		mergeArr(arr , leftArr ,  rightArr);
	}
	
	private static void mergeArr(int[] arr2, int[] leftArr, int[] rightArr) {
		// TODO Auto-generated method stub
		int l = 0 , r = 0 ;
		int k = 0 ;
		
		while(l < leftArr.length && r < rightArr.length) {
			if(leftArr[l] < rightArr[r]) {
				arr2[k] = leftArr[l];
				l++;
			}else {
				arr2[k] = rightArr[r];
				r++;
			}
			k++;
		}
		
		while (l < leftArr.length) {
				arr2[k] = leftArr[l];
				l++;k++;
		}
		
		while (r < rightArr.length) {
				arr2[k] = rightArr[l];
				r++;k++;
		}
	}
	
	static void subSequence(char[] in , char [] out , int i , int j) {
		if(in[i] == '\0') {
			out[j] = '\0';
			System.out.print(out);
			System.out.print(" ");
			return;
		}
		out[j] = in[i];
		subSequence(in, out, i+1, j+1);
		subSequence(in, out, i+1, j);
		
	}

	public static void main(String[] args) {
		dec(10);
		int arr [] = {1,2,3,4,5,6,7,8,9};
		System.out.println();
		System.out.println(isSortedArr(arr, arr.length - 1, arr.length));
		System.out.println();
		System.out.println(isSortedArr1(arr, 0, arr.length));
		System.out.println(powerFn(3, 4));
		System.out.println(fastPower(3, 4));
		System.out.println(printNum(1234567890));
		System.out.println(mulWithoutMulSymbol(4, 5));
		char chrArr [] = {'1','2','3','4','7'};
		System.out.println(stringToint(chrArr, 0, chrArr.length));
		System.out.println("key is available in array " + ( linearSearch(arr, 0, arr.length, 9) != -1));
		System.out.println(binarySearch(arr, 9, 0, arr.length-1));
		int bubbleSrtArr [] = {5,4,1,2};
		int retArr [] = bubbleSort(bubbleSrtArr, 0, bubbleSrtArr.length - 1);
		System.out.println(retArr);
		towerOfHanoi(5, 'A', 'C', 'B');
		int mergeArr [] = {5,1,2,4,6,9,3,7};
	//	mergeSort(mergeArr, 0, mergeArr.length);
		System.out.println(mergeArr);
		String name = "abc";
		String check = name + '\0';
		char nameArr [] = check.toCharArray();
		System.out.println(nameArr);
		
		char out [] = new char [nameArr.length];
		
		subSequence(nameArr, out, 0, 0);
		String strArrr [] = {"abc","ab","ac","a","bc","b","c"};
		Arrays.sort(strArrr);
		System.out.println(strArrr);
		
		for(char k : nameArr) {
			System.out.println(k + "-----");
		}
	}
	
}
