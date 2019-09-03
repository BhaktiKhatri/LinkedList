package LinkedList;

import java.util.Stack;

import LinkedList.LinkedList.ListNode;

/*
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/description/
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example: Input: (2 -> 4 -> 3) + (5 -> 6 -> 4); Output: 7 -> 0 -> 8; Explanation: 342 + 465 = 807.
 * Explanation and Code from: EPI 
 * Microsoft, Amazon, Bloomberg, Airbnb, Adobe
 * Medium
 */

public class AddListBasedIntegers {
	
	/*
	 * LSD comes first	413 + 907 = 1320;
	 * Sometimes abbreviated as LSD, the least significant digit is the lowest digit in a number, located at the far
	 * right of a string. For example, in the number 2006, the "6" is the least significant digit
	 * 
	 * 13 % 10 = 3; right digit 
	 * 13 / 10 = 1; left digit
	 * 
	 * 10 % 10 = 0; 1-9 % 10 = 1-9
	 * 10 / 10 = 1 = carry; 14 / 10 = 1
	 * 
	 * Example: 59 + 5 = 64; l1: 9->5; l2: 5-> null; result: 0 -> 4 -> 6
	 * Example: 5 + 5 = 10; l1: 5 -> null; l2: 5 -> null; result: 0 -> 1 
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode placeIter = dummyHead;
		int carry = 0;
		
		System.out.println("l1: "+l1.data+" l2: "+l2.data+" 14%10 "+(14%10));
		
		while(l1 != null || l2 != null || carry != 0) {
			
			if(l1 != null && l2 != null)
				System.out.println("l1: "+l1.data+" l2: "+l2.data+" carry: "+carry);
			
			int val = carry + (l1 != null ? l1.data : 0) + (l2 != null ? l2.data : 0);
			System.out.println("val: "+val);
			
			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
			
			if(l1 != null && l2 != null)
				System.out.println("l1: "+l1.data+" l2: "+l2.data+" val % 10: "+(val % 10)+" val / 10: "+(val / 10)+" placeIter: "+placeIter.data);
			
			placeIter.next = new ListNode(val % 10);
			carry = val / 10;
			placeIter = placeIter.next;
			
			System.out.println("placeIter: "+placeIter.data+" carry: "+carry);
		}
		
		return dummyHead.next;
	}
	
	/*
	 * 445. Add Two Numbers II
	 * https://leetcode.com/problems/add-two-numbers-ii/description/
	 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
	 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	 * Follow up: What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
	 * Example: Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4); Output: 7 -> 8 -> 0 -> 7
	 * Microsoft, Bloomberg
	 * Medium
	 */
	
		//MSD comes first - MSD is leftmost digit
		public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
	        Stack<Integer> s1 = new Stack<Integer>();
	        Stack<Integer> s2 = new Stack<Integer>();
	        Stack<Integer> result = new Stack<Integer>();
	        
	        while(l1 != null) {
	        	System.out.println("l1: "+l1.data);
	            s1.push(l1.data);
	            l1 = l1.next;
	        }
	        System.out.println("s1: "+s1);
	        
	        while(l2 != null) {
	        	System.out.println("l2: "+l2.data);
	            s2.push(l2.data);
	            l2 = l2.next;
	        }
	        System.out.println("s2: "+s2);
	        
	        ListNode dummyHead = new ListNode(0);
	        ListNode placeIter = dummyHead; 
	        int carry = 0;
	        
	        while (!s1.empty() || !s2.empty() || carry != 0) {
	        	int val = carry + (!s1.isEmpty() ? s1.pop() : 0) + (!s2.isEmpty() ? s2.pop() : 0);
	        	System.out.println("val: "+val);
	        	result.push(val % 10);
	        	carry = val / 10;
	        }
	        System.out.println("result: "+result);
	        
	        while(!result.isEmpty()) {
	        	placeIter.next = new ListNode(result.pop());
	        	placeIter = placeIter.next;
	        }
	        //1320
	        return dummyHead.next;
	    }

	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		
		//243  342 
		//564  465
		//807  807
		list1.head = new ListNode(2);
		ListNode second = new ListNode(4);
		ListNode third = new ListNode(3);

		list1.head.next = second;
		second.next = third;
		
		System.out.println("list1: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data);
		
		LinkedList list2 = new LinkedList();
		list2.head = new ListNode(5);
		ListNode second2 = new ListNode(6);
		ListNode third2 = new ListNode(4);
		
		list2.head.next = second2;
		second2.next = third2;

		System.out.println("list2: "+list2.head.data+" -> "+list2.head.next.data+" -> "+list2.head.next.next.data);
		
		LinkedList result = new LinkedList();
		result.head = addTwoNumbers1(list1.head, list2.head);
		
		System.out.println("result.head: "+result.head);
		System.out.println("result: "+result.head.data+" -> "+result.head.next.data+" -> "+result.head.next.next.data);	//+" -> "+result.head.next.next.next.data
	}
}