package Array;

import java.util.ArrayList;
import java.util.List;

public class Heap {
	
	private boolean minHeap = false;
	private List<Integer> li = null;
	
	public Heap(boolean minHeap) {
		this.minHeap = minHeap;
		li = new ArrayList<Integer>();
		li.add(-1);
	}
	
	
	public void add(int value) {
		li.add(value);
		int index = li.size() - 1;
		int parent = index / 2;
		
		while(index > 1 && compare(li.get(index),li.get(parent))) {
			swap(index,parent);
			index = parent;
			parent = parent/2;
		}
	}
    
	public boolean isEmpty() {
		return (li.size() < 2);
	}
	
	public int extractMin() {
		swap(1, li.size() -1);
		int ele = li.remove(li.size() -1);
		//System.out.println(ele);
		heapify(1);
		return ele;
	}

	private void heapify(int index) {
		// TODO Auto-generated method stub
		int minIndex = index;
		int left = 2*index;
		int right = 2*index + 1;
		
		if(left < li.size()  && compare(li.get(left), li.get(index))) {
			minIndex = left;
		}
		
		if(right < li.size()  && compare(li.get(right), li.get(minIndex))) {
			minIndex = right;
		}
		
		if(minIndex != index) {
			swap(index,minIndex);
			heapify(minIndex);
		}
	}


	private void swap(int child, int parent) {
		// TODO Auto-generated method stub
		int temp = li.get(child);
		li.set(child, li.get(parent));
		li.set(parent, temp);
	}


	private boolean compare(Integer child, Integer parent) {
		// TODO Auto-generated method stub
		return minHeap ? (parent > child) : (parent < child);
	}
	
}
