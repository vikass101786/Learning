
import java.io.*;
import java.util.*;

public class TestClass {
	static int minParkingSpaces(int[][] parkingStartEndTimes) {
          // YOUR CODE HERE
		List<Job> list = new ArrayList<Job>();
		int arr [] = new int[parkingStartEndTimes.length];
		Arrays.fill(arr, -1);
		for (int i = 0 ; i < parkingStartEndTimes.length ; i++) {
				list.add(new Job(parkingStartEndTimes[i][0], parkingStartEndTimes[i][1]));
		}
		Collections.sort(list);
		
		int value = 1;
		int lastJobEndTime = 0;
		int count = 0;
		boolean update = true;
		for (Job li : list) {
			update = true;
			arr[count] = li.endTime;
			count++;
			if(li.startTime < lastJobEndTime) {
				for (int i = 0 ; i < arr.length && arr[i] != -1  ; i++) {
					if (li.startTime > arr[i]) {
						update = false;
					}
				}
				if(update) {
				value++;
				}
			}
			lastJobEndTime = li.endTime;
		}
		
		
		return value;
	}
	
	
	public static class Job implements Comparable<Job> {
		
		Integer startTime;
		Integer endTime;
		
		Job(Integer startTime, Integer endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
		
		@Override
		public int compareTo(Job o) {
			// TODO Auto-generated method stub
			return this.startTime.compareTo(o.startTime);
		}
		
	}

	// DO NOT MODIFY ANYTHING BELOW THIS LINE!!

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine().trim());
		int[][] parkingStartEndTimeList = new int[n][2];
		String[] parkingStartEndTimes = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			String[] parkingStartEndTime = parkingStartEndTimes[i].split(",");
			for (int j = 0; j < parkingStartEndTime.length; j++) {
				parkingStartEndTimeList[i][j] = Integer.parseInt(parkingStartEndTime[j]);
			}
		}

		int out = minParkingSpaces(parkingStartEndTimeList);
		System.out.println(out);

		wr.close();
		br.close();
	}
}
