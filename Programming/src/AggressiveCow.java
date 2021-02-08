import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCow {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int stalls [] = new int [len];
        int noOfCows = sc.nextInt();
        for (int i = 0 ; i < len ; i++) {
            stalls[i] = sc.nextInt();
        }
        // 1 2 4 8 9
        Arrays.sort(stalls);
        System.out.println(aggrCow(stalls, noOfCows));
    }

    public static int aggrCow(int [] stalls , int noOfCows) {

            int lo = stalls[0];
            int hi = stalls[stalls.length -1];
            int mid = 0;
            noOfCows--;
            while(lo < hi) {
            mid = ((lo + hi) / 2);
                if(isPossible(stalls,noOfCows,mid)) {
                        lo = mid + 1;
                } else {
                        hi = mid - 1;
                }
            }
        return mid;
    }


    public static boolean isPossible(int [] stalls, int noOfCows, int mid) {
            int nextStall = stalls[0] + mid;
            for (int i = 2 ; i < stalls.length && noOfCows > 0 ; i++) {
                if (nextStall <= stalls[i]) {
                    nextStall = stalls[i]+mid;
                    noOfCows--;
                }
            }
            return (noOfCows == 0);
    }
}