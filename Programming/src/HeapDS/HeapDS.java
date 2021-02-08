package HeapDS;

import java.util.ArrayList;
import java.util.List;

public class HeapDS {
	
	
	List<Integer> list = new ArrayList<Integer>();
	boolean minHeap;
	
	public HeapDS(boolean minHeap) {
		// TODO Auto-generated constructor stub
		list.add(-1);
		this.minHeap = minHeap;
		
	}
	
	public boolean compare(int a , int b) {
		if(minHeap) {
			return a < b;
		} 
		else {
			return b < a;
		}
	}
	
	public void add(int data) {
		list.add(data);
		int current_index = list.size()-1;
		int parent_index = current_index / 2;
		
		while (current_index > 1 && compare(list.get(current_index), list.get(parent_index))) {
			swap(current_index,parent_index);
			current_index = parent_index;
			parent_index = parent_index / 2;
		}
	}

	private void swap(int current_index, int parent_index) {
		// TODO Auto-generated method stub
		int temp = list.get(parent_index);
		list.set(parent_index, list.get(current_index));
		list.set(current_index, temp);
	}
	
	public Integer peek() {
		return list.get(1);
	}
	
	public boolean isEmpty() {
		return list.size() == 1;
	}
	
	public int getSize() {
		return list.size() -1;
	}
	
	public int poll() {
		int num = list.get(1);
		heapify();
		return num;
	}
	
	private void heapify() {
		int last_element = list.remove(getSize());
		if (list.size() > 1) {
		list.set(1, last_element);
		int current_index = 1;
		int left = current_index * 2;
		int right = left + 1;
		while (current_index < getSize() && right < getSize() &&
				compare(Math.max(list.get(left), list.get(right)),list.get(current_index))) {
			int bigger_index;
			if (list.get(left) > list.get(right)) {
				bigger_index = left;
			} else {
				bigger_index = right;
			}
			swap(current_index, bigger_index);
			current_index = bigger_index;
			left = current_index * 2;
			right = left + 1;
		}
		}
	}

	public static void main(String[] args) {
		HeapDS heap = new HeapDS(false);
		heap.add(2);
		System.out.println(heap.peek());
		heap.add(4);
		System.out.println(heap.peek());
		heap.add(3);
		System.out.println(heap.peek());
		heap.add(6);
		System.out.println(heap.peek());
		heap.add(5);
		System.out.println(heap.peek());
		System.out.println(heap.poll());
		System.out.println(heap.peek());
	}
}
