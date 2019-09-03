package LinkedList;

import LinkedList.LinkedList.ListNode;

public class TestIfLinkedListIsPalindromic {

	public static boolean isLinkedListAPalindrome(ListNode l) {
		//Finds the second half of l
		ListNode slow = l;
		ListNode fast = l;
		
		System.out.println("slow: "+slow.data+" fast: "+fast.data);
		
		while(fast != null && fast.next != null) {
			System.out.println("slow: "+slow.data+" fast: "+fast.data+" slow.next: "+slow.next.data+" fast.next: "+fast.next.data+" fast.next.next: "+fast.next.next.data);
			
			fast = fast.next.next;
			slow = slow.next;
			
			System.out.println("slow: "+slow.data+" fast: "+fast.data);
		}
		
		//Compare the first half and the reversed second half lists
		ListNode firstHalfIter = l;
		ListNode secondHalfIter = ReverseLinkedList.reverseLinkedList(slow);
		
		System.out.println("firstHalfIter: "+firstHalfIter.data+" secondHalfIter: "+secondHalfIter.data);
		
		//System.out.println("firstHalfIter: "+firstHalfIter+" -> "+firstHalfIter.next+" -> "+firstHalfIter.next.next+" -> "+firstHalfIter.next.next.next+" -> "+firstHalfIter.next.next.next.next);
		
		while(secondHalfIter != null && firstHalfIter != null) {
			System.out.println("firstHalfIter: "+firstHalfIter.data+" secondHalfIter: "+secondHalfIter.data);
			if(secondHalfIter.data != firstHalfIter.data) {
				return false;
			}
			
			secondHalfIter = secondHalfIter.next;
			firstHalfIter = firstHalfIter.next;
			
			if(secondHalfIter != null)
				System.out.println("firstHalfIter: "+firstHalfIter.data+" secondHalfIter: "+secondHalfIter.data);
			else 
				System.out.println("firstHalfIter: "+firstHalfIter+" secondHalfIter: "+secondHalfIter);
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		
		list1.head = new ListNode(2);
		ListNode second = new ListNode(3);
		ListNode third = new ListNode(5);
		ListNode forth = new ListNode(3);
		ListNode fifth = new ListNode(2);
	
		list1.head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
	
		System.out.println("list: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data+" -> "+list1.head.next.next.next.data+" -> "+list1.head.next.next.next.next.data);
		
		System.out.println(isLinkedListAPalindrome(list1.head));
	}

}
