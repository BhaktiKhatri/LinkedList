package LinkedList;

import LinkedList.LinkedList.ListNode;

/*
 * 143. Reorder List
 * https://leetcode.com/problems/reorder-list/description/
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * Example 1: Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2: Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * 
 * 11-7-5-3-2
 * 
 * 11-7-5 2-3
 * 
 * 
 */

public class ReorderList {

	public static void reorderList(ListNode head) {
		if(head == null || head.next == null) {
			return;
		}
		
		System.out.println("head: "+head.data);
		
		ListNode slow = head;
		ListNode fast = head;

		//1. find the middle of list
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("slow: "+slow.data+" fast: "+fast.data);
		
		ListNode left = head;
	    ListNode right = slow.next;		//2nd half start from next node of the middle one
	    slow.next = null;
	    System.out.println("left: "+left.data+" right: "+right.data);
	    
	    //2. reverse last half of list
	    right = ReverseLinkedList.reverseLinkedList(right);
	    System.out.println("left: "+left.data+" right: "+right.data);
	    
	    //12345 12543
	    //3. connect 1st half to 2nd half
	    // 11-7-5-3-2 
	    //11-7-5   2-3
	    //11-2-7-5  3-null
	    //11-2-7-3-5
		while(right != null) {
			
			ListNode temp1 = left.next;
			ListNode temp2 = right.next;
			
			if(temp1 != null && temp2 != null) {
				System.out.println("temp1: "+temp1.data+" temp2: "+temp2.data);
			}
			
			left.next = right;
			right.next = temp1;		

			left = temp1;
			right = temp2;
			
			if(left != null && right != null) {
				System.out.println("left: "+left.data+" right: "+right.data);
			}
		}
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
		reorderList(list1.head);
		
		//System.out.println("result: "+result.head.data+" -> "+result.head.next.data+" -> "+result.head.next.next.data+" -> "+result.head.next.next.next.data+" -> "+result.head.next.next.next.next.data);
		System.out.println("list: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data+" -> "+list1.head.next.next.next.data+" -> "+list1.head.next.next.next.next.data);
	}
}