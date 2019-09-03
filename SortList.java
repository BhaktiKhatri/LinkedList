package LinkedList;

import LinkedList.LinkedList.ListNode;

/*
 * 148. Sort List
 * https://leetcode.com/problems/sort-list/description/
 * Sort a linked list in O(n log n) time using constant space complexity.
 * Example 1: Input: 4->2->1->3; Output: 1->2->3->4
 * Example 2: Input: -1->5->3->4->0; Output: -1->0->3->4->5
 * Explanation and Code from: https://leetcode.com/problems/sort-list/discuss/46714/Java-merge-sort-solution
 * Medium
 */

public class SortList {

	public static ListNode sortList(ListNode head) {
	    if(head == null || head.next == null) 
	    	return head;

	    System.out.println("head: "+head.data);
	    
	    // get middle node, not right if write: *fast = head. Otherwise, {2,1} will not be sorted.
	    ListNode slow = head;
	    ListNode fast = head.next;
	    
	    System.out.println("slow: "+slow.data+" fast: "+fast.data);
	    
	    while(fast != null && fast.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    System.out.println("slow: "+slow.data+" fast: "+fast);
	    
	    ListNode left = head;
	    ListNode right = slow.next;
	    
	    System.out.println("left: "+left.data+" right: "+right.data);
	    
	    slow.next = null;
	    
	    left = sortList(left);
	    System.out.println("left: "+left.data+" right: "+right.data);
	    
	    right = sortList(right);
	    System.out.println("left: "+left.data+" right: "+right.data);
	    
	    return merge(left, right);
	}

	public static ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        
        if(l2 == null)
            return l1;
        
        System.out.println("l1: "+l1.data+" l2: "+l2.data);
        
	    ListNode l = new ListNode(0);
	    ListNode p = l;
	    
	    while(l1 != null && l2 != null) {
	    	System.out.println("l1: "+l1.data+" l2: "+l2.data);
	    	
		      if (l1.data < l2.data) {
		        p.next = l1;
		        l1 = l1.next;
		      } 
		      else {
		        p.next = l2;
		        l2 = l2.next;
		      }
		      p = p.next;
	    }
	    
        p.next = l1 != null ? l1 : l2;
	    
	    return l.next;
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
		result.head = sortList(list1.head);
		
		System.out.println("result: "+result.head.data+" -> "+result.head.next.data+" -> "+result.head.next.next.data+" -> "+result.head.next.next.next.data+" -> "+result.head.next.next.next.next.data);
	}

}
