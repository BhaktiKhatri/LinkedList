package LinkedList;

import LinkedList.LinkedList.ListNode;

/*
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/description/
 * Given a linked list, determine if it has a cycle in it.
 * Follow up: Can you solve it without using extra space?
 * Microsoft, Amazon, Bloomberg, Yahoo
 * Easy
 */

/*
 * 142. Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Note: Do not modify the linked list. Follow up: Can you solve it without using extra space?
 * Medium
 */

public class TestForCyclicity {

	public static ListNode hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		System.out.println("slow: "+slow.data+" fast: "+fast.data);
		
		while(fast != null && fast.next != null) {
			System.out.println("slow.next: "+slow.next.data+" fast.next: "+fast.next.data+" fast.next.next: "+fast.next.next.data);
			slow = slow.next;
			fast = fast.next.next;
			
			System.out.println("in while slow: "+slow.data+" fast: "+fast.data);
			
			if(slow == fast) {
				//There is a cycle, so now lets calculate the cycle length
				int cycleLen = 0;
				do {
					++cycleLen;
					fast = fast.next;
					System.out.println("in do slow: "+slow.data+" fast: "+fast.data);
				} while(slow != fast);
				
				//Finds the start of the cycle
				ListNode cycleLenAdvancedIter = head;
				
				System.out.println("cycleLen: "+cycleLen+" cycleLenAdvancedIter: "+cycleLenAdvancedIter.data);
				//cycleLenAdvancedIter pointer advances cycleLen first
				while(cycleLen-- > 0) {
					System.out.println("cycleLen: "+cycleLen+" cycleLenAdvancedIter: "+cycleLenAdvancedIter.data+" cycleLenAdvancedIter.next: "+cycleLenAdvancedIter.next.data);
					cycleLenAdvancedIter = cycleLenAdvancedIter.next;
					System.out.println("cycleLen: "+cycleLen+" cycleLenAdvancedIter: "+cycleLenAdvancedIter.data);
				}
				
				System.out.println("cycleLen: "+cycleLen+" cycleLenAdvancedIter: "+cycleLenAdvancedIter.data);
				ListNode iter = head;
				//Both iterators advance in tandem
				while(iter != cycleLenAdvancedIter) {
					System.out.println("iter: "+iter.data+" iter.next: "+iter.next.data+" cycleLenAdvancedIter: "+cycleLenAdvancedIter.data+" cycleLenAdvancedIter.next: "+cycleLenAdvancedIter.next.data);
					iter = iter.next;
					cycleLenAdvancedIter = cycleLenAdvancedIter.next;
					System.out.println("iter: "+iter.data+" cycleLenAdvancedIter: "+cycleLenAdvancedIter.data);
				}
				
				System.out.println("iter: "+iter.data);
				return iter;	//iter is the start of the cycle
			}
		}
		
		return null;	//no cycle
	}
	
	//return the start of the linkedlist if it has cycle, null otherwise
	public static ListNode hasCycle1(ListNode head) {
		if(head == null)
			return null;
		
		ListNode fast = head;
		ListNode slow = head;
		
		System.out.println("slow: "+slow.data+" fast: "+fast.data);
		
		while(fast.next != null && fast.next.next != null) {		//fast != null && 
			System.out.println("slow.next: "+slow.next.data+" fast.next: "+fast.next.data+" fast.next.next: "+fast.next.next.data);
			
			slow = slow.next;
			fast = fast.next.next;
			
			System.out.println("slow: "+slow.data+" fast: "+fast.data);
			
			if(slow == fast) {	//There is a cycle
				//Tries to find the start of the cycle
				slow = head;
				System.out.println("slow: "+slow.data+" fast: "+fast.data);
				
				//Both pointers advance at the same time
				while(slow != fast) {
					System.out.println("slow.next: "+slow.next.data+" fast.next: "+fast.next.data);
					slow = slow.next;
					fast = fast.next;
					System.out.println("slow: "+slow.data+" fast: "+fast.data);
				}
				System.out.println("slow: "+slow.data+" fast: "+fast.data);
				return slow;	//slow is the start of the cycle
			}
		}
		return null;	//no cycle
	}
	
	//true if the linkedlist has cycle and false otherwise
	public static boolean hasCycle2(ListNode head) {
		if(head == null) {
			return false;
		}
		
		System.out.println("head: "+head.data);
		
		ListNode slow = head;
		ListNode fast = head;
		
		System.out.println("slow: "+slow.data+" fast: "+fast.data);
		
		while(fast.next != null && fast.next.next != null) {
			
			slow = slow.next;
			fast = fast.next.next;
			
			System.out.println("slow: "+slow.data+" fast: "+fast.data);
			
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.head = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode forth = new ListNode(4);
		ListNode fifth = new ListNode(5);

		list.head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		fifth.next = second;
		
		//System.out.println("list: "+list.head.data+" -> "+list.head.next.data+" -> "+list.head.next.next.data+" -> "+list.head.next.next.next.data+" -> "+list.head.next.next.next.next.data);
		System.out.println("list: "+list.head.data+" -> "+list.head.next.data+" -> "+list.head.next.next.data);
		System.out.println("           ^    |  ");
		System.out.println("           |    v  ");
		System.out.println("           "+list.head.next.next.next.next.data+" <- "+list.head.next.next.next.data);
		
		//ListNode node = hasCycle(list.head);
		//ListNode node = hasCycle1(list.head);
		//System.out.println("cycle start node: "+node.data);
		
		System.out.println(hasCycle1(list.head).data);
	}

}
