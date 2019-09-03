package LinkedList;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

import LinkedList.LinkedList.ListNode;

class Practice {
	
	public ListNode head;
	
	public static ListNode sortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode slow = head;
		ListNode fast = head.next;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		ListNode left = head;
		ListNode right = slow.next;
		
		slow.next = null;
		
		left = sortList(left);
		right = sortList(right);
		
		return merge(left, right);
	}
	
	public static ListNode merge(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		
		if(l2 == null)
			return l1;
		
		ListNode dummyHead = new ListNode(0);
		ListNode curr = dummyHead;
		
		while(l1 != null && l2 != null) {
			if(l1.data < l2.data) {
				curr.next = l1;
				l1 = l1.next;
			}
			else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		
		curr.next = l1 != null ? l1 : l2;
		
		return dummyHead.next;
	}
	
	public static void main(String[] args) {
		
	}

}
