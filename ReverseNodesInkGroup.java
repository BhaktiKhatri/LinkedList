package LinkedList;

import LinkedList.LinkedList.ListNode;

/*
 * 25. Reverse Nodes in k-Group
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example, Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */

public class ReverseNodesInkGroup {

	public static ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || head.next == null || k == 1) {
			return head;
		}
		
		ListNode curr = head;
	    int count = 0;
	    System.out.println("curr: "+curr.data+" k: "+k);
	    
	    while(curr != null && count != k) { 				// find the k+1 node
	        curr = curr.next;
	        count++;
	    }
	    
	    System.out.println("count: "+count);
	    
	    if(count == k) { 						// if k+1 node is found
	        curr = reverseKGroup(curr, k); 		// reverse list with k+1 node as head
	        System.out.println("curr: "+curr.data);
	        
	        // head - head-pointer to direct part, 
	        // curr - head-pointer to reversed part;
	        while(count-- > 0) { 				// reverse current k-group: 
	        	System.out.println("head: "+head.data+" head.next: "+head.next.data+" curr: "+curr.data);
	        												//head = 1, tmp = head.next = 1.next = 2, curr = (k+1)th node = 4
	            ListNode tmp = head.next;					//tmp = head.next = 1.next = 2 				// tmp - next head in direct part
	            System.out.println("tmp: "+tmp.data);
	            head.next = curr; 							//head.next = 1.next = 2					// preappending "direct" head to the reversed list 
	            curr = head; 								//curr = head = 1    i.e. 4 = 1				// move head of reversed part to a new node
	            head = tmp; 								//head = tmp = 2     i.e. 1 = 2								// move "direct" head to the next node in direct part
	            System.out.println("head: "+head.data+" tmp: "+tmp.data+" curr: "+curr.data);
	        }
	        head = curr;
	    }
	    return head;
	}
	
	//Refer this
	//Explanation and Code from: @CaterJiang https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/11423/Short-but-recursive-Java-code-with-comments
	public static ListNode reverseKGroup1(ListNode head, int k) {
		if(head == null || head.next == null || k == 1) {
			return head;
		}
		
        //1. test weather we have more then k node left, if less then k node left we just return head 
        ListNode node = head;
        int count = 0;
        
        System.out.println("head: "+head.data+" k: "+k);
        
        while(count < k) { 
            if(node == null) {
                return head;
            }
            System.out.println("node: "+node.data+" count: "+count);
            
            node = node.next;
            count = count + 1;
        }
        
        System.out.println("node: "+node.data+" count: "+count);
        
        //2. reverse k node at current level
        ListNode pre = reverseKGroup1(node, k); //pre node point to the the answer of sub-problem 
        
        System.out.println("pre: "+pre.data);
        
        while(count > 0) {
            ListNode next = head.next; 
            System.out.println("next: "+next.data);
            
            head.next = pre;
            System.out.println("head.next: "+head.next.data);
            
            pre = head;
            System.out.println("pre: "+pre.data);
            
            head = next;
            System.out.println("head: "+head.data);
            
            count = count - 1;
            System.out.println("count: "+count);
        }
        System.out.println("pre: "+pre.data);
        
        return pre;
    }
	
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		
		list1.head = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode forth = new ListNode(4);
		ListNode fifth = new ListNode(5);

		list1.head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		
		System.out.println("list: "+list1.head.data+" -> "+list1.head.next.data+" -> "+list1.head.next.next.data+" -> "+list1.head.next.next.next.data+" -> "+list1.head.next.next.next.next.data);
		
		int k = 2;
		LinkedList result = new LinkedList();
		result.head = reverseKGroup1(list1.head, k);

		System.out.println("result: "+result.head.data+" -> "+result.head.next.data+" -> "+result.head.next.next.data+" -> "+result.head.next.next.next.data+" -> "+result.head.next.next.next.next.data);
	}
}