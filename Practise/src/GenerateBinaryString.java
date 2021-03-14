import java.util.Scanner;

public class GenerateBinaryString {

	    public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
	        int test_case = sc.nextInt();
	        for (int i = 0 ; i < test_case ; i++) {
	        String input = sc.next();
	        generateBinaryString(input,0);
	        }
	    }


	    public static void generateBinaryString(String input, int index) {

	        if(index == input.length() -1) {
	            System.out.print(input +" ");
	            return;
	        }


	      if(input.charAt(index) == '?') {
	          String input1 = input.substring(0,index) + 0 + input.substring(index+1);
	          //System.out.println(input1 + " ---111---");
	          generateBinaryString(input1,index+1);
	          String input2 = input.substring(0,index) + 1 + input.substring(index+1);
	          //System.out.println(input2 + " ---222---");
	          generateBinaryString(input2, index+1);
	      } else {
	          generateBinaryString(input, index+1);
	      }
	    }

	}
