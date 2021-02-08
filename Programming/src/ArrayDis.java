import java.util.Scanner;

public class ArrayDis {
	public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int arr [] = new int [len];
        for (int i = 0 ; i < len ; i++) {
            arr[i] = sc.nextInt();
            //System.out.print(arr[i]);
        }
        printArr(arr, 0);
    }

    public static void printArr(int arr [] , int i) {
        if(i >= arr.length)
          return ;
        System.out.print(arr[i] +" ");
        printArr(arr,i+1);
    }
}
