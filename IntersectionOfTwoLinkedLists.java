package LinkedList;

import LinkedList.LinkedList.ListNode;

/*
 * 160. Intersection of Two Linked Lists
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * 	A:          a1 → a2
 * 	                   	↘
 * 	                     c1 → c2 → c3
 * 	                   	↗            
 * 	B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * Notes: If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * Explanation and Code from: @hpplayer https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
 * Microsoft, Amazon, Bloomberg, Airbnb
 * Easy 
 */

public class IntersectionOfTwoLinkedLists {

	public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) 
			return null;
		
        int lenA = length(headA);
        int lenB = length(headB);
        
        System.out.println("headA: "+headA.data+" headB: "+headB.data+" lenA: "+lenA+" lenB: "+lenB);
        
        //move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        
        System.out.println("headA: "+headA.data+" headB: "+headB.data+" lenA: "+lenA+" lenB: "+lenB);
        
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        
        System.out.println("headA: "+headA.data+" headB: "+headB.data+" lenA: "+lenA+" lenB: "+lenB);
        
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        if(headA != null && headB != null)
        	System.out.println("headA: "+headA.data+" headB: "+headB.data+" lenA: "+lenA+" lenB: "+lenB);
        else
        	System.out.println("headA: "+headA+" headB: "+headB+" lenA: "+lenA+" lenB: "+lenB);
        
        return headA;
    }

    public static int length(ListNode node) {
        int length = 0;
        while(node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
    
    //Final code; Refer this
    //Code from: https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
    /*
	 * We can use two iterations to do that. In the first iteration, we will reset the pointer of one linkedlist to the head of another linkedlist after
	 * it reaches the tail node. In the second iteration, we will move two pointers until they points to the same node. Our operations in first iteration
	 * will help us counteract the difference. So if two linkedlist intersects, the meeting point in second iteration must be the intersection point. 
	 * If the two linked lists have no intersection at all, then the meeting pointer in second iteration must be the tail node of both lists, which is null
	 */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) 
        	return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        //if a & b have different len, then we will stop the loop after second iteration
        while(a != b) {
        	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
        	if(a != null && b != null)
        		System.out.println("a: "+a.data+" b: "+b.data);
        	
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;    
            
            if(a != null && b != null)
            	System.out.println("a: "+a.data+" b: "+b.data);
        }
        
        return a;
    }
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		
		list1.head = new ListNode(3);
		ListNode second = new ListNode(6);
		ListNode third = new ListNode(9);
		ListNode forth = new ListNode(15);
		ListNode fifth = new ListNode(30);
		
		list1.head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		
		System.out.println("list1: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data+" -> "+list1.head.next.next.next.data+" -> "+list1.head.next.next.next.next.data);
		
		LinkedList list2 = new LinkedList();
		
		list2.head = new ListNode(10);
		ListNode second2 = new ListNode(15);
		ListNode third2 = new ListNode(30);

		list2.head.next = forth;
		forth.next = fifth;
		//second2.next = third2;
		
		System.out.println("list2: "+list2.head.data+" -> "+list2.head.next.data+" -> "+list2.head.next.next.data);
		
		LinkedList result = new LinkedList();
		result.head = getIntersectionNode1(list1.head, list2.head);
		
		System.out.println("result: "+result.head.data);

	}

}
