package Recurssion;

import java.util.ArrayList;
import java.util.List;

public class SplitArrIntoFibSeq {

    List<Integer> mainList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new SplitArrIntoFibSeq().splitIntoFibonacci("35813"));
        System.out.println(new SplitArrIntoFibSeq().splitIntoFibonacci("11235813"));
        System.out.println(new SplitArrIntoFibSeq().splitIntoFibonacci("112358130"));
    }

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
         splitIntoFibonacciUtility(S,1,mainList,list);
         return list;
    }

    public void splitIntoFibonacciUtility(String input,int index, List<Integer> mainList, List<Integer> list) {
        if(input.length() == 0) {
            if(list.size() >= 3) {
            mainList = new ArrayList<Integer>(list);
            System.out.println(mainList);
            }
            return;
        }
        for (int i = index; i < input.length(); i++) {
            String part = input.substring(0, index);
            String rem = input.substring(index);
            Integer num = Integer.valueOf(part);
            if(isFibSeq(list, num)) {
            list.add(num);
            splitIntoFibonacciUtility(rem, i, mainList, list);
            list.remove(list.size() - 1);
            }
        }
    }

    private boolean isFibSeq(List<Integer> list, Integer num) {
    	if(list.size() <= 2) {
    		return true;
    	}
        return list.get(list.size() -1)
                + list.get(list.size() -2) == num;
    }

}
