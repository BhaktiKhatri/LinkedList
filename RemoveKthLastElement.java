package LinkedList;

import LinkedList.LinkedList.ListNode;

/*
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Example: Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note: Given n will always be valid. Follow up: Could you do this in one pass?
 * Explanation and Code from: EPI Book
 * Time complexity: O(L); The algorithm makes one traversal of the list of L nodes. Therefore time complexity is O(L).
 * Space complexity: O(1); We only used constant extra space.
 * Medium
 */

public class RemoveKthLastElement {

	public static ListNode removeKthLast(ListNode l, int k) {
		System.out.println("l: "+l.data+" k: "+k);
		
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = l;
		ListNode first = dummyHead.next;
		
		System.out.println("dummyHead: "+dummyHead.data+" first: "+first.data);
		//Point first to (k-1)th element i.e. 3
		while(k > 0) {
			System.out.println("k: "+k+" first.next: "+first.next.data);
			first = first.next;
			k--;
			System.out.println("first: "+first.data);
		}
		
		ListNode second = dummyHead;
		System.out.println("second: "+second.data);
		
		//point second to (k+1)th element
		while(first != null) {
			System.out.println("first: "+first.next+" second.next: "+second.next);
			second = second.next;
			first = first.next;
			System.out.println("first: "+first+" second: "+second);
		}
		System.out.println("second.next.next: "+second.next.next.data);
		
		//second points to the (k + 1)th last node, deletes its successor
		second.next = second.next.next;
		System.out.println("second.next: "+second.next.data+" dummyHead.next.data: "+dummyHead.next.data);
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
		
		removeKthLast(list1.head, 3);	//delete 5
		
		System.out.println("list: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data+" -> "+list1.head.next.next.next.data);

	}

}