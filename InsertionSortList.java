package LinkedList;

import LinkedList.LinkedList.ListNode;

/*
 	147. Insertion Sort List
 	https://leetcode.com/problems/insertion-sort-list/description/
 	Sort a linked list using insertion sort.
 	Algorithm of Insertion Sort:
	Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
	At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
	It repeats until no input elements remain.
	Example 1: Input: 4->2->1->3; Output: 1->2->3->4
	Example 2: Input: -1->5->3->4->0; Output: -1->0->3->4->5
 	Explanation and Code from: @zrythpzhl https://leetcode.com/problems/insertion-sort-list/discuss/46420/An-easy-and-clear-way-to-sort-(-O(1)-space-)
 	Medium
 */

public class InsertionSortList {

	public static ListNode insertionSortList(ListNode head) {
		if(head == null) {
			return head;
		}
		
		ListNode helper = new ListNode(0); 		//new starter of the sorted list
		ListNode cur = head; 					//the node will be inserted
		ListNode pre = helper; 					//insert node between pre and pre.next
		ListNode next = null; 					//the next node will be inserted
		
		//not the end of input list
		while(cur != null) {
			next = cur.next;
			System.out.println("cur: "+cur.data);
			
			if(pre != null || pre.next != null || pre.next.data >= cur.data) {	
				pre = helper;
			}
			System.out.println("before pre: "+pre.data+" helper: "+helper.data);
			
			//find the right place to insert
			while(pre.next != null && pre.next.data < cur.data) {		//pre and helper changes here; when cur=8
				pre = pre.next;
			}
			System.out.println("after pre: "+pre.data);
			
			//insert between pre and pre.next
			cur.next = pre.next;
			pre.next = cur;
			//pre = helper;
			cur = next;
		}
		
		return helper.next;
	}
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		
		list1.head = new ListNode(6);
		ListNode second = new ListNode(5);
		ListNode third = new ListNode(3);
		ListNode forth = new ListNode(1);
		ListNode fifth = new ListNode(8);
		ListNode sixth = new ListNode(7);
		ListNode seventh = new ListNode(2);
		ListNode eight = new ListNode(4);
		
		//6,5,3,1,8,7,2,4
		list1.head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		fifth.next = sixth;
		sixth.next = seventh;
		seventh.next = eight;
		
		System.out.println("list: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data+" -> "+list1.head.next.next.next.data+" -> "+list1.head.next.next.next.next.data+" -> "+list1.head.next.next.next.next.next.data+" -> "+list1.head.next.next.next.next.next.next.data+" -> "+list1.head.next.next.next.next.next.next.next.data);
		
		LinkedList result = new LinkedList();
		result.head = insertionSortList(list1.head);
		
		System.out.println("result: "+result.head.data+" -> "+result.head.next.data+" -> "+result.head.next.next.data+" -> "+result.head.next.next.next.data+" -> "+result.head.next.next.next.next.data+" -> "+result.head.next.next.next.next.next.data+" -> "+result.head.next.next.next.next.next.next.data+" -> "+result.head.next.next.next.next.next.next.next.data);
	}

}
