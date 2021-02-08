package Recurssion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PhoneKeyPadSubSequence {
	
	 public String [] KEYPAD = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public static void main(String[] args) throws IOException {
		System.out.println();
		int num = Character.getNumericValue('2');
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
		String input = buffReader.readLine();
		List<String> li = findSubSequence(input);
		System.out.println(li);
	}

	private static List<String> findSubSequence(String input) {
		// TODO Auto-generated method stub
		
		if(input.length() == 0) {
			List<String> li = new ArrayList<String>();
			li.add("");
			return li;
		}
		
		char ch = input.charAt(0);
		String remInput = input.substring(1);
		List<String> outPutList = findSubSequence(remInput);
		List<String> newList = new ArrayList<String>();
		for(String val : outPutList) {
			newList.add(val);
			newList.add(ch+val);
			newList.add((int)ch+val);
		}
		
		return newList;
	}
	
}
