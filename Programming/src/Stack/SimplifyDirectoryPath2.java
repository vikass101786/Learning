package Stack;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SimplifyDirectoryPath2 {
	public static void main(String args[]) throws IOException {
	      Scanner sc = new Scanner(System.in);
	      String str = sc.next();
	      System.out.println(outPutDirectory(str));
	    }
	    
	    public static String outPutDirectory(String input) {
	      String arr [] = input.split("/");
	      Deque<String> stack = new LinkedList<String>();
	      Queue<Integer> queue = new LinkedList<Integer>();
	      String res = "";
	      for (int i = 0 ; i < arr.length ; i++) {
	        String pattern = "[A-Za-z]+";
	        if(arr[i].matches(pattern)) {
	          stack.push("/"+arr[i]);
	        } else if (arr[i].equals("..")) {
	          if(!stack.isEmpty()) {
	             stack.pop();
	          }
	        }
	      }
	      
	      while(!stack.isEmpty()){
	        res += stack.removeLast(); 
	      }
	      
	      return res;
	    }
}
