package LinkedList;

import LinkedList.LinkedList.ListNode;

/*
 * 86. Partition List
 * https://leetcode.com/problems/partition-list/description/
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * Example: Input: head = 1->4->3->2->5->2, x = 3; Output: 1->2->2->4->3->5
 * Medium
 */

public class ImplementListPivoting {

	public static ListNode listPivoting(ListNode l, int x) {
		
		ListNode lessHead = new ListNode(0);
		ListNode equalHead = new ListNode(0);
		ListNode greaterHead = new ListNode(0);
		
		ListNode lessIter = lessHead;
		ListNode equalIter = equalHead;
		ListNode greaterIter = greaterHead;
		
		System.out.println("lessIter: "+lessIter.data+" equalIter: "+equalIter.data+" greaterIter: "+greaterIter.data);
		
		//Populates the three lists
		ListNode iter = l;
		
		while(iter != null) {
			System.out.println("iter: "+iter.data+" x: "+x);
			
			if(iter.data < x) {
				lessIter.next = iter;	//5-11
				lessIter = iter;
			}
			else if(iter.data == x) {
				equalIter.next = iter;	//7-5-11
				equalIter = iter;
			}
			else {	//iter.data > x
				greaterIter.next = iter;	//11
				greaterIter = iter;
			}
			iter = iter.next;
		}
		
		//Combine the 3 lists
		greaterIter.next = null;
		equalIter.next = greaterHead.next;	//0-11-11
		lessIter.next = equalHead.next;	//0-7-5-11
		
		return lessHead.next;
	}
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		
		list1.head = new ListNode(3);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(2);
		ListNode forth = new ListNode(11);
		ListNode fifth = new ListNode(7);
		ListNode sixth = new ListNode(5);
		ListNode seventh = new ListNode(11);
		
		list1.head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		fifth.next = sixth;
		sixth.next = seventh;
		
		System.out.println("list: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data+" -> "+list1.head.next.next.next.data+" -> "+list1.head.next.next.next.next.data+" -> "+list1.head.next.next.next.next.next.data+" -> "+list1.head.next.next.next.next.next.next.data);

		int pivot = 7;
		LinkedList result = new LinkedList();
		result.head = listPivoting(list1.head, pivot);
		
		System.out.println("result: "+result.head.data+" -> "+result.head.next.data+" -> "+result.head.next.next.data+" -> "+result.head.next.next.next.data+" -> "+result.head.next.next.next.next.data+" -> "+result.head.next.next.next.next.next.data+" -> "+result.head.next.next.next.next.next.next.data);
	}

}
