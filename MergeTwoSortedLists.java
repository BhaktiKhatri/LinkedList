package LinkedList;

import LinkedList.LinkedList.ListNode;

/*
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * Example: Input: 1->2->4, 1->3->4; Output: 1->1->2->3->4->4
 * Explanation and Code from: EPI Book
 * Microsoft, Amazon, LinkedIn, Apple
 * Easy
 */

public class MergeTwoSortedLists {

	public ListNode head;
	
	public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
		//Creates a placeholder for the result
		ListNode dummyHead = new ListNode(0);
		ListNode current = dummyHead;
		
		System.out.println("l1: "+l1.data+" l2: "+l2.data);
		while(l1 != null && l2 != null) {
			System.out.println("l1: "+l1.data+" l2: "+l2.data);
			if(l1.data <= l2.data) {
				current.next = l1;
				l1 = l1.next;
			}
			else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
			if(l1 != null && l2 != null)
				System.out.println("l1: "+l1.data+" l2: "+l2.data+" current: "+current.data);
		}
		
		//Appends the remaining nodes of p1 or p2
		current.next = l1 != null ? l1 : l2;
		return dummyHead.next;
	}
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		
		list1.head = new ListNode(2);
		ListNode second = new ListNode(5);
		ListNode third = new ListNode(7);

		list1.head.next = second;
		second.next = third;
		
		System.out.println("list1: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data);
		
		LinkedList list2 = new LinkedList();
		list2.head = new ListNode(3);
		ListNode second2 = new ListNode(11);

		list2.head.next = second2;
		
		System.out.println("list2: "+list2.head.data+" -> "+list2.head.next.data);
		
		LinkedList result = new LinkedList();
		result.head = mergeTwoSortedLists(list1.head, list2.head);
		
		System.out.println("result: "+result.head.data+" -> "+result.head.next.data+" -> "+result.head.next.next.data+" -> "+result.head.next.next.next.data+" -> "+result.head.next.next.next.next.data);
	}

}
