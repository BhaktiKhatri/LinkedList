package LinkedList;

import LinkedList.LinkedList.ListNode;

/*
 * 24. Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 * Given a linked list, swap every two adjacent nodes and return its head
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3
 * Note: Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * Microsoft, Bloomberg, Uber
 * Medium
 */

public class SwapNodesInPairs {

	public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) { 
        	return head;
        }
        
        ListNode cur = head;
        ListNode newHead = head.next;
        System.out.println("head: "+head.data+" cur: "+cur.data+" newHead: "+newHead.data);
        
        while(cur != null && cur.next != null) {
        	System.out.println("cur: "+cur.data+" cur.next: "+cur.next.data);
        	
            ListNode tmp = cur;			//tmp - 11		5
            cur = cur.next;				//cur - 7		3
            tmp.next = cur.next;		//11.next = 5	5.next = 2
            cur.next = tmp;				//7.next = 11   3.next = 5	//5 is added to 7-11-3-2 here
            cur = tmp.next;				//cur - 5		cur - 2
            
            if(cur != null && cur.next != null) {	//cur.next = 5.next = 3; temp.next = 11.next = 5	
            	System.out.println("cur: "+cur.data+" cur.next: "+cur.next.data+" temp: "+tmp.data+" tmp.next: "+tmp.next.data);
            	tmp.next = cur.next;				//11.next = 3
            }
            
            //if(cur != null || cur.next != null || cur.next.next != null)
            //System.out.println("cur: "+cur.data+" -> "+cur.next.data+" -> "+cur.next.next.data);
            System.out.println("newHead: "+newHead.data+" -> "+newHead.next.data+" -> "+newHead.next.next.data+" -> "+newHead.next.next.next.data);
        }
        return newHead;
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
		
		LinkedList result = new LinkedList();
		result.head = swapPairs(list1.head);
		
		System.out.println("result: "+result.head.data+" -> "+result.head.next.data+" -> "+result.head.next.next.data+" -> "+result.head.next.next.next.data+" -> "+result.head.next.next.next.next.data);
	}

}
