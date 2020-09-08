package HeapDS;

import java.util.*;
import java.util.ArrayList;

public class Heap {
    
	boolean minHeap = false;
	List li = null;
	
	boolean compare(int child , int parent) {
		return minHeap  ? (child<parent) : (child>parent);
	} 
	
	public Heap(boolean minHeap) {
		this.minHeap = minHeap;
		li = new ArrayList();	
		li.add(-1);		
	}
	
   void add (int num) {
	   li.add(num);
	   int index = li.size() -1;
	   int parent = index/2;
	   
	   while((index > 1) && (compare((int)li.get(index),(int)li.get(parent)))) {
		   swap(index,parent);
		   index = parent;
		   parent = parent/2;
	   }
   }

   private void swap(int child, int parent) {
	// TODO Auto-generated method stub
		int temp = (int)li.get(child);
		li.set(child, (int)li.get(parent));
		li.set(parent, temp);
   }	
	
   
   int top() {
	   return (int)li.get(1);
   }
   
   void pop() {
	   int index = li.size() - 1;
	   swap(1, index);
	   li.remove(index);
	   heapify(1);
   }
   
   private void heapify(int i) {
	// TODO Auto-generated method stub
	int left = 2*i;
	int right = 2*i + 1;
	int minIndex = i;
	
	
	if(left < li.size() && compare((int)li.get(left), (int)li.get(i))){
		minIndex = left;
	}
	
	if(right < li.size() && compare((int)li.get(right), (int)li.get(minIndex))){
		minIndex = right;
	}
	
	if(minIndex != i) {
		swap(i, minIndex);
		heapify(minIndex);
	}
	
   }
   
   boolean empty() {
	   return li.size() < 2;
   }

public static void main(String[] args) {
	Heap hp = new Heap(true);
	hp.add(2);
	hp.add(10);
	hp.add(0);
	hp.add(3);
	hp.add(4);
	hp.add(5);
	hp.add(1);
	hp.add(20);

	while(!hp.empty()) {
		System.out.println(hp.top());
		hp.pop();
	}
    
}
	
}
