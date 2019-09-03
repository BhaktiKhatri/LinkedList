package LinkedList;

import LinkedList.LinkedList.ListNode;

/*
 * 237. Delete Node in a Linked List
 * https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 * Explanation and Code from: EPI Book
 * Microsoft, Apple, Adobe
 * Easy
 */

public class DeleteNodeFromLinkedList {

	//Assumes nodeToDelete is not tail
	public static void deletionFromList(ListNode nodeToDelete) {
		System.out.println("nodeToDelete: "+nodeToDelete.data+" nodeToDelete.next.data: "+nodeToDelete.next.data);
		
		nodeToDelete.data = nodeToDelete.next.data;
		nodeToDelete.next = nodeToDelete.next.next;
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
		
		deletionFromList(third);	//delete 5
		
		System.out.println("list: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data+" -> "+list1.head.next.next.next.data);
	}

}