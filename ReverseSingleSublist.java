package LinkedList;

import LinkedList.LinkedList.ListNode;

/*
 * 92. Reverse Linked List II
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 * Reverse a linked list from position m to n. Do it in one-pass. Note: 1 ≤ m ≤ n ≤ length of list.
 * Example: Input: 1->2->3->4->5->NULL, m = 2, n = 4; Output: 1->4->3->2->5->NULL
 * Explanation and Code from: EPI Book
 * Medium
 */

public class ReverseSingleSublist {

	public static ListNode reverseSublist(ListNode l, int start, int finish) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = l;
		ListNode sublistHead = dummyHead;
		int k = 1;
		
		while(k++ < start) {
			System.out.println("k: "+k+" start: "+start+" finish: "+finish+" sublistHead.next: "+sublistHead.next.data);
			sublistHead = sublistHead.next;
		}
		
		//Reverse sublist
		ListNode sublistIter = sublistHead.next;	//11->7  7->5
		while(start++ < finish) {
			System.out.println("start: "+start+" finish: "+finish+" sublistIter.next: "+sublistIter.next.data+" sublistHead.next: "+sublistHead.next.data+" sublistHead: "+sublistHead.data);
			
			ListNode temp = sublistIter.next;	//7->5  7->3
			System.out.println("temp.next.data: "+temp.next.data);
			sublistIter.next = temp.next;	//7->3  7->2
			System.out.println("sublistIter.next.data: "+sublistIter.next.data+" sublistHead.next: "+sublistHead.next.data);
			temp.next = sublistHead.next;	//5->7  3->5
			System.out.println("temp.data: "+temp.data);
			sublistHead.next = temp;	//11->5  11->3
			
			//11-7-5-3-2
			//11-5-7-3-2
			//11-3-5-7-2
		}
		
		return dummyHead.next;
	}
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		
		list1.head = new ListNode(11);
		ListNode second = new ListNode(7);
		ListNode third = new ListNode(5);
		ListNode forth = new ListNode(3);
		ListNode fifth = new ListNode(2);

		list1.head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		
		System.out.println("list: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data+" -> "+list1.head.next.next.next.data+" -> "+list1.head.next.next.next.next.data);
		
		LinkedList result = new LinkedList();
		result.head = reverseSublist(list1.head, 2, 4);
		
		System.out.println("result: "+result.head.data+" -> "+result.head.next.data+" -> "+result.head.next.next.data+" -> "+result.head.next.next.next.data+" -> "+result.head.next.next.next.next.data);

	}

}
