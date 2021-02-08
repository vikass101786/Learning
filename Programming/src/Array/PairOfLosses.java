package Array;

import java.util.*;
public class PairOfLosses {
    static int arr [] ;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for (int i = 0 ; i < test_case ; i++) {
             int len = sc.nextInt();
             int inputArr [] = new int [len];
             for (int j = 0 ; j < len ; j++) {
                 inputArr[j] = sc.nextInt();
             }
             int sum = sc.nextInt();
             //System.out.println(sum);
             arr = new int [sum+1];
             pairOfRoses(inputArr,arr,sum);
        }
    }


    public static void pairOfRoses(int [] inputArr , int [] arr, int sum) {

        for (int i = 0 ; i < inputArr.length ; i++) {
            arr[inputArr[i]]++;
            StringBuilder s1 = new StringBuilder("abc");
            s1.append("def");
        }

        Integer min_diff = Integer.MAX_VALUE;

        String answer = "";

        for (int i = 0 ; i < inputArr.length ; i++) {
            int input1 = inputArr[i];
            int input2 = Math.abs(sum - input1);

            if (arr[input2] != 0) {
                int current_diff = Math.abs(input1 - input2);
                if (current_diff < min_diff) {
                    min_diff = current_diff;
                    answer = input1 + " " + input2;
                }
            }

        }

        System.out.println(answer);

    }

}