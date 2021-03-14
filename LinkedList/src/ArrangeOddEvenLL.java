import java.util.Scanner;

/* We are Given a singly linked list, group all odd nodes together followed by the even nodes. Here we are talking about the node number and not the value in the nodes.
Note: i) You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
ii) The relative order inside both the even and odd groups should remain as it was in the input.
iii) The first node is considered odd, the second node even and so on

Input Format
First line contains the number of nodes n. Next line contains the n node numbers.

Constraints
1<=Length of linked list<=10^4

Output Format
Print the original list and the modified list after Grouping all odd nodes together followed by the even nodes.

Sample Input
10
1 2 3 4 5 6 7 8 9 10
Sample Output
Original List: 1 2 3 4 5 6 7 8 9 10 
Modified List: 1 3 5 7 9 2 4 6 8 10  
  */
  
public class ArrangeOddEvenLL {
	 public static void main (String args[]) {
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			LLNode head = new LLNode(sc.nextInt()) ;
			LLNode temp = head;
			for (int i = 0 ; i < num-1 ; i++) {
				int data = sc.nextInt();
				temp.next = new LLNode(data);
				temp = temp.next;
			}
			print(llInEvenAndOddOrder(head));
	    }

		public static LLNode llInEvenAndOddOrder(LLNode head) {
			LLNode oh = head;
			LLNode ot = oh;
			LLNode eh = head.next;
			LLNode et = eh;
			LLNode temp = eh.next;
			while(temp != null) {
				ot.next = temp;
				ot = temp;
				temp = temp.next;
				ot.next = null;
				if(temp == null) {
					break;
				}
				et.next = temp;
				et = temp;
				temp = temp.next;
				et.next = null;
			}
			ot.next = eh;
			return oh;
		}

		public static void print(LLNode head) {
			while(head != null) {
			System.out.print(head.data +" ");
			head = head.next;
			}
		}



		public static class LLNode {
			int data;
			LLNode next;

			LLNode(int data) {
				this.data=data;
				this.next = null;
			}
		}
	}
