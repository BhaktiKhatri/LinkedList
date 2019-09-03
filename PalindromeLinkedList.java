package LinkedList;

import LinkedList.LinkedList.ListNode;

/*
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/description/
 * Given a singly linked list, determine if it is a palindrome.
 * Example 1: Input: 1->2; Output: false
 * Example 2: Input: 1->2->2->1; Output: true
 * Follow up: Could you do it in O(n) time and O(1) space?
 * Facebook, Amazon, IXL
 * Easy
 */

public class PalindromeLinkedList {

	public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        System.out.println("head: "+head.data);
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("slow: "+slow.data+" fast: "+fast.data);
        
        ListNode firstHalf = head;
        ListNode secondHalf = reverseList(slow);
        
        System.out.println("firstHalf: "+firstHalf.data+" secondHalf: "+secondHalf.data);
        
        while(firstHalf != null && secondHalf != null) {
        	System.out.println("firstHalf: "+firstHalf.data+" secondHalf: "+secondHalf.data);
            if(firstHalf.data != secondHalf.data) {
                return false;
            }
            
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return true;
    }
    
    public static ListNode reverseList(ListNode list) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = list;
        ListNode sublistHead = dummyHead;
        ListNode sublistIter = sublistHead.next;
        
        while(sublistIter.next != null) {
            ListNode temp = sublistIter.next;
            sublistIter.next = temp.next;
            temp.next = sublistHead.next;
            sublistHead.next = temp;  
        }
        
        return dummyHead.next;
    }
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		
		list1.head = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode forth = new ListNode(2);
		ListNode fifth = new ListNode(1);

		list1.head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		
		System.out.println("list1: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data+" -> "+list1.head.next.next.next.data+" -> "+list1.head.next.next.next.next.data);
		
		System.out.println(isPalindrome(list1.head));
		
	}

}
