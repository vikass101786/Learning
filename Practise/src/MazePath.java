import java.util.Scanner;

public class MazePath {
	public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        mazepath_D(len,len, 0, 0, "");
        System.out.println();
        System.out.println(countTotalWays(len,len, 0, 0));
    }

    public static void mazepath_D(int end_row, int end_col, int start_row, int start_col, String answer) {
        if(end_row-1 == start_row && end_col-1 == start_col) {
            System.out.println(answer +" ");
            return;
        }

        if(start_row + 1 < end_row) {
            mazepath_D(end_row, end_col, start_row+1, start_col, answer+"V");
        }

        if(start_col+1 < end_col) {
            mazepath_D(end_row, end_col, start_row, start_col+1, answer+"H");
        }

        if(start_row < 2 && start_col < 2 && start_row + 1 < end_row && start_col+1 < end_col && start_col == start_row) {
            mazepath_D(end_row, end_col, start_row+1, start_col+1, answer+"D");
        }

    }

    public static int countTotalWays(int end_row, int end_col, int start_row, int start_col) {
        if(end_row-1 == start_row && end_col-1 == start_col) {
            return 1;
        }

        int h =0 , l =0, v = 0;
        if(start_col+1 < end_col) {
            h += countTotalWays(end_row, end_col, start_row, start_col+1);
        }

        if(start_row + 1 < end_row) {
           l += countTotalWays(end_row, end_col, start_row+1, start_col);
        }

        if(start_row < 2 && start_col < 2 && start_row + 1 < end_row && start_col+1 < end_col && start_col == start_row) {
           v +=  countTotalWays(end_row, end_col, start_row+1, start_col+1);
        }
    return h+l+v;
    }

}
