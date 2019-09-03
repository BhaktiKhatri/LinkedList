package LinkedList;

import LinkedList.LinkedList.ListNode;

public class RemoveDuplicates {

	/*
	 * 83. Remove Duplicates from Sorted List
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.
	 * Example 1: Input: 1->1->2; Output: 1->2
	 * Example 2: Input: 1->1->2->3->3; Output: 1->2->3
	 * Explanation and Code from: EPI Book
	 * Because each node in the list is checked exactly once to determine if it is a duplicate or not, the total run time is O(n), where n is the number of nodes in the list.
	 * Space complexity is O(1) since no additional space is used.
	 * Easy
	 */
	public static ListNode removeDuplicates(ListNode l) {
		ListNode iter = l;
		System.out.println("iter: "+iter.data);
		
		while(iter != null) {
			//Uses nextDistinct to find the next distinct value
			if(iter.next != null)
			System.out.println("iter: "+iter.data+" iter.next.data: "+iter.next.data);
			
			ListNode nextDistinct = iter.next;
			if(nextDistinct!= null)
			System.out.println("nextDistinct.data: "+nextDistinct.data+" iter.data: "+iter.data);
			
			while(nextDistinct != null && nextDistinct.data == iter.data) {
				if(nextDistinct.next != null)
					System.out.println("nextDistinct.next.data: "+nextDistinct.next.data);
				nextDistinct = nextDistinct.next;
				if(nextDistinct != null)
					System.out.println("nextDistinct.data: "+nextDistinct.data);
			}
			
			if(nextDistinct != null)
				System.out.println("nextDistinct.data: "+nextDistinct.data);
			iter.next = nextDistinct;
			System.out.println("iter: "+iter.data+" iter.next.data: "+iter.next);
			iter = nextDistinct;
			System.out.println("iter: "+iter);
		}
		return l;
	}
	
	/*
	 *  82. Remove Duplicates from Sorted List II
	 *  https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
	 	Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
	 	For example, Given 1->2->3->3->4->4->5, return 1->2->5;
	 	Given 1->1->1->2->3, return 2->3.
	 	Code from https://www.programcreek.com/2014/06/leetcode-remove-duplicates-from-sorted-list-ii-java/
	 */
	public static ListNode removeDuplicates1(ListNode head) {
		if(head == null || head.next == null) {
            return head;
		}
		System.out.println("head: "+head.data);
		
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
	    ListNode curr = dummyHead;
	    
	    while(curr.next != null && curr.next.next != null) {
	    	System.out.println("curr: "+curr.data+" curr.next: "+curr.next.data+" curr.next.next: "+curr.next.next.data);
	    	
	        if(curr.next.data == curr.next.next.data) {
	            int dup = curr.next.data;
	            System.out.println("dup: "+dup);
	            
	            while(curr.next != null && curr.next.data == dup) {
	                curr.next = curr.next.next;
	            }
	        }
	        else {
	            curr = curr.next;
	        }
	    }
	    return dummyHead.next;
	}
	
	public static ListNode removeDuplicates2(ListNode l) {
		ListNode iter = l;
		
		while(iter != null) {
			//Uses nextDistinct to find the next distinct value
			ListNode nextDistinct = iter.next;
			
			while(nextDistinct != null && nextDistinct.data == iter.data) {
				nextDistinct = nextDistinct.next;
			}
			
			iter.next = nextDistinct;
			iter = nextDistinct;
		}
		return l;
	}
	
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		
//		list1.head = new ListNode(2);
//		ListNode second = new ListNode(2);
//		ListNode third = new ListNode(3);
//		ListNode forth = new ListNode(5);
//		ListNode fifth = new ListNode(7);
//		ListNode sixth = new ListNode(11);
//		ListNode seventh = new ListNode(11);
		
		list1.head = new ListNode(1);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(1);
		ListNode forth = new ListNode(2);
		ListNode fifth = new ListNode(3);
		ListNode sixth = new ListNode(3);
		ListNode seventh = new ListNode(4);

		list1.head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		fifth.next = sixth;
		sixth.next = seventh;
		
		//System.out.println("list: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data+" -> "+list1.head.next.next.next.data+" -> "+list1.head.next.next.next.next.data+" -> "+list1.head.next.next.next.next.next.data+" -> "+list1.head.next.next.next.next.next.next.data);
		System.out.println("list: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data+" -> "+list1.head.next.next.next.data+" -> "+list1.head.next.next.next.next.data+" -> "+list1.head.next.next.next.next.next.data+" -> "+list1.head.next.next.next.next.next.next.data);
		
		LinkedList result = new LinkedList();
		result.head = removeDuplicates1(list1.head);
		
		//System.out.println("result: "+result.head.data+" -> "+result.head.next.data+" -> "+result.head.next.next.data+" -> "+result.head.next.next.next.data);	//+" -> "+result.head.next.next.next.next.data
		System.out.println("result: "+result.head.data+" -> "+result.head.next.data);
	}
}