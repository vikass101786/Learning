package DP;

import java.util.Arrays;
import java.util.Scanner;

public class BoxStacking {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases-- > 0) {
			int boxNum = sc.nextInt();
			Dimension input [] = new Dimension[boxNum];
			for (int i = 0 ; i < boxNum; i++) {
				input[i] = new Dimension(sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
			Dimension allInputs [] = new Dimension[boxNum*3];
			createAllRotation(input,allInputs);
			Arrays.sort(allInputs);
			System.out.println(maxHeight(allInputs));
		}
	}
	
	private static int maxHeight(Dimension[] allInputs) {
		// TODO Auto-generated method stub
		int topBox [] = new int [allInputs.length];
		int dp [] = new int [allInputs.length];
		
		
		for (int i = 0 ; i < allInputs.length ; i++) {
			dp[i] = allInputs[i].height;
			topBox[i] = i;
		}
		
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 1 ; i < allInputs.length ; i++) {
			for (int j = 0 ; j < i ; j++) {
				if(allInputs[j].length > allInputs[i].length && allInputs[j].width > allInputs[i].width) {
					if(dp[j] + allInputs[i].height > dp[i]) {
						dp[i] = dp[j] + allInputs[i].height;
						topBox[i] = j;
						max = dp[i] > max ? dp[i] : max;
					}
				}
			}
		}
		
		return max;
	}

	private static void createAllRotation(Dimension[] input, Dimension[] allInputs) {
		int i = 0;
		for (int j = 0 ; j < input.length ; j++) {
			allInputs[i++] = Dimension.createDimension(input[j].height, input[j].length, input[j].width);
			allInputs[i++] = Dimension.createDimension(input[j].length, input[j].height, input[j].width);
			allInputs[i++] = Dimension.createDimension(input[j].width, input[j].length, input[j].height);
		}
	}

	static class Dimension implements Comparable<Dimension> {
		
		int length ;
		int width;
		int height;
		
		public Dimension(int length , int width , int height) {
			this.length = length;
			this.width = width;
			this.height = height;
		}
		
		public Dimension() {}
		
		@Override
		public int compareTo(Dimension dimension) {
			System.out.println("this.length = " + this.length + " this.width = " + this.width + " dimension.length = " + dimension.length +" dimension.width = " + dimension.width);
			if((this.length * this.width) >= dimension.length * dimension.width) {
				return -1;
			} else {
				return 1;
			}
		}
		
		static Dimension createDimension(int height , int side1 , int side2) {
			Dimension d = new Dimension();
			d.height = height;
			if(side1 >= side2) {
				d.length = side1;
				d.width = side2;
			} else {
				d.length = side2;
				d.width = side1;
			}
			return d;
		}
		
		@Override
		public String toString() {
			return "Dimension [length=" + length + ", width=" + width + ", height=" + height + "]";
		}
	}
	
}
