package LinkedList;

import LinkedList.LinkedList.ListNode;

/*
 * 61. Rotate List
 * https://leetcode.com/problems/rotate-list/description/
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * Example 1: Input: 1->2->3->4->5->NULL, k = 2; Output: 4->5->1->2->3->NULL
 * Explanation: rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2: Input: 0->1->2->NULL, k = 4; Output: 2->0->1->NULL
 * Explanation: rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 * Explanation and Code from: EPI Book
 * Medium
 */

public class CyclicRightShift {

	public static ListNode cyclicallyRightShiftList(ListNode l, int k) {
		if(l == null || k == 0)
			return l;
		
		//Compute the length of l and the tail
		ListNode tail = l;
		int n = 1;
		
		System.out.println("l: "+l.data+" tail: "+tail.data);
		
		while(tail.next != null) {
			System.out.println("n: "+n+" tail.next: "+tail.next.data);
			n++;
			tail = tail.next;
			System.out.println("n: "+n+" tail: "+tail.data);
		}
		
		System.out.println("n: "+n+" k: "+k);
		k = k % n;
		System.out.println("k: "+k);
		
		if(k == 0) {
			return l;
		}
		
		tail.next = l;	//makes a cycle by connecting the tail to the head
		int stepToNewHead = n - k;
		
		System.out.println("tail: "+tail.data+" stepToNewHead: "+stepToNewHead);
		
		while(stepToNewHead-- > 0) {
			System.out.println("stepToNewHead: "+stepToNewHead+" tail.next: "+tail.data);
			tail = tail.next;
			System.out.println("tail: "+tail.data);
		}
		
		System.out.println("tail.next: "+tail.next.data);
		ListNode newHead = tail.next;
		tail.next = null;
		return newHead;
	}
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		
		list1.head = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode forth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		
//		list1.head = new ListNode(10);
//		ListNode second = new ListNode(20);
//		ListNode third = new ListNode(30);
//		ListNode forth = new ListNode(40);
//		ListNode fifth = new ListNode(50);
//		ListNode sixth = new ListNode(60);

		list1.head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
//		fifth.next = sixth;
		
		System.out.println("list: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data+" -> "+list1.head.next.next.next.data+" -> "+list1.head.next.next.next.next.data);
		
		int k = 2;
		
		LinkedList result = new LinkedList();
		result.head = cyclicallyRightShiftList(list1.head, k);
		
		System.out.println("list: "+result.head.data+" -> "+result.head.next.data+" -> "+result.head.next.next.data+" -> "+result.head.next.next.next.data+" -> "+result.head.next.next.next.next.data);
		//System.out.println("result: "+result.head.data+" -> "+result.head.next.data+" -> "+result.head.next.next.data+" -> "+result.head.next.next.next.data+" -> "+result.head.next.next.next.next.data+" -> "+list1.head.next.next.next.next.next.data);
	}

}
