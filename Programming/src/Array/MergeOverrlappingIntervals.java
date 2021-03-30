package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverrlappingIntervals {
	
	public static void main(String[] args) {
		ArrayList<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1, 10));
		list.add(new Interval(2, 9));
		list.add(new Interval(3, 8));
		list.add(new Interval(4, 7));
		list.add(new Interval(5, 6));
		list.add(new Interval(6, 6));
		System.out.println(merge(list));
	}

	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {

		Comparator<Interval> intervalComp = new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				if (o1.start > o2.start) {
					return 1;
				} else {
					return -1;
				}
			}
		};
		
		ArrayList<Interval> outList = new ArrayList<Interval>();
		Collections.sort(intervals, intervalComp);
		
		int overlappingStartTime = intervals.get(0).start;
		int overlappingEndTime = intervals.get(0).end;
		
		for (Interval currentInterval : intervals) {
			
			if (currentInterval.start <= overlappingEndTime) {
				overlappingEndTime = Math.max(overlappingEndTime, currentInterval.end);
			} else {
				outList.add(new Interval(overlappingStartTime, overlappingEndTime));
				overlappingStartTime =currentInterval.start;
				overlappingEndTime =currentInterval.end;
			}
			
		}
		
		outList.add(new Interval(overlappingStartTime, overlappingEndTime));

		return outList;
	}

}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
	
	@Override
	public String toString() {
		return " [start] " + start + ", [end] " + end ;
	}
}
