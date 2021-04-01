package Array;

import java.util.ArrayList;

public class MergeIntervals {

	public static void main(String[] args) {
		ArrayList<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1, 2));
		list.add(new Interval(3, 6));

		Interval currentValue = new Interval(10, 8);

		System.out.println(new MergeIntervals().insert(list, currentValue));
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

		int start = 0;
		int end = 0;
		int start_index = -1;
		int end_index = -1;

		for (int i = 0; i < intervals.size(); i++) {
			if (intervals.get(i).start <= newInterval.start && intervals.get(i).end >= newInterval.start) {
				start = Math.min(intervals.get(i).start, newInterval.start);
				start_index = i;
			}
		}

		for (int i = 0; i < intervals.size(); i++) {
			if ((intervals.get(i).start <= newInterval.end && intervals.get(i).end <= newInterval.end)
					|| (intervals.get(i).start == newInterval.end) || (intervals.get(i).end <= newInterval.end)) {
				end = Math.max(intervals.get(i).end, newInterval.end);
				end_index = i;
			}
		}

		if (start != 0) {
			Interval new_interval = new Interval(start, end);

			if (start_index != end_index) {
				intervals.remove(end_index);
			}

			intervals.set(start_index, new_interval);
		} else {
			intervals.add(newInterval);
		}
		return intervals;
	}
}
