package LinkedList;

import java.util.Arrays;
import java.util.List;

/*
 * 328. Odd Even Linked List
 * https://leetcode.com/problems/odd-even-linked-list/description/
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * Example 1: Input: 1->2->3->4->5->NULL; Output: 1->3->5->2->4->NULL
 * Example 2: Input: 2->1->3->5->6->4->7->NULL; Output: 2->3->6->7->1->5->4->NULL
 * Note: The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on
 * Medium
 */

import LinkedList.LinkedList.ListNode;

public class EvenOddMerge {

	public static ListNode evenOddMerge(ListNode l) {
		if(l == null) {
			return l;
		}
		System.out.println("l: "+l.data);
		
		ListNode oddDummyHead = new ListNode(0);
		ListNode evenDummyHead = new ListNode(0);
		
		List<ListNode> tails = Arrays.asList(oddDummyHead, evenDummyHead);
		System.out.println("tails: "+tails);
		int turn = 0;
		
		for(ListNode iter = l; iter != null; iter = iter.next) {
			System.out.println("iter: "+iter.data+" turn: "+turn+" tails.get(turn): "+tails.get(turn).data+" tails.get(turn).next: "+tails.get(turn).next);
			if(tails.get(turn).next != null)
				System.out.println("tails.get(turn).next: "+tails.get(turn).next.data);
			tails.get(turn).next = iter;
			tails.set(turn, tails.get(turn).next);
			turn = turn ^ 1;
		}
		
		System.out.println("tails.get(0): "+tails.get(0).data+" tails.get(0).next: "+tails.get(0).next+" tails.get(1).next: "+tails.get(1).next.data+" oddDummyHead.next: "+oddDummyHead.next.data);
		
		tails.get(1).next = null;				//6 -> null
		tails.get(0).next = evenDummyHead.next;	//8 -> 3
		
		return oddDummyHead.next;
	}
	
	//Refer this: https://leetcode.com/problems/odd-even-linked-list/discuss/78079/Simple-O(N)-time-O(1)-space-Java-solution.
	public static ListNode oddEvenList(ListNode head) {
	    if(head == null) { 
	    	return head;
	    }
	    
	    ListNode odd = head;	//head: 2-5-8; evenHead: 3-6
	    ListNode even = head.next;
	    ListNode evenHead = even; 
	    
	    System.out.println("head: "+head.data+" odd: "+odd.data+" even: "+even.data+" evenHEad: "+evenHead.data);
	    
	    //1   2   3   4   5
	    //2 - 3 - 5 - 6 - 8
	    //2-5-8-3-6
	    
	    /* First loop				Second loop
	     * 1 3 4 5 - index			3 5
	     * 2-5-6-8					5-8-null
	     * 
	     * 2 4 5 - index			4 6
	     * 3-6-8					6-null
	     * 
	     * 
	     */
	    while(even != null && even.next != null) {
	    		System.out.println("head: "+head.data+" odd: "+odd.data+" even: "+even.data+" evenHEad: "+evenHead.data);
	            
	    		odd.next = odd.next.next;		//2-5-6-8 ; 5-8
	            even.next = even.next.next; 	//3-6-8 ; 6-null
	            odd = odd.next;
	            even = even.next;
	            
	            System.out.println("head: "+head.data+" -> "+head.next.data+" -> "+head.next.next.data);//+" -> "+head.next.next.next.data+" -> "+head.next.next.next.next.data);
	    }
	    odd.next = evenHead; //2-5-8; 3-6; 2-5-8-3-6
	    
	    return head;
	}
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		
		list1.head = new ListNode(2);
		ListNode second = new ListNode(3);
		ListNode third = new ListNode(5);
		ListNode forth = new ListNode(6);
		ListNode fifth = new ListNode(8);

		list1.head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		
		System.out.println("list: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data+" -> "+list1.head.next.next.next.data+" -> "+list1.head.next.next.next.next.data);
		
		LinkedList result = new LinkedList();
		//result.head = evenOddMerge(list1.head);
		result.head = oddEvenList(list1.head);
		
		System.out.println("result: "+result.head.data+" -> "+result.head.next.data+" -> "+result.head.next.next.data+" -> "+result.head.next.next.next.data+" -> "+result.head.next.next.next.next.data);
	}

}
