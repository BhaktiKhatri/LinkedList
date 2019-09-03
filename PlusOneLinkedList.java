package LinkedList;

import LinkedList.LinkedList.ListNode;

/*
 	369. Plus One Linked List
	https://leetcode.com/problems/plus-one-linked-list/description/
	Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
	You may assume the integer do not contain any leading zero, except the number 0 itself.
	The digits are stored such that the most significant digit is at the head of the list.
	Example: Input: 1->2->3; Output: 1->2->4
	Code from: @hotpro https://leetcode.com/problems/plus-one-linked-list/discuss/84125/Iterative-Two-Pointers-with-dummy-node-Java-O(n)-time-O(1)-space
	Google
	Medium
 */

public class PlusOneLinkedList {

	//123; MSD - 1; LSD - 3; digit starts from MSD
	public static ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode lastNotNine = dummy;
        ListNode node = head;
        
        System.out.println("head: "+head.data);
        
        while(node != null) {
        	System.out.println("node: "+node.data);
            if(node.data != 9) {
                lastNotNine = node;
            }
            node = node.next;
        }
    	System.out.println("node: "+node);
        
        lastNotNine.data++;
        node = lastNotNine.next;
        
        while(node != null) {
            node.data = 0;
            node = node.next;
        }
        
        System.out.println("dummy.data: "+dummy.data);
        return dummy.data == 1 ? dummy : dummy.next;	//for list = 9 only
    }
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		
		list1.head = new ListNode(9);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(9);

		list1.head.next = second;
		second.next = third;
		
		System.out.println("list: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data);
		
		LinkedList result = new LinkedList();
		result.head = plusOne(list1.head);
		
		System.out.println("result: "+result.head.data+" -> "+result.head.next.data+" -> "+result.head.next.next.data);
	}

}
