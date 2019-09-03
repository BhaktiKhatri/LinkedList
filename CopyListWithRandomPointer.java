package LinkedList;

import LinkedList.LinkedList.ListNode;

/*
 * 138. Copy List with Random Pointer
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * Explanation and Code from: https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)
 */

// Definition for singly-linked list with a random pointer.
 class RandomListNode {
     int label;
     public RandomListNode head;
     RandomListNode next, random;
     
     RandomListNode(int x) { 
    	 this.label = x; 
     }
 };

public class CopyListWithRandomPointer {

	public static RandomListNode head;
	
	public static RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode iter = head;
		RandomListNode next;

		// First round: make copy of each node, and link them together side-by-side in a single list
		while (iter != null) {
			next = iter.next;
			
			if(next != null)
				System.out.println("iter: "+iter.label+" next: "+next.label);
			
			RandomListNode copy = new RandomListNode(iter.label);
			System.out.println("copy: "+copy.label);
			iter.next = copy;
			copy.next = next;

			iter = next;
			if(next != null)
				System.out.println("iter: "+iter.label+" next: "+next.label+" copy: "+copy.label);
		}
		//System.out.println("list: "+list1.head.label+" -> "+list1.head.next.label+" -> "+list1.head.next.next.label+" -> "+list1.head.next.next.next.label+" -> "+list1.head.next.next.next.next.label);

		// Second round: assign random pointers for the copy nodes
		iter = head;
		System.out.println("iter: "+iter.label+" -> "+iter.next.label+" -> "+iter.next.next.label+" -> "+iter.next.next.next.label+" -> "+iter.next.next.next.next.label+" -> "+iter.next.next.next.next.next.label+" -> "+iter.next.next.next.next.next.next.label+" -> "+iter.next.next.next.next.next.next.next.label);
		
		while (iter != null) {
			if (iter.random != null) {
				System.out.println("iter: "+iter.label+" iter.random: "+iter.random.label+" iter.random.next: "+iter.random.next.label);
				iter.next.random = iter.random.next;
			}
			iter = iter.next.next;
		}

		// Third round: restore the original list, and extract the copy list
		iter = head;
		RandomListNode pseudoHead = new RandomListNode(0);
		RandomListNode copy;
		RandomListNode copyIter = pseudoHead;

		while(iter != null) {
			next = iter.next.next;

			if(next != null)
				System.out.println("iter: "+iter.label+" next: "+next.label);
			
			// extract the copy
			copy = iter.next;
			copyIter.next = copy;
			copyIter = copy;

			// restore the original list
			iter.next = next;

			iter = next;
		}

		return pseudoHead.next;
	}
	
	public static void main(String[] args) {
		RandomListNode list1 = new RandomListNode(0);
		
		list1.head = new RandomListNode(2);
		RandomListNode second = new RandomListNode(3);
		RandomListNode third = new RandomListNode(5);
		RandomListNode forth = new RandomListNode(7);
		RandomListNode fifth = new RandomListNode(11);

		list1.head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		
		list1.head.random = second;
		second.random = third;
		third.random = forth;
		forth.random = fifth;
		fifth.random = null;
		
		System.out.println("list: "+list1.head.label+" -> "+list1.head.next.label+" -> "+list1.head.next.next.label+" -> "+list1.head.next.next.next.label+" -> "+list1.head.next.next.next.next.label);
		
		RandomListNode result = new RandomListNode(0);
		result = copyRandomList(list1.head);
		
		System.out.println("result: "+result.head);
		
		//System.out.println("result: "+result.head.label+" -> "+result.head.next.label+" -> "+result.head.next.next.label+" -> "+result.head.next.next.next.label+" -> "+result.head.next.next.next.next.label);
	}

}
