package LinkedList;

import LinkedList.LinkedList.ListNode;

/*
 * 203. Remove Linked List Elements
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 * Remove all elements from a linked list of integers that have value val.
 * Example: Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * Explanation and Code from: @mscho147 https://leetcode.com/problems/remove-linked-list-elements/discuss/57324/AC-Java-solution
 * Easy
 */

public class RemoveLinkedListElements {

	public static ListNode removeElementsEqualToVal(ListNode head, int val) {
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode cur = dummy;
	    
	    System.out.println("head: "+head.data+" val: "+val);
	    
	    while(cur.next != null) {
	        System.out.println("cur: "+cur.data+" cur.next: "+cur.next.data);
	    	
	    	if(cur.next.data == val) {
	            cur.next = cur.next.next;
	        }
	        else {
	            cur = cur.next;
	        }
	    }
	    return dummy.next;
	}
	
	/*
	 * https://www.geeksforgeeks.org/delete-nodes-list-greater-x/
	 * Delete all the nodes from the list that are greater than x
	 * Given a linked list, the problem is to delete all the nodes from the list that are greater than the specified value x.
	 * Examples: Input : list: 7->3->4->8->5->1; x = 6; Output : 3->4->5->1
	 * Input : list: 1->8->7->3->7->10; x = 7; Output : 1->7->3->7
	 * Just change == sign in if() in above method to >
	 */
	public static ListNode removeElementsGreaterThanVal(ListNode head, int val) {
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode cur = dummy;
	    
	    System.out.println("head: "+head.data+" val: "+val);
	    
	    while(cur.next != null) {
	        System.out.println("cur: "+cur.data+" cur.next: "+cur.next.data);
	    	
	    	if(cur.next.data > val) {
	            cur.next = cur.next.next;
	        }
	        else {
	            cur = cur.next;
	        }
	    }
	    return dummy.next;
	}
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		
		list1.head = new ListNode(11);
		ListNode second = new ListNode(7);
		ListNode third = new ListNode(5);
		ListNode forth = new ListNode(3);
		ListNode fifth = new ListNode(4);
		ListNode sixth = new ListNode(2);

		list1.head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		fifth.next = sixth;
		
		System.out.println("list: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data+" -> "+list1.head.next.next.next.data+" -> "+list1.head.next.next.next.next.data+" -> "+list1.head.next.next.next.next.next.data);
		
		ListNode result = new ListNode(0);
		//result = removeElementsGreaterThanVal(list1.head, 5);		//delete nodes > 5
		//System.out.println("result: "+result.data+" -> "+result.next.data+" -> "+result.next.next.data+" -> "+result.next.next.next.data);
		
		result = removeElementsEqualToVal(list1.head, 5);		//delete 5
		System.out.println("result: "+result.data+" -> "+result.next.data+" -> "+result.next.next.data+" -> "+result.next.next.next.data+" -> "+result.next.next.next.next.data);
	}

}
