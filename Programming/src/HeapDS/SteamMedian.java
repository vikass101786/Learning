package HeapDS;

public class SteamMedian {
	
	static HeapDS minHeap = new HeapDS(true);
	static HeapDS maxHeap = new HeapDS(false);
	static int median = 0;
	
	public static void findMedian(int data) {
		CalculateMedian(data);
		System.out.println(" [ num ] ::" + data + "  [ median ] :: " + median);
	}
	
	private static void CalculateMedian(int data) {
		
		if(minHeap.getSize() == 0 && maxHeap.getSize() == 0) {
			maxHeap.add(data);
			median = maxHeap.peek();
			return;
		}
		
		if(minHeap.getSize() > maxHeap.getSize()) {
			
			if(data < median) {
				maxHeap.add(minHeap.poll());
				minHeap.add(data);
			} else {
				maxHeap.add(data);
			}
			median = (maxHeap.peek() + minHeap.peek()) / 2;
			
		} else if (minHeap.getSize() == maxHeap.getSize()) {
			if(data < median) {
				minHeap.add(data);
				median = minHeap.peek();
			} else {
				maxHeap.add(data);
				median = maxHeap.peek();
			}
		} else {
			if(data < median) {
				minHeap.add(maxHeap.poll());
				maxHeap.add(data);
			} else {
				minHeap.add(data);
			}
			median = (minHeap.peek() + maxHeap.peek()) / 2;
		}
	}

}
