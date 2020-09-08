package Stack;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class EvaluateTheExp {
	public static void main(String args[]) throws IOException {
		 String regex = "\\d+";
		 //System.out.println("1".matches(regex));
	      //write your code here
	      Scanner sc = new Scanner(System.in);
	      int length = sc.nextInt();
	     
	      
	      Stack<Integer> st = new Stack<Integer>();
	      for (int i = 0 ; i < length ; i++) {
	        String element = sc.next();
	        if(element.matches(regex)) 
	           st.push(Integer.valueOf(element));
	        else{
	          int val1 = st.pop();
	          int val2 = st.pop();
	          switch(element) {
	            case "+":
	              st.push(val2 + val1);
	              break;
	            
	            case "-":
	              st.push(val2 - val1);
	              break;
	            
	            case "*":
	              st.push(val1 * val2);
	              break;
	              
	            case "/":
	              st.push(val2/val1);
	              break;
	          }
	        }
	      }
	      System.out.println(st.pop());
	    }
}
