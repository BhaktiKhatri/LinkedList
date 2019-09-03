package LinkedList;

import LinkedList.LinkedList.ListNode;

/*
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/description/
 * Reverse a singly linked list.
 * Example: Input: 1->2->3->4->5->NULL; Output: 5->4->3->2->1->NULL
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 * Microsoft, Facebook, Apple, Amazon, Bloomberg, Uber, Twitter, Snapchat, Zenefits, Yelp, Yahoo, Adobe
 * Easy
 */

public class ReverseLinkedList {

	public static ListNode reverseLinkedList(ListNode list) {
		if(list == null)
            return null;
		
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = list;
		ListNode sublistHead = dummyHead;			//0
		ListNode sublistIter = sublistHead.next;	//11
		int count = 0;
		
		while(list != null) {
			System.out.println("list: "+list.data+" count: "+count);
			count++;
			list = list.next;
		}
		
		int start = 1;
		
		while(start++ < count) {	//while(sublistIter.next != null)
			System.out.println("start: "+start+" count: "+count);
			System.out.println("sublistIter: "+sublistIter.data+" sublistIter.next: "+sublistIter.next.data);
			
			ListNode temp = sublistIter.next;		
			System.out.println("temp: "+temp.data);
			
			sublistIter.next = temp.next;			
			System.out.println("sublistIter: "+sublistIter.data);
			
			temp.next = sublistHead.next;
			System.out.println("temp: "+temp.data+" temp.next: "+temp.next.data+" sublistHead: "+sublistHead.data+" sublistHead.next: "+sublistHead.next.data);
			
			sublistHead.next = temp;
			System.out.println("temp: "+temp.data+" temp.next: "+temp.next.data+" sublistHead: "+sublistHead.data+" sublistHead.next: "+sublistHead.next.data);
		}
		
		return dummyHead.next;
	}
	
	public static ListNode reverseList(ListNode head) {
	    /* iterative solution */
	    ListNode newHead = null;
	    
	    System.out.println("head: "+head.data);
	    
	    while(head != null) {
	        System.out.println("head: "+head.data);
	    	
	        ListNode next = head.next;
	        if(next != null)
	        	System.out.println("next: "+next.data);
	        
	        head.next = newHead;
	        
	        newHead = head;
	        System.out.println("newHead: "+newHead.data);
	        
	        head = next;
	    }
	    return newHead;
	}
	
	//Refer this
	//Code from: https://github.com/OutcoSF/outcode-40-java-BhaktiKhatri/blob/master/target_practice_solutions/06_linked_list.java
	/*
	 * prev = null
	 * 
	 * 11 - 7 - 5 - 3 - 2
	 * c   n
	 * 
	 * 11 - null  7-5-3-2
	 * p		  c	n
	 * 
	 * 7 - 11 - null  5 - 3 -2 
	 * p              c   n
	 * 
	 * 5 - 7 - 11 - null  3 - 2
	 * p                  c   n
	 * 
	 * 3 - 5 - 7 - 11 - null    2
	 * p						c
	 * 
	 *   2 - 3 - 5 - 7 - 11
	 */
	public static ListNode reverse(ListNode node) {
		if(node == null) {
	      return node;
	    }
		
		System.out.println("node: "+node.data);
		
	    ListNode prev = null;
	    ListNode current = node;
	    ListNode next;
	    
	    System.out.println("current: "+current.data);
	    
	    while(current != null) {
	      
	      next = current.next;
	      
	      current.next = prev;
	      prev = current;
	      System.out.println("current: "+current.data+" prev: "+prev.data);
	      
	      current = next;
	    }

	    return prev;
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
		//result.head = reverseLinkedList(list1.head);
		result.head = reverse(list1.head);
		//result.head = reverseList(list1.head);
		
		System.out.println("result: "+result.head.data+" -> "+result.head.next.data+" -> "+result.head.next.next.data+" -> "+result.head.next.next.next.data+" -> "+result.head.next.next.next.next.data);

	}
}